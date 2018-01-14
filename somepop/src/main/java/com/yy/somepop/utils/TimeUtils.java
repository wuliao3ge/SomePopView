package com.yy.somepop.utils;

import com.yy.somepop.wheelview.WheelView;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ly on 2017/12/27.
 */

public class TimeUtils {
    // strTime要转换的String类型的时间
    // formatType时间格式
    // strTime的时间格式和formatType的时间格式必须相同
    public static long stringToLong(String strTime, String formatType)
            throws ParseException {
        Date date = stringToDate(strTime, formatType); // String类型转成date类型
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date); // date类型转成long类型
            return currentTime;
        }
    }

    // currentTime要转换的long类型的时间
    // formatType要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    public static Date longToDate(long currentTime, String formatType)
            throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
        return date;
    }

    // strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
    // HH时mm分ss秒，
    // strTime的时间格式必须要与formatType的时间格式相同
    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    // currentTime要转换的long类型的时间
    // formatType要转换的string类型的时间格式
    public static String longToString(long currentTime, String formatType)
            throws ParseException {
        Date date = longToDate(currentTime, formatType); // long类型转成Date类型
        String strTime = dateToString(date, formatType); // date类型转成String
        return strTime;
    }


    // formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    // data Date类型的时间
    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }



    // date要转换的date类型的时间
    public static long dateToLong(Date date) {
        return date.getTime();
    }

    public static final Date dateFromTimeUtilsStr(String stringDate){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date =sdf.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  date;
    }



    public static final Date timeFromCNStr(String stringTime){
        SimpleDateFormat sdf=new SimpleDateFormat("H点m分");
        Date time = null;
        try {
            time =sdf.parse(stringTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  time;
    }


    public static final String dateToStr(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }


    public static final Date dateTimeFromStr(String stringDateTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time =sdf.parse(stringDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  time;
    }
    public static final String dateTimeToStr(Date dateTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  sdf.format(dateTime);
    }

    public static final Date dateTimeFromCustomStr(String date, String time){
        Date dateTime = new Date();
        Calendar calendar = Calendar.getInstance();
        //设置day
        if(date.equals("今天")){

        } else if(date.equals("明天")){
            calendar.add(Calendar.DATE,1);
        }
        else if(date.equals("后天")){
            calendar.add(Calendar.DATE,2);
        }else{
            dateTime = dateFromTimeUtilsStr(date);
            calendar.setTime(dateTime);
        }

        //设置小时分钟
        Date timeFormat = timeFromCNStr(time);
        try{
            calendar.set(Calendar.HOUR_OF_DAY,timeFormat.getHours());
            calendar.set(Calendar.MINUTE,timeFormat.getMinutes());
            dateTime = calendar.getTime();
        }catch (Exception e){
            e.printStackTrace();
        }
        return dateTime;
    }

    public static String showScore(float score) {
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(score);
    }




}
