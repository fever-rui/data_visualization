package com.csu.data_visualization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.csu.data_visualization.service.dataRecordService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ZhangRui on 2017/3/23.
 */
@Controller
@RequestMapping(value = "/record")
public class dataRecordController {

    @Autowired
    private dataRecordService dataRecordService;

    @RequestMapping(value = "/columnar_fileLoad", method = RequestMethod.POST)
    public ModelAndView fileLoad(@RequestParam("file") MultipartFile file, ModelAndView model) {
        String data=file.getOriginalFilename();
        model.setViewName("chart_columnar");
        return model;
    }

}
