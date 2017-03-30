package com.csu.data_visualization.controller;

import com.csu.data_visualization.model.data_record;
import com.csu.data_visualization.util.fileUtil;
import com.csu.data_visualization.util.hostUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.csu.data_visualization.service.dataRecordService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by ZhangRui on 2017/3/23.
 */
@Controller
@RequestMapping(value = "/record")
public class dataRecordController {

    private static final Logger logger = org.apache.log4j.Logger.getLogger(dataRecordController.class);
    @Autowired
    private dataRecordService dataRecordService;


    /**
     * 添加新纪录
     * @param request
     * @param fileName
     * @param chartType
     * @param dataInfo
     * @return
     */
    public boolean addRecord(HttpServletRequest request,String fileName,String chartType,String dataInfo){

        logger.info("用户:"+request.getSession().getAttribute("userAccount")+" 进入addRecord函数 "
                +" 参数: "+" fileName-"+fileName+" chartType-"+chartType+" dataInfo-"+dataInfo);

        HttpSession session=request.getSession();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        data_record record=new data_record();
        record.setData_name(fileName);
        record.setCreate_time(df.format(new Date()));
        record.setData_info(dataInfo);
        record.setChart_type(chartType);
        record.setUid((Integer) session.getAttribute("uid"));
        return dataRecordService.addRecord(record);
    }

    /**
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/columnar_fileLoad", method = RequestMethod.POST)
    public String columnar_fileLoad(HttpServletRequest request,@RequestParam("file") MultipartFile file) {

        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 用户:"+request.getSession().getAttribute("userAccount")
                +" 进入columnar_fileLoad函数"+" 参数："+" file:"+file.getOriginalFilename());

        return fileUtil.Analyze(file);
    }

    /**
     * 折线图数据导入
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/line_fileLoad", method = RequestMethod.POST)
    public String line_fileLoad(HttpServletRequest request,@RequestParam("file") MultipartFile file) {

        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 用户:"+request.getSession().getAttribute("userAccount")
                +" 进入line_fileLoad函数"+" 参数："+" file:"+file.getOriginalFilename());

        return fileUtil.Analyze(file);
    }

    /**
     * 饼状图数据导入
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pie_fileLoad", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String pie_fileLoad(HttpServletRequest request,@RequestParam("file") MultipartFile file) {

        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 用户:"+request.getSession().getAttribute("userAccount")
                +" 进入pie_fileLoad函数"+" 参数："+" file:"+file.getOriginalFilename());

        String result= fileUtil.Analyze(file);
        try {
            URLEncoder.encode(result,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        }
        addRecord(request,file.getOriginalFilename(),"扇形图",result);
        return result;
    }
}
