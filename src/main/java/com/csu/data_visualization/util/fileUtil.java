package com.csu.data_visualization.util;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by ZhangRui on 2017/3/27.
 * 用于文件操作
 */
public class fileUtil {

    private static final Logger logger=Logger.getLogger(fileUtil.class);

    /**
     * txt文件判定
     * @param  file
     * @return boolean
     */
    public static boolean isTxt(String file){
        logger.info("isTxt函数"+" 参数：file:"+file);
        return file.matches("^.+\\.(?i)(txt)$");
    }

    /**
     * 文件解析
     * @param file
     * @return boolean
     */
    public static String Analyze(MultipartFile file) {
        logger.info("fileAnalyze函数"+" 参数：file:"+file.getOriginalFilename());
        String resultStr = new String();
        try {
            InputStream fis = file.getInputStream();
            InputStreamReader fisr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(fisr);
            String line = "";
            while ((line = br.readLine()) != null) {//获取数据
                resultStr += line.trim();
            }
            br.close();
        } catch (IOException e) {
            logger.error(e);
        }
        return resultStr;
    }

    /**
     * 下载扇形demo文件
     * @param response
     */
    public static void pieWriteToTxt(HttpServletResponse response) {
        logger.info("pieWriteToTxt函数");

        try {
            String fileName = URLEncoder.encode("扇形图demo.txt", "utf-8");
            response.setContentType("text/plain");
            response.addHeader("Content-Disposition",
                    "attachment;filename="+fileName);// filename指定默认的名字
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        }

        BufferedOutputStream buff = null;
        StringBuffer write = new StringBuffer();

        ServletOutputStream outSTr = null;
        try {
            outSTr = response.getOutputStream();
            buff = new BufferedOutputStream(outSTr);

            //获取系统换行符换行
            write.append("{" + System.getProperty("line.separator"));
            write.append("    \"title\": \"test\"," + System.getProperty("line.separator"));
            write.append("    \"data\": [" + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": \"测试1\"," + System.getProperty("line.separator"));
            write.append("            \"value\": 17" + System.getProperty("line.separator"));
            write.append("        }," + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": \"测试2\"," + System.getProperty("line.separator"));
            write.append("            \"value\": 15" + System.getProperty("line.separator"));
            write.append("        }," + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": \"测试3\"," + System.getProperty("line.separator"));
            write.append("            \"value\": 18" + System.getProperty("line.separator"));
            write.append("        }," + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": \"测试4\"," + System.getProperty("line.separator"));
            write.append("            \"value\": 15" + System.getProperty("line.separator"));
            write.append("        }" + System.getProperty("line.separator"));
            write.append("    ]" + System.getProperty("line.separator"));
            write.append("}" + System.getProperty("line.separator"));

            buff.write(write.toString().getBytes("UTF-8"));
            buff.flush();
            buff.close();
        } catch (Exception e) {
            logger.error(e);
        } finally {
            try {
                buff.close();
                outSTr.close();
            } catch (Exception e) {
                logger.error(e);
            }
        }
    }

