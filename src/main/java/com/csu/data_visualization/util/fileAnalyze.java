package com.csu.data_visualization.util;

import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by ZhangRui on 2017/3/27.
 */
public class fileAnalyze {
    public static String Analyze(MultipartFile file) {
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
            e.printStackTrace();
        }
        return resultStr;
    }
}
