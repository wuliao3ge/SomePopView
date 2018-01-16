package com.yy.somepop.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ly on 2017/12/27.
 */

public class TimeRange {


    /**
     *  start_time : 1990-01-01 00:00:00
     *  end_time   :    2100-01-01 00:00:00
     * */

    private String start_time;
    private String end_time;

    public Date getStart_time() {
        return TimeUtils.dateTimeFromStr(start_time);
    }

    public void setStart_time(Date start_time) {
        this.start_time = TimeUtils.dateTimeToStr(start_time);
    }


    public void setStart_time(int year,int month,int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month-1,day);
        this.start_time = TimeUtils.dateTimeToStr(calendar.getTime());
    }


    public Date getEnd_time() {
        return TimeUtils.dateTimeFromStr(end_time);
    }

    public void setEnd_time(Date end_time) {
        this.end_time = TimeUtils.dateTimeToStr(end_time);
    }

    public void setEnd_time(int year,int month,int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month-1,day);
        this.end_time = TimeUtils.dateTimeToStr(calendar.getTime());
    }

}