    /**
     * 下载折线demo文件
     * @param response
     */
    public static void lineWriteToTxt(HttpServletResponse response) {
        logger.info("lineWriteToTxt函数");

        try {
            String fileName = URLEncoder.encode("折线图demo.txt", "utf-8");
            response.setContentType("text/plain");
            response.addHeader("Content-Disposition",
                    "attachment;filename="+fileName);// filename指定默认的名字
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        }


        BufferedOutputStream buff = null;
        StringBuffer write = new StringBuffer();

        ServletOutputStream outSTr = null;
        try {
            outSTr = response.getOutputStream();// 建立
            buff = new BufferedOutputStream(outSTr);

            //获取系统换行符换行
            write.append("{" + System.getProperty("line.separator"));
            write.append("    \"title\": \"test\"," + System.getProperty("line.separator"));
            write.append("    \"xAxis\": [" + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": [\"测试x1\", \"测试x2\", \"测试x3\", \"测试x4\", \"测试x5\", \"测试x6\", \"测试x7\"]" + System.getProperty("line.separator"));
            write.append("        }" + System.getProperty("line.separator"));
            write.append("    ]," + System.getProperty("line.separator"));
            write.append("    \"data\": [" + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": \"测试1\"," + System.getProperty("line.separator"));
            write.append("            \"value\": [10, 12, 21, 54, 260, 830, 710]," + System.getProperty("line.separator"));
            write.append("            \"smooth\": \"\"," + System.getProperty("line.separator"));
            write.append("            \"step\":\"true\"" + System.getProperty("line.separator"));
            write.append("        }," + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": \"测试2\"," + System.getProperty("line.separator"));
            write.append("            \"value\": [30, 182, 434, 791, 390, 30, 10]," + System.getProperty("line.separator"));
            write.append("            \"smooth\": \"\"," + System.getProperty("line.separator"));
            write.append("            \"step\":\"true\"" + System.getProperty("line.separator"));
            write.append("        }," + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": \"测试3\"," + System.getProperty("line.separator"));
            write.append("            \"value\": [1320, 1132, 601, 234, 120, 90, 20]," + System.getProperty("line.separator"));
            write.append("            \"smooth\": \"\"," + System.getProperty("line.separator"));
            write.append("            \"step\":\"true\"" + System.getProperty("line.separator"));
            write.append("        }," + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": \"测试4\"," + System.getProperty("line.separator"));
            write.append("            \"value\": [320,1132, 601, 234, 120, 50, 80]," + System.getProperty("line.separator"));
            write.append("            \"smooth\": \"\"," + System.getProperty("line.separator"));
            write.append("            \"step\":\"true\"" + System.getProperty("line.separator"));
            write.append("        }," + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": \"测试5\"," + System.getProperty("line.separator"));
            write.append("            \"value\": [350,172, 501, 259, 330, 90, 40]," + System.getProperty("line.separator"));
            write.append("            \"smooth\": \"\"," + System.getProperty("line.separator"));
            write.append("            \"step\":\"true\"" + System.getProperty("line.separator"));
            write.append("        }," + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": \"测试6\"," + System.getProperty("line.separator"));
            write.append("            \"value\": [50,272, 301, 159, 130, 50, 70]," + System.getProperty("line.separator"));
            write.append("            \"smooth\": \"\"," + System.getProperty("line.separator"));
            write.append("            \"step\":\"true\"" + System.getProperty("line.separator"));
            write.append("        }," + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": \"测试7\"," + System.getProperty("line.separator"));
            write.append("            \"value\": [1200,272, 501, 259, 30, 150, 10]," + System.getProperty("line.separator"));
            write.append("            \"smooth\": \"\"," + System.getProperty("line.separator"));
            write.append("            \"step\":\"true\"" + System.getProperty("line.separator"));
            write.append("        }," + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": \"测试8\"," + System.getProperty("line.separator"));
            write.append("            \"value\": [950,72, 150, 259, 300, 350, 500]," + System.getProperty("line.separator"));
            write.append("            \"smooth\": \"\"," + System.getProperty("line.separator"));
            write.append("            \"step\":\"true\"" + System.getProperty("line.separator"));
            write.append("        }" + System.getProperty("line.separator"));
            write.append("    ]" + System.getProperty("line.separator"));
            write.append("}" + System.getProperty("line.separator"));

            buff.write(write.toString().getBytes("UTF-8"));
            buff.flush();
            buff.close();
        } catch (Exception e) {
           logger.error(e);
        } finally {
            try {
                buff.close();
                outSTr.close();
            } catch (Exception e) {
                logger.error(e);
            }
        }
    }


