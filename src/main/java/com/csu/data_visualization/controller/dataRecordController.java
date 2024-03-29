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
import javax.servlet.http.HttpServletResponse;
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
     * 柱状图数据导入
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/columnar_fileLoad", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String columnar_fileLoad(HttpServletRequest request,@RequestParam("file") MultipartFile file) {

        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 用户:"+request.getSession().getAttribute("userAccount")
                +" 进入columnar_fileLoad函数"+" 参数："+" file:"+file.getOriginalFilename());

        if(!fileUtil.isTxt(file.getOriginalFilename())) {
            return "false";
        }else {
            String result= fileUtil.Analyze(file);
            try {
                URLEncoder.encode(result,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                logger.error(e);
            }
            addRecord(request,file.getOriginalFilename(),"柱状图",result);
            return result;
        }
    }

    /**
     * 柱状图数据模板
     * @param request
     * @return
     */
    @RequestMapping(value = "/columnar_fileDownLoad")
    public void columnar_fileDownLoad(HttpServletRequest request, HttpServletResponse response) {
        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 用户:"+request.getSession().getAttribute("userAccount")
                +" 进入columnar_fileDownLoad函数");
        fileUtil.columnarWriteToTxt(response);
    }

    /**
     * 折线图数据导入
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/line_fileLoad", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String line_fileLoad(HttpServletRequest request,@RequestParam("file") MultipartFile file) {

        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 用户:"+request.getSession().getAttribute("userAccount")
                +" 进入line_fileLoad函数"+" 参数："+" file:"+file.getOriginalFilename());

        if(!fileUtil.isTxt(file.getOriginalFilename())) {
            return "false";
        }else {
            String result= fileUtil.Analyze(file);
            try {
                URLEncoder.encode(result,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                logger.error(e);
            }
            addRecord(request,file.getOriginalFilename(),"折线图",result);
            return result;
        }
    }

    /**
     * 折线图数据模板
     * @param request
     * @return
     */
    @RequestMapping(value = "/line_fileDownLoad")
    public void line_fileDownLoad(HttpServletRequest request, HttpServletResponse response) {
        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 用户:"+request.getSession().getAttribute("userAccount")
                +" 进入line_fileDownLoad函数");
        fileUtil.lineWriteToTxt(response);
    }

    /**
     * 扇形图数据导入
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pie_fileLoad", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String pie_fileLoad(HttpServletRequest request,@RequestParam("file") MultipartFile file) {

        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 用户:"+request.getSession().getAttribute("userAccount")
                +" 进入pie_fileLoad函数"+" 参数："+" file:"+file.getOriginalFilename());
        if(!fileUtil.isTxt(file.getOriginalFilename())) {
            return "false";
        }else {
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

    /**
     * 扇形图数据模板
     * @param request
     * @return
     */
    @RequestMapping(value = "/pie_fileDownLoad")
    public void pie_fileDownLoad(HttpServletRequest request, HttpServletResponse response) {
        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 用户:"+request.getSession().getAttribute("userAccount")
                +" 进入pie_fileDownLoad函数");
        fileUtil.pieWriteToTxt(response);
    }

    /**
     * 雷达图数据导入
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/radar_fileLoad", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String radar_fileLoad(HttpServletRequest request,@RequestParam("file") MultipartFile file) {

        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 用户:"+request.getSession().getAttribute("userAccount")
                +" 进入radar_fileLoad函数"+" 参数："+" file:"+file.getOriginalFilename());
        if(!fileUtil.isTxt(file.getOriginalFilename())) {
            return "false";
        }else {
            String result= fileUtil.Analyze(file);
            try {
                URLEncoder.encode(result,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                logger.error(e);
            }
            addRecord(request,file.getOriginalFilename(),"雷达图",result);
            return result;
        }
    }

    /**
     * 雷达图数据模板
     * @param request
     * @return
     */
    @RequestMapping(value = "/radar_fileDownLoad")
    public void radar_fileDownLoad(HttpServletRequest request, HttpServletResponse response) {
        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 用户:"+request.getSession().getAttribute("userAccount")
                +" 进入radar_fileDownLoad函数");
        fileUtil.radarWriteToTxt(response);
    }

    /**
     * 散点图数据导入
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/scatter_fileLoad", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String scatter_fileLoad(HttpServletRequest request,@RequestParam("file") MultipartFile file) {

        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 用户:"+request.getSession().getAttribute("userAccount")
                +" 进入scatter_fileLoad函数"+" 参数："+" file:"+file.getOriginalFilename());
        if(!fileUtil.isTxt(file.getOriginalFilename())) {
            return "false";
        }else {
            String result= fileUtil.Analyze(file);
            try {
                URLEncoder.encode(result,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                logger.error(e);
            }
            addRecord(request,file.getOriginalFilename(),"散点图",result);
            return result;
        }
    }

    /**
     * 散点图数据模板
     * @param request
     * @return
     */
    @RequestMapping(value = "/scatter_fileDownLoad")
    public void scatter_fileDownLoad(HttpServletRequest request, HttpServletResponse response) {
        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 用户:"+request.getSession().getAttribute("userAccount")
                +" 进入scatter_fileDownLoad函数");
        fileUtil.scatterWriteToTxt(response);
    }


    /**
     * 地图数据导入
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/map_fileLoad", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String map_fileLoad(HttpServletRequest request,@RequestParam("file") MultipartFile file) {

        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 用户:"+request.getSession().getAttribute("userAccount")
                +" 进入map_fileLoad函数"+" 参数："+" file:"+file.getOriginalFilename());
        if(!fileUtil.isTxt(file.getOriginalFilename())) {
            return "false";
        }else {
            String result= fileUtil.Analyze(file);
            try {
                URLEncoder.encode(result,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                logger.error(e);
            }
            addRecord(request,file.getOriginalFilename(),"地图",result);
            return result;
        }
    }

    /**
     * 地图数据模板
     * @param request
     * @return
     */
    @RequestMapping(value = "/map_fileDownLoad")
    public void map_fileDownLoad(HttpServletRequest request, HttpServletResponse response) {
        logger.info("ip:"+ hostUtil.getRemoteHost(request)+" 用户:"+request.getSession().getAttribute("userAccount")
                +" 进入map_fileDownLoad函数");
        fileUtil.mapWriteToTxt(response);
    }
}
