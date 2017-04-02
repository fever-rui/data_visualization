package com.csu.data_visualization.util;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by ZhangRui on 2017/3/27.
 * 用于文件操作
 */
public class fileUtil {

    private static final Logger logger=Logger.getLogger(fileUtil.class);

    /**
     * txt文件判定
     * @param file
     * @return
     */
    public static boolean isTxt(String file){
        logger.info("isTxt函数"+" 参数：file:"+file);
        if(file.matches("^.+\\.(?i)(txt)$")){
            return true;
        }
        return false;
    }

    /**
     * 文件解析
     * @param file
     * @return
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
     * 下载demo文件
     * @param response
     */
    public static void writeToTxt(HttpServletResponse response) {
        logger.info("writeToTxt函数");

        response.setContentType("text/plain");
        response.addHeader("Content-Disposition",
                "attachment;filename=demo.txt");// filename指定默认的名字
        BufferedOutputStream buff = null;
        StringBuffer write = new StringBuffer();

        ServletOutputStream outSTr = null;
        try {
            outSTr = response.getOutputStream();// 建立
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
            e.printStackTrace();
        } finally {
            try {
                buff.close();
                outSTr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
