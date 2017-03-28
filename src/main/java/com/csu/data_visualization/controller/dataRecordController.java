package com.csu.data_visualization.controller;

import com.csu.data_visualization.util.fileAnalyze;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.csu.data_visualization.service.dataRecordService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/**
 * Created by ZhangRui on 2017/3/23.
 */
@Controller
@RequestMapping(value = "/record")
public class dataRecordController {

    @Autowired
    private dataRecordService dataRecordService;

    /**
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/columnar_fileLoad", method = RequestMethod.POST)
    public String columnar_fileLoad(@RequestParam("file") MultipartFile file) {
        return fileAnalyze.Analyze(file);
    }

    /**
     * 折线图数据导入
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/line_fileLoad", method = RequestMethod.POST)
    public String line_fileLoad(@RequestParam("file") MultipartFile file) {
        return fileAnalyze.Analyze(file);
    }

    /**
     * 饼状图数据导入
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pie_fileLoad", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String pie_fileLoad(@RequestParam("file") MultipartFile file) {
        String result=fileAnalyze.Analyze(file);
        try {
            URLEncoder.encode(result,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
