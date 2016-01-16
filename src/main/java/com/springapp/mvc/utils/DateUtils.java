package com.springapp.mvc.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by liufeng on 16/1/3.
 */
public class DateUtils {
    private static SimpleDateFormat dateformat1=new SimpleDateFormat("yyyyMMdd");

    public static String getLastDayFromNow(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -1);
        String date=dateformat1.format(c.getTime());
        return date;
    }

    public static String[] getLastDaysPeriod(long lastDays) {
        String[] daysPeriod = new String[new Long(lastDays).intValue()];
        for(int i =0; i < lastDays; i++){
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, -1 * (i + 1));
            String date=dateformat1.format(c.getTime());
            daysPeriod[i] = date;
        }
        return daysPeriod;
    }
}
