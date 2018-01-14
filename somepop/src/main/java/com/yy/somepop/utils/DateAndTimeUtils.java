package com.yy.somepop.utils;

import com.yy.somepop.wheelview.WheelView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 *     author : lyy
 *     time   : 2018/01/14
 *     desc   :
 *     version: 1.0
 * </pre>
 */


public class DateAndTimeUtils {


    //取一个30天内的时间范围进行显示
    public static TimeRange getTimeRange() {
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.set(1970,0,1);
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.set(1971,6,31);
        TimeRange timeRange = new TimeRange();
        timeRange.setStart_time(calendarStart.getTime());
        timeRange.setEnd_time(calendarEnd.getTime());
        return timeRange;
    }

    public static List<String> buildYears(TimeRange timeRange) {
        List<String> yearList = new ArrayList<>();
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(timeRange.getStart_time());
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(timeRange.getEnd_time());
        int startYear = calendarStart.get(Calendar.YEAR);
        int endYear = calendarEnd.get(Calendar.YEAR);
        if(startYear>endYear)
        {
            endYear = startYear;
        }
        int[] years = new int[endYear-startYear+1];
        for(int i  = 0;i<years.length;i++)
        {
            yearList.add(startYear+i+"年");
        }
        return yearList;
    }

    /**
     * 获取月份列表
     * @param wheelViewYear 年份控件
     * @param timeRange 开始和结束时间
     * @return
     */
    public static List<String> buildMonths(WheelView wheelViewYear, TimeRange timeRange)
    {
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(timeRange.getStart_time());
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(timeRange.getEnd_time());
        int startYear = calendarStart.get(Calendar.YEAR);
        int endYear = calendarEnd.get(Calendar.YEAR);
        int currentYear = Integer.valueOf(wheelViewYear.getSelectedItem().replace("年",""));
        if(currentYear>startYear&&currentYear<endYear)
        {
            return buildNomalMonthList();
        }else if(currentYear==startYear&&currentYear==endYear){
            return buildStartAndEndMonthList(timeRange);
        }else if(currentYear == startYear)
        {
            return buildMonthListStart(timeRange);
        }else{
            return buildMonthListEnd(timeRange);
        }
    }

    /**
     * 根据开始时间生成月份列表
     * @param timeRange 开始和结束时间
     * @return
     */
    public static List<String> buildMonthListStart(TimeRange timeRange)
    {
        List<String> months = new ArrayList<>();
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(timeRange.getStart_time());
        int startMonth = calendarStart.get(Calendar.MONTH)+1;
        for(int i= startMonth;i<=12;i++)
        {
            months.add(i+"月");
        }
        return months;
    }

    /**
     * 根据结束时间生成月份列表
     * @param timeRange 开始和结束时间
     * @return
     */
    public static List<String> buildMonthListEnd(TimeRange timeRange)
    {
        List<String> months = new ArrayList<>();
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(timeRange.getEnd_time());
        int endMonth = calendarEnd.get(Calendar.MONTH)+1;
        for(int i= 1;i<=endMonth;i++)
        {
            months.add(i+"月");
        }
        return months;
    }

    /**
     * 生成全年的月份列表
     * @return
     */
    public static List<String> buildNomalMonthList(){
        List<String> months = new ArrayList<>();
        for(int i = 1;i<=12;i++)
        {
            months.add(i+"月");
        }
        return months;
    }

    /**
     * 当开始年份和结束结束年份相同时生成月份列表
     * @param timeRange 开始和结束时间
     * @return
     */
    public static List<String> buildStartAndEndMonthList(TimeRange timeRange)
    {
        List<String> months = new ArrayList<>();
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(timeRange.getStart_time());
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(timeRange.getEnd_time());
        int startMonth = calendarStart.get(Calendar.MONTH)+1;
        int endMonth = calendarEnd.get(Calendar.MONTH)+1;
        for(int i= startMonth;i<=endMonth;i++)
        {
            months.add(i+"月");
        }
        return months;
    }



    public static ArrayList<String> buildDays(WheelView wheelViewYear,WheelView wheelViewMonth,TimeRange timeRange) {

        return new ArrayList<>();
    }










    public static ArrayList<String> buildearYs(TimeRange timeRange) {
        Calendar calendarStart = Calendar.getInstance();

        calendarStart.setTime(timeRange.getStart_time());
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(timeRange.getEnd_time());

        calendarStart.add(Calendar.MINUTE, 10);//分钟需要取整，1月1日23:55 则从 1月2日00:00开始

        ArrayList<String> daysList = new ArrayList<>();
        while (calendarStart.before(calendarEnd)) {
            Date date = calendarStart.getTime();
            daysList.add(TimeUtils.dateToStr(date));
            calendarStart.add(Calendar.DAY_OF_MONTH,1);
        }
        //如果循环后开始的日期等于结束的日期，则把结束的日期也加上，如果不等于，说明已经加过了
        if (isInSameDay(calendarStart,calendarEnd)) {
            Date date = calendarEnd.getTime();
            daysList.add(TimeUtils.dateToStr(date));
        }

        return  daysList;
    }

