package com.csu.data_visualization.controller;

import com.csu.data_visualization.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by ZhangRui on 2017/3/10.
 */
@Controller
public class userController {

    @Autowired
    private userService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model) {
        model.addObject( "users", userService.getUsers() );
        model.setViewName("index");
        return model;
    }
}
