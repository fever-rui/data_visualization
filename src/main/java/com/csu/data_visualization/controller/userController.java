package com.csu.data_visualization.controller;

import com.csu.data_visualization.model.Page;
import com.csu.data_visualization.model.data_record;
import com.csu.data_visualization.model.user;
import com.csu.data_visualization.service.dataRecordService;
import com.csu.data_visualization.service.userService;
import com.csu.data_visualization.util.PageUtil;
import com.csu.data_visualization.util.hostUtil;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by ZhangRui on 2017/3/10.
 */
@Controller
@RequestMapping(value = "/")
public class userController {

    private static final Logger logger = Logger.getLogger(userController.class);

    @Autowired
    private userService userService;
    @Autowired
    private dataRecordService dataRecordService;

    Page page;



    /**
     * 获取所有用户
     * @param model
     * @return ModelAndView
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getAllUsers(ModelAndView model,HttpServletRequest request) {
        logger.info("ip:"+ hostUtil.getRemoteHost(request)+"用户:"+request.getSession().getAttribute("userAccount")
                +" 进入getAllUsers函数 ");
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
    public ModelAndView toLogin(ModelAndView model,HttpServletRequest request) {
        logger.info("ip:"+ hostUtil.getRemoteHost(request) +" toLogin函数转入登录界面 ");
        model.setViewName("/login");
        return model;
    }

    /**
     * 跳转注册界面
     * @param model
     * @return
     */
    @RequestMapping(value = "/registerView", method = RequestMethod.GET)
    public ModelAndView toRegister(ModelAndView model,HttpServletRequest request) {
        logger.info("ip:"+ hostUtil.getRemoteHost(request) +" toRegister函数,转入注册界面 ");
        model.setViewName("register");
        return model;
    }

    /**
     * 跳转至主页
     * @param model
     * @return
     */
    @RequestMapping(value = "/home")
    public ModelAndView toHome(ModelAndView model,HttpServletRequest request) {
        logger.info("ip:"+ hostUtil.getRemoteHost(request)+"用户:"+request.getSession().getAttribute("userAccount")
                +" 进入toHome函数 ");

        //获取记录
        Integer uid=(Integer) request.getSession().getAttribute("uid");
        if(uid==null){
            model.addObject("recordList","-");
        }else{
//            List<data_record> recordList = dataRecordService.getRecordByUid(uid);
            page=PageUtil.createPage(15,dataRecordService.getRecordSize(uid),1);
            List<data_record> recordList = dataRecordService.getAllRecordByUid(uid, page);
            model.addObject("recordList", recordList);
            model.addObject("page",page);
        }
        //设置页面
        model.setViewName("home_page");
        return model;
    }

    /**
     * 跳转至柱状图
     * @param model
     * @return
     */
    @RequestMapping(value = "/chart_columnar")
    public ModelAndView toColumnar(ModelAndView model,HttpServletRequest request) {
        logger.info("ip:"+ hostUtil.getRemoteHost(request)+"用户:"+request.getSession().getAttribute("userAccount")
                +" 进入toColumnar函数 ");
        model.setViewName("chart_columnar");
        return model;
    }

    /**
     * 跳转至折线图
     * @param model
     * @return
     */
    @RequestMapping(value = "/chart_line")
    public ModelAndView toLine(ModelAndView model,HttpServletRequest request) {
        logger.info("ip:"+ hostUtil.getRemoteHost(request)+"用户:"+request.getSession().getAttribute("userAccount")
                +" 进入toLine函数 ");
        model.setViewName("chart_line");
        return model;
    }

    /**
     * 跳转至扇形图
     * @param model
     * @return
     */
    @RequestMapping(value = "/chart_pie")
    public ModelAndView toPie(ModelAndView model,HttpServletRequest request) {
        logger.info("ip:"+ hostUtil.getRemoteHost(request)+"用户:"+request.getSession().getAttribute("userAccount")
                +" 进入toPie函数 ");
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
        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 进入doLogin函数"+" 参数："+" account-"+account
                +" password-"+password);

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
            session.setAttribute("uid",loginUser.getId());
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
    public String doRegister(String account, String name, String password, HttpServletRequest request) {

        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 进入doRegister函数"+" 参数："+" account-"+account
                +" name-"+name+" password-"+password);

        JSONObject result = new JSONObject();
        HttpSession session = request.getSession();
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
            session.setAttribute("userAccount",account);
            session.setAttribute("userName", registerUser.getName());
            session.setAttribute("uid",registerUser.getId());
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

        logger.info("ip:"+ hostUtil.getRemoteHost(request)+"用户:"+request.getSession().getAttribute("userAccount")
                +" 进入exit函数 ");

        HttpSession session=request.getSession();
        session.setAttribute("userName", null);
        session.setAttribute("userAccount", null);
        model.setViewName("login");
        return model;
    }
}
