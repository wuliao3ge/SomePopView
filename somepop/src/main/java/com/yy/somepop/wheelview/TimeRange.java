package com.yy.somepop.wheelview;


import com.yy.somepop.utils.TimeUtils;

import java.util.Date;

/**
 * Created by wpm on 2017/1/13.
 */

public class TimeRange {

    /**
     * start_time : 2017-01-13 15:05:25
     * end_time : 2017-01-13 17:00:00
     */

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
