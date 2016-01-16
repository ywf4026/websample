package com.springapp.mvc.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liufeng on 16/1/3.
 */
public class ConvertUtil {
    public static String[][] convertToStringArr(Map<String, String[]> rowsMap, final int countLoc) {
        if(rowsMap == null || rowsMap.isEmpty()){
            return null;
        }

        List<String[]> rows = new ArrayList<String[]>();
        for(Map.Entry<String, String[]> entry : rowsMap.entrySet()){
            String[] value = entry.getValue();
            rows.add(value);
        }


        Collections.sort(rows, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                long count1 = Long.parseLong(o1[countLoc]);
                long count2 = Long.parseLong(o2[countLoc]);
                return count1 < count2 ? 1 : (count1 == count2 ? 0 : -1);

            }
        });
        int i = 0;
        String[][] rowsArr = new String[rows.size()][];
        for(String[] row : rows){
            rowsArr[i++] = row;
        }
        return rowsArr;
    }

    public static Map<String, String[]> convertToRowsMap(String[][] newRows) {
        Map<String, String[]> rowsMap = new HashMap<String, String[]>();
        if(newRows == null){
            return rowsMap;
        }
        for(int i = 0; i < newRows.length; i++){
            String key = newRows[i][0];
            rowsMap.put(key, newRows[i]);
        }
        return rowsMap;
    }

    public static Map<String, String[]> convertToRowsMap2(String[][] newRows) {
        Map<String, String[]> rowsMap = new HashMap<String, String[]>();
        if(newRows == null){
            return rowsMap;
        }
        for(int i = 0; i < newRows.length; i++){
            String key = newRows[i][0] + " " + newRows[i][1];
            rowsMap.put(key, newRows[i]);
        }
        return rowsMap;
    }

    public static Map<String, String[]> mergeRows(Map<String, String[]> newRows, Map<String, String[]> rows, int countLoc) {
        if(rows == null || rows.isEmpty()){
            return newRows;
        }
        Map<String, String[]> rowsCopy = new HashMap<String, String[]>();
        rowsCopy.putAll(rows);
        for(Map.Entry<String, String[]> entry : newRows.entrySet()){
            String key = entry.getKey();
            String[] newValue = entry.getValue();
            if(rowsCopy.containsKey(key)){
                long v1 = Long.parseLong(newValue[countLoc]);
                String[] value = rowsCopy.get(key);
                long v2 = Long.parseLong(value[countLoc]);
                long v = v1 + v2;
                newValue[countLoc] = String.valueOf(v);
                rowsCopy.remove(key);
            }
        }
        newRows.putAll(rowsCopy);
        return newRows;
    }
}
