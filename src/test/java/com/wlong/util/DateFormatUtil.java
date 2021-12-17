package com.wlong.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtil {

    public static final String DEFAULT_DATE_STR_FORMAT="yyyy-MM-dd HH:mm:ss";
    public static final String DATE_STR_FORMAT_YMD="yyyy-MM-dd";

    public static String dateToStr(Date date){
        if(null==date){
            return "";
        }else{
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat(DEFAULT_DATE_STR_FORMAT);
            return simpleDateFormat.format(date);
        }
    }

    public static String dateToStrByFormat(Date date,String format){
        if(null!=date){
            if(null==format || "".equals(format)){
                return dateToStr(date);
            }else{
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
                return simpleDateFormat.format(date);
            }
        }else{
            return "";
        }
    }

    public static Date strToDate(String dateStr){

        if (null == dateStr || "".equals(dateStr)) {
            return null;
        }else{
            Calendar calendar = Calendar.getInstance();
            String[]timeStr=dateStr.split(" ");
            String[]ydm=timeStr[0].split("-");
            int year=Integer.valueOf(ydm[0]);
            int month=Integer.valueOf(ydm[1]);
            int day=Integer.valueOf(ydm[2]);
            if(timeStr.length>1){
                String[]hms=timeStr[1].split(":");
                calendar.set(year,month,day,
                        Integer.valueOf(hms[0]),Integer.valueOf(hms[1]),
                        Integer.valueOf(hms[2]));
            }else{
                calendar.set(year,month,day);
            }
            return calendar.getTime();
        }
    }
}