    /**
     * 下载柱状demo文件
     * @param response
     */
    public static void columnarWriteToTxt(HttpServletResponse response) {
        logger.info("columnarWriteToTxt函数");

        try {
            String fileName = URLEncoder.encode("柱状图demo.txt", "utf-8");
            response.setContentType("text/plain");
            response.addHeader("Content-Disposition",
                    "attachment;filename="+fileName);// filename指定默认的名字
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        }

        BufferedOutputStream buff = null;
        StringBuffer write = new StringBuffer();

        ServletOutputStream outSTr = null;
        try {
            outSTr = response.getOutputStream();
            buff = new BufferedOutputStream(outSTr);

            //获取系统换行符换行
            write.append("{" + System.getProperty("line.separator"));
            write.append("    \"title\": \"test\"," + System.getProperty("line.separator"));
            write.append("    \"axis\": [" + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": [\"测试x1\", \"测试x2\", \"测试x3\", \"测试x4\", \"测试x5\", \"测试x6\", \"测试x7\"]" + System.getProperty("line.separator"));
            write.append("        }" + System.getProperty("line.separator"));
            write.append("    ]," + System.getProperty("line.separator"));
            write.append("    \"data\": [" + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": \"测试1\"," + System.getProperty("line.separator"));
            write.append("            \"value\": [10, 12, 21, 54, 260, 830, 710]," + System.getProperty("line.separator"));
            write.append("            \"smooth\": \"\"," + System.getProperty("line.separator"));
            write.append("            \"step\":\"true\"" + System.getProperty("line.separator"));
            write.append("        }," + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": \"测试2\"," + System.getProperty("line.separator"));
            write.append("            \"value\": [30, 182, 434, 791, 390, 30, 10]," + System.getProperty("line.separator"));
            write.append("            \"smooth\": \"\"," + System.getProperty("line.separator"));
            write.append("            \"step\":\"true\"" + System.getProperty("line.separator"));
            write.append("        }," + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": \"测试3\"," + System.getProperty("line.separator"));
            write.append("            \"value\": [1320, 1132, 601, 234, 120, 90, 20]," + System.getProperty("line.separator"));
            write.append("            \"smooth\": \"\"," + System.getProperty("line.separator"));
            write.append("            \"step\":\"true\"" + System.getProperty("line.separator"));
            write.append("        }," + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("            \"name\": \"测试4\"," + System.getProperty("line.separator"));
            write.append("            \"value\": [320,1132, 601, 234, 120, 50, 80]," + System.getProperty("line.separator"));
            write.append("            \"smooth\": \"\"," + System.getProperty("line.separator"));
            write.append("            \"step\":\"true\"" + System.getProperty("line.separator"));
            write.append("        }" + System.getProperty("line.separator"));
            write.append("    ]" + System.getProperty("line.separator"));
            write.append("}" + System.getProperty("line.separator"));

            buff.write(write.toString().getBytes("UTF-8"));
            buff.flush();
            buff.close();
        } catch (Exception e) {
            logger.error(e);
        } finally {
            try {
                buff.close();
                outSTr.close();
            } catch (Exception e) {
                logger.error(e);
            }
        }
    }

    /**
     * 下载雷达图demo文件
     * @param response
     */
    public static void radarWriteToTxt(HttpServletResponse response) {
        logger.info("radarWriteToTxt函数");

        try {
            String fileName = URLEncoder.encode("雷达图demo.txt", "utf-8");
            response.setContentType("text/plain");
            response.addHeader("Content-Disposition",
                    "attachment;filename="+fileName);// filename指定默认的名字
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        }

        BufferedOutputStream buff = null;
        StringBuffer write = new StringBuffer();

        ServletOutputStream outSTr = null;
        try {
            outSTr = response.getOutputStream();
            buff = new BufferedOutputStream(outSTr);

            //获取系统换行符换行
            write.append("{" + System.getProperty("line.separator"));
            write.append("    \"title\": \"test\"," + System.getProperty("line.separator"));
            write.append("    \"indicator\": [" + System.getProperty("line.separator"));
            write.append("            { \"name\": \"测试1\", \"max\": 6500}," + System.getProperty("line.separator"));
            write.append("            { \"name\": \"测试2\", \"max\": 16000}," + System.getProperty("line.separator"));
            write.append("            { \"name\": \"测试3\", \"max\": 30000}," + System.getProperty("line.separator"));
            write.append("            { \"name\": \"测试4\", \"max\": 38000}," + System.getProperty("line.separator"));
            write.append("            { \"name\": \"测试5\", \"max\": 52000}," + System.getProperty("line.separator"));
            write.append("            { \"name\": \"测试6\", \"max\": 25000}" + System.getProperty("line.separator"));
            write.append("     ]," + System.getProperty("line.separator"));
            write.append("    \"data\": [" + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("                    \"name\": \"测试标题1\"," + System.getProperty("line.separator"));
            write.append("                    \"value\": [5300, 12000, 30000, 37000, 20000, 19000]" + System.getProperty("line.separator"));
            write.append("        }," + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("                    \"name\": \"测试标题2\"," + System.getProperty("line.separator"));
            write.append("                    \"value\": [3000, 16000, 20000, 11000, 52000, 11000]" + System.getProperty("line.separator"));
            write.append("        }," + System.getProperty("line.separator"));
            write.append("        {" + System.getProperty("line.separator"));
            write.append("                    \"name\": \"测试标题3\"," + System.getProperty("line.separator"));
            write.append("                    \"value\": [3000, 15000, 17000, 21000, 32000, 15000]" + System.getProperty("line.separator"));
            write.append("        }" + System.getProperty("line.separator"));
            write.append("    ]" + System.getProperty("line.separator"));
            write.append("}" + System.getProperty("line.separator"));
            buff.write(write.toString().getBytes("UTF-8"));
            buff.flush();
            buff.close();
        } catch (Exception e) {
            logger.error(e);
        } finally {
            try {
                buff.close();
                outSTr.close();
            } catch (Exception e) {
                logger.error(e);
            }
        }
    }


}
