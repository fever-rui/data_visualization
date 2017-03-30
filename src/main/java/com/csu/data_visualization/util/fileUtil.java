package com.csu.data_visualization.util;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by ZhangRui on 2017/3/27.
 */
public class fileUtil {

    private static final Logger logger=Logger.getLogger(fileUtil.class);

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
}
