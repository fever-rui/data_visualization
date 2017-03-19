package com.csu.data_visualization.controller;

import com.csu.data_visualization.model.user;
import com.csu.data_visualization.service.userService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by ZhangRui on 2017/3/10.
 */
@Controller
@RequestMapping(value = "/")
public class userController {

    @Autowired
    private userService userService;

    /**
     * 获取所有用户
     * @param model
     * @return ModelAndView
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getAllUsers(ModelAndView model) {
        model.addObject("users", userService.getUsers());
        model.setViewName("index");
        return model;
    }

    /**
     * 跳转登录界面
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model) {
        model.setViewName("/login");
        return model;
    }

    /**
     * 跳转注册界面
     * @param model
     * @return
     */
    @RequestMapping(value = "/registerView", method = RequestMethod.GET)
    public ModelAndView toRegister(ModelAndView model) {
        model.setViewName("register");
        return model;
    }

    /**
     * 跳转至主页
     * @param model
     * @return
     */
    @RequestMapping(value = "/home")
    public ModelAndView toHome(ModelAndView model) {
        model.setViewName("home_page");
        return model;
    }

    /**
     * 跳转至柱状图
     * @param model
     * @return
     */
    @RequestMapping(value = "/chart_columnar")
    public ModelAndView toColumnar(ModelAndView model) {
        model.setViewName("chart_columnar");
        return model;
    }

    /**
     * 跳转至折线图
     * @param model
     * @return
     */
    @RequestMapping(value = "/chart_line")
    public ModelAndView toLine(ModelAndView model) {
        model.setViewName("chart_line");
        return model;
    }

    /**
     * 跳转至扇形图
     * @param model
     * @return
     */
    @RequestMapping(value = "/chart_pie")
    public ModelAndView toPie(ModelAndView model) {
        model.setViewName("chart_pie");
        return model;
    }

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(String account, String password, HttpServletRequest request) {
        JSONObject result = new JSONObject();
        HttpSession session = request.getSession();
        if (account == null || password == null || ("").equals(account.trim()) || ("").equals(password.trim())) {
            result.put("result", "false");
            return result.toString();
        }
        account = account.trim();
        password = password.trim();
        user loginUser = userService.getUserByAccount(account);
        if (loginUser == null) {
            result.put("result", "false");
            return result.toString();
        } else if (password.equals(loginUser.getPassword())) {
            session.setAttribute("userAccount",account);
            session.setAttribute("userName", loginUser.getName());
            result.put("result", "true");
            return result.toString();
        } else {
            result.put("result", "false");
            return result.toString();
        }
    }

    /**
     * 注册
     * @param account
     * @param name
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(String account, String name, String password) {
        JSONObject result = new JSONObject();
        if (account == null || name == null || password == null || ("").equals(account.trim()) || ("").equals(name.trim()) || ("").equals(password.trim())) {
            result.put("result", "false");
            return result.toString();
        }
        account = account.trim();
        name = name.trim();
        password = password.trim();
        if (userService.getUserByAccount(account) == null) {
            user registerUser = new user();
            registerUser.setAccount(account);
            registerUser.setName(name);
            registerUser.setPassword(password);
            userService.addUser(registerUser);
            result.put("result", "true");
            return result.toString();
        } else {
            result.put("result", "exist");
            return result.toString();
        }
    }

    /**
     * 退出
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/exit")
    public ModelAndView exit(HttpServletRequest request, ModelAndView model) {
        HttpSession session=request.getSession();
        session.setAttribute("userName", null);
        session.setAttribute("userAccount", null);
        model.setViewName("login");
        return model;
    }
}
