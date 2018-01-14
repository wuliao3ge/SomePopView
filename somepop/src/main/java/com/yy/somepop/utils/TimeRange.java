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

    public Date getEnd_time() {
        return TimeUtils.dateTimeFromStr(end_time);
    }

    public void setEnd_time(Date end_time) {
        this.end_time = TimeUtils.dateTimeToStr(end_time);
    }



}