    public static ArrayList<String> buildDays(TimeRange timeRange) {
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(timeRange.getStart_time());
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(timeRange.getEnd_time());

        calendarStart.add(Calendar.MINUTE, 10);//分钟需要取整，1月1日23:55 则从 1月2日00:00开始

        ArrayList<String> daysList = new ArrayList<>();
        while (calendarStart.before(calendarEnd)) {
            Date date = calendarStart.getTime();
            daysList.add(TimeUtils.dateToStr(date));
            calendarStart.add(Calendar.DAY_OF_MONTH,1);
        }
        //如果循环后开始的日期等于结束的日期，则把结束的日期也加上，如果不等于，说明已经加过了
        if (isInSameDay(calendarStart,calendarEnd)) {
            Date date = calendarEnd.getTime();
            daysList.add(TimeUtils.dateToStr(date));
        }

        return  daysList;
    }
    public static ArrayList buildHoursByDay(WheelView wheelViewDay, TimeRange timeRange) {
        if (wheelViewDay.getSelectedPosition() == 0) {
            return buildHourListStart(timeRange);
        } else if (wheelViewDay.getSelectedPosition() == wheelViewDay.getSize() - 1) {
            return buildHourListEnd(timeRange);
        }else {
            return buildNomalHourList();
        }
    }
    public static ArrayList buildMinutesByDayHour(WheelView wheelViewDay, WheelView wheelViewHour, TimeRange timeRange) {
        if (wheelViewDay.getSelectedPosition() == 0 && wheelViewHour.getSelectedPosition() == 0) {
            return buildMinuteListStart(timeRange);
        } else if (wheelViewDay.getSelectedPosition() == wheelViewDay.getSize() - 1 &&
                wheelViewHour.getSelectedPosition() == wheelViewHour.getSize() - 1) {
            return buildMinuteListEnd(timeRange);
        } else {
            return buildNomalMinuteList();
        }
    }

    public static ArrayList buildHourListStart(TimeRange timeRange) {
        Date dateStart = timeRange.getStart_time();
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(dateStart);
        calendarStart.add(Calendar.MINUTE,10);//分钟需要取整，5.55则从6:00开始

        int hourStart = calendarStart.get(Calendar.HOUR_OF_DAY);
        int min = calendarStart.get(Calendar.MINUTE);
        ArrayList hourList = new ArrayList<>();

        //需要判断起止时间是否为同一天，如果不在同一天，第一天小时范围为n-23
        Date dateEnd = timeRange.getEnd_time();
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(dateEnd);
        int hourEnd;
        if (isInSameDay(calendarStart, calendarEnd)) {
            hourEnd = calendarEnd.get(Calendar.HOUR_OF_DAY);
        }else{
            hourEnd = 23;
        }

        for (int i = hourStart; i <= hourEnd; i++) {
            hourList.add(i + "点");
        }

        return hourList;
    }
    public static ArrayList buildNomalHourList() {
        ArrayList hourList = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
            hourList.add(i + "点");
        }

        return hourList;
    }
    public static ArrayList buildHourListEnd(TimeRange timeRange) {
        Date dateEnd = timeRange.getEnd_time();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateEnd);

        int hourEnd = calendar.get(Calendar.HOUR_OF_DAY);

        ArrayList hourList = new ArrayList<>();

        for (int i = 0; i <= hourEnd; i++) {
            hourList.add(i + "点");
        }

        return hourList;
    }

    public static ArrayList buildMinuteListStart(TimeRange timeRange ) {
        Date dateStart = timeRange.getStart_time();
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(dateStart);
        calendarStart.add(Calendar.MINUTE, 10);//分钟需要取整，5.55则从6:00开始
        int minStart = (calendarStart.get(Calendar.MINUTE) / 10) * 10;//取整
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(timeRange.getEnd_time());
        int minEnd ;
        if (isInSameHour(calendarStart, calendarEnd)) {
            minEnd = (calendarEnd.get(Calendar.MINUTE) / 10) * 10;
        }else{
            minEnd = 50;
        }
        ArrayList minList = new ArrayList<>();

        for (int i = minStart; i <= minEnd; i += 10) {
            minList.add(i + "分");
        }
        return minList;
    }
    public static ArrayList buildMinuteListEnd(TimeRange timeRange) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timeRange.getEnd_time());
        int minEnd = (calendar.get(Calendar.MINUTE) / 10) * 10;
        ArrayList minList = new ArrayList<>();

        for (int i = 0; i <= minEnd; i += 10) {
            minList.add(i + "分");
        }

        return minList;
    }
    public static ArrayList buildNomalMinuteList() {
        ArrayList minuteList = new ArrayList<>();

        for (int i = 0; i < 60; i += 10) {
            minuteList.add(i + "分");
        }
        return minuteList;
    }

    //判断两个日期是否在同一天
    public static boolean isInSameDay(Calendar calendar1, Calendar calendar2) {
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
                && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)
                && calendar1.get(Calendar.DAY_OF_MONTH) == calendar2
                .get(Calendar.DAY_OF_MONTH);
    }

    //判断两个日期是否位于同一小时
    public static boolean isInSameHour(Calendar calendar1, Calendar calendar2) {
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
                && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)
                && calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH)
                && calendar1.get(Calendar.HOUR_OF_DAY) == calendar2.get(Calendar.HOUR_OF_DAY);

    }
}
