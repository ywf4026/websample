package com.springapp.mvc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by liufeng on 16/1/3.
 */
public class ReadFileUtil {
    private static Logger logger = LoggerFactory.getLogger(ReadFileUtil.class);

    public  static String[][] readFileByLines(String fileName, Map<String, String> authorMap){
        List<List<String>> rowList = new ArrayList<List<String>>();

        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            //一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null){
                //显示行号
                String[] rowArray = tempString.split("\t");
                String rowHead = rowArray[0];
                String authorInfo = null;
                if(authorMap != null){
                    authorInfo = authorMap.get(rowHead);
                }
                String []authArr;
                if(StringUtils.isEmpty(authorInfo)){
                    authArr = new String[]{"未知", "未知", "-"};
                }else {
                    authArr = authorInfo.split(",");
                }

                List<String> row = new ArrayList<String>(Arrays.asList(rowArray));
                Collections.addAll(row, authArr);
                //添加附加信息
                rowList.add(row);
            }
            reader.close();
        } catch (IOException e) {
            logger.error("file not exit:", e);
            return null;
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        String[][] rowsArray = new String[rowList.size()][];
        for(int j=0; j < rowList.size(); j++){
            String[] rowArray = new String[rowList.get(j).size()];
            for(int i = 0; i < rowList.get(j).size(); i++){
                rowArray[i] = rowList.get(j).get(i);
            }
            rowsArray[j] = rowArray;
        }
        return rowsArray;
    }
}
