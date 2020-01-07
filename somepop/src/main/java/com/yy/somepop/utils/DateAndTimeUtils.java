package com.yy.somepop.utils;

import android.content.Context;
import android.content.Intent;

import com.yy.somepop.R;
import com.yy.somepop.wheelview.WheelView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        calendarEnd.set(2080,11,31);
        TimeRange timeRange = new TimeRange();
        timeRange.setStart_time(calendarStart.getTime());
        timeRange.setEnd_time(calendarEnd.getTime());
        return timeRange;
    }

    public static List<String> buildYears(Context context,TimeRange timeRange) {
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
            yearList.add(startYear+i+context.getString(R.string.year));
        }
        return yearList;
    }

    /**
     * 获取月份列表
     * @param wheelViewYear 年份控件
     * @param timeRange 开始和结束时间
     * @return
     */
    public static List<String> buildMonths(Context context,WheelView wheelViewYear, TimeRange timeRange)
    {
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(timeRange.getStart_time());
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(timeRange.getEnd_time());
        int startYear = calendarStart.get(Calendar.YEAR);
        int endYear = calendarEnd.get(Calendar.YEAR);
        int currentYear = Integer.valueOf(wheelViewYear.getSelectedItem().replace(context.getString(R.string.year),""));
        if(currentYear>startYear&&currentYear<endYear)
        {
            return buildNomalMonthList(context);
        }else if(currentYear==startYear&&currentYear==endYear){
            return buildStartAndEndMonthList(context,timeRange);
        }else if(currentYear == startYear)
        {
            return buildMonthListStart(context,timeRange);
        }else{
            return buildMonthListEnd(context,timeRange);
        }
    }

    /**
     * 根据开始时间生成月份列表
     * @param timeRange 开始和结束时间
     * @return
     */
    public static List<String> buildMonthListStart(Context context,TimeRange timeRange)
    {
        List<String> months = new ArrayList<>();
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(timeRange.getStart_time());
        int startMonth = calendarStart.get(Calendar.MONTH)+1;
        for(int i= startMonth;i<=12;i++)
        {
            months.add(i+context.getString(R.string.month));
        }
        return months;
    }

    /**
     * 根据结束时间生成月份列表
     * @param timeRange 开始和结束时间
     * @return
     */
    public static List<String> buildMonthListEnd(Context context,TimeRange timeRange)
    {
        List<String> months = new ArrayList<>();
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(timeRange.getEnd_time());
        int endMonth = calendarEnd.get(Calendar.MONTH)+1;
        for(int i= 1;i<=endMonth;i++)
        {
            months.add(i+context.getString(R.string.month));
        }
        return months;
    }

    /**
     * 生成全年的月份列表
     * @return
     */
    public static List<String> buildNomalMonthList(Context context){
        List<String> months = new ArrayList<>();
        for(int i = 1;i<=12;i++)
        {
            months.add(i+context.getString(R.string.month));
        }
        return months;
    }

    /**
     * 当开始年份和结束结束年份相同时生成月份列表
     * @param timeRange 开始和结束时间
     * @return
     */
    public static List<String> buildStartAndEndMonthList(Context context,TimeRange timeRange)
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
            months.add(i+context.getString(R.string.month));
        }
        return months;
    }


    /**
     * 生成日期列表
     * @param wheelViewYear 年选择器
     * @param wheelViewMonth 月选择器
     * @param timeRange 开始和结束时间
     * @return
     */
    public static List<String> buildDays(Context context,WheelView wheelViewYear,WheelView wheelViewMonth,TimeRange timeRange) {
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(timeRange.getStart_time());
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(timeRange.getEnd_time());
        int currentYear = Integer.valueOf(wheelViewYear.getSelectedItem().replace(context.getString(R.string.year),""));
        int currentMonth = Integer.valueOf(wheelViewMonth.getSelectedItem().replace(context.getString(R.string.month),""));
        if(isSameMonth(timeRange.getStart_time(),timeRange.getEnd_time()))
        {
            return buildStartAndEndDayList(context,timeRange);
        }else if(isSameMonth(currentYear,currentMonth,timeRange.getStart_time())){
            return buildDayListStart(context,currentYear,currentMonth,timeRange);
        }else if(isSameMonth(currentYear,currentMonth,timeRange.getEnd_time())){
            return buildDayListEnd(context,timeRange);
        }else{
            return buildNomalDayList(context,currentYear,currentMonth);
        }
    }

    /**
     * 根据开始时间生成日期列表
     * @param timeRange 开始和结束时间
     * @return
     */
    public static List<String> buildDayListStart(Context context,int currentYear,int currentMonth,TimeRange timeRange)
    {

        List<String> months = new ArrayList<>();
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(timeRange.getStart_time());
        int startDay = calendarStart.get(Calendar.DAY_OF_MONTH);
        calendarStart.set(currentYear,currentMonth,0);
        int endDay = calendarStart.getActualMaximum(Calendar.DATE);
        for(int i= startDay;i<=endDay;i++)
        {
            months.add(i+context.getString(R.string.day));
        }
        return months;
    }

    /**
     * 根据结束时间生成日期列表
     * @param timeRange 开始和结束时间
     * @return
     */
    public static List<String> buildDayListEnd(Context context,TimeRange timeRange)
    {
        List<String> days = new ArrayList<>();
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(timeRange.getEnd_time());
        int endDay = calendarEnd.get(Calendar.DAY_OF_MONTH);
        for(int i= 1;i<=endDay;i++)
        {
            days.add(i+context.getString(R.string.day));
        }
        return days;
    }

    /**
     * 生成整个月的日期
     * @return
     */
    public static List<String> buildNomalDayList(Context context,int currentYear,int currentMonth){
        List<String> days = new ArrayList<>();
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.set(currentYear,currentMonth,0);
        int endDay = calendarStart.getActualMaximum(Calendar.DATE);
        for(int i = 1;i<=endDay;i++)
        {
            days.add(i+context.getString(R.string.day));
        }
        return days;
    }

    /**
     * 当开始年份和结束结束年份相同时生成月份列表
     * @param timeRange 开始和结束时间
     * @return
     */
    public static List<String> buildStartAndEndDayList(Context context,TimeRange timeRange)
    {
        List<String> days = new ArrayList<>();
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(timeRange.getStart_time());
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(timeRange.getEnd_time());
        int starDay = calendarStart.get(Calendar.DAY_OF_MONTH);
        int endDay = calendarEnd.get(Calendar.DAY_OF_MONTH);
        for(int i= starDay;i<=endDay;i++)
        {
            days.add(i+context.getString(R.string.day));
        }
        return days;
    }

    /**
     * 根据选择的年月日时分生成deta
     * @param year 年
     * @param month 月
     * @param day 日
     * @param hour 时
     * @param min 分
     * @return
     */
    public static final Date dateTimeFromCustomStr(Context context,String year,String month,
                                                   String day,String hour, String min){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");//小写的mm表示的是分钟
        year = year.replace(context.getString(R.string.year),"");
        month = month.replace(context.getString(R.string.month),"");
        day = day.replace(context.getString(R.string.day),"");
        hour = hour.replace(context.getString(R.string.hour),"");
        min = min.replace(context.getString(R.string.minute),"");
        String dstr=year+"-"+month+"-"+day+" "+hour+":"+min;
        try {
            date = sdf.parse(dstr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 根据选择的年月日时分生成deta
     * @param year 年
     * @param month 月
     * @param day 日
     * @return
     */
    public static final Date dateTimeFromCustomStr(Context context, String year, String month,
                                                   String day){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        year = year.replace(context.getString(R.string.year),"");
        month = month.replace(context.getString(R.string.month),"");
        day = day.replace(context.getString(R.string.day),"");
        String dstr=year+"-"+month+"-"+day;
        try {
            date = sdf.parse(dstr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 根据选择的年月日时分生成deta
     * @param hour 时
     * @param min 分
     * @return
     */
    public static final Date dateTimeFromCustomStr(Context context,String hour, String min){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,Integer.valueOf(hour.replace(context.getString(R.string.hour),"")));
        calendar.set(Calendar.MINUTE,Integer.valueOf(min.replace(context.getString(R.string.minute),"")));
        return calendar.getTime();
    }



    /**
     * 判断是否为同一月
     * @param calendar1
     * @param calendar2
     * @return
     */
    private static boolean isSameMonth(Calendar calendar1, Calendar calendar2) {
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
                && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);
    }

    /**
     * 判断是否为同一月
     * @param date1
     * @param date2
     * @return
     */
    private static boolean isSameMonth(Date date1, Date date2) {
        Calendar calDateA = Calendar.getInstance();
        calDateA.setTime(date1);

        Calendar calDateB = Calendar.getInstance();
        calDateB.setTime(date2);

        return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)
                && calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH);
    }


    /**
     * 判断是否为同一月
     * @param year 年
     * @param month 月
     * @param date1 判断的时间
     * @return
     */
    private static boolean isSameMonth(int year,int month,Date date1) {
        Calendar calDateA = Calendar.getInstance();
        calDateA.setTime(date1);


        return calDateA.get(Calendar.YEAR) == year
                && calDateA.get(Calendar.MONTH) == month-1;
    }


    /**
     * 获取某年某月有多少天
     * @param year
     * @param month
     * @return
     */
    public int getDayOfMonth(int year,int month){
        Calendar c = Calendar.getInstance();
        c.set(year, month, 0); //输入类型为int类型
        return c.get(Calendar.DAY_OF_MONTH);
    }



    /**
     * 判断是否为同一天
     * @param calendar1
     * @param calendar2
     * @return
     */
    public static boolean isSameDay(Calendar calendar1, Calendar calendar2) {
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
                && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)
                && calendar1.get(Calendar.DAY_OF_MONTH) == calendar2
                .get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 判断是否为同一天
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        Calendar calDateA = Calendar.getInstance();
        calDateA.setTime(date1);

        Calendar calDateB = Calendar.getInstance();
        calDateB.setTime(date2);

        return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)
                && calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)
                && calDateA.get(Calendar.DAY_OF_MONTH) == calDateB
                .get(Calendar.DAY_OF_MONTH);
    }


    /**
     * 判断是否为同一天
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameHour(Date date1, Date date2) {
        Calendar calDateA = Calendar.getInstance();
        calDateA.setTime(date1);

        Calendar calDateB = Calendar.getInstance();
        calDateB.setTime(date2);

        return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)
                && calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)
                && calDateA.get(Calendar.DAY_OF_MONTH) == calDateB.get(Calendar.DAY_OF_MONTH)
                &&calDateA.get(Calendar.HOUR_OF_DAY)==calDateB.get(Calendar.HOUR_OF_DAY);
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
    public static ArrayList buildHoursByDay(Context context,WheelView wheelViewDay, TimeRange timeRange) {
        if (wheelViewDay.getSelectedPosition() == 0) {
            return buildHourListStart(context,timeRange);
        } else if (wheelViewDay.getSelectedPosition() == wheelViewDay.getSize() - 1) {
            return buildHourListEnd(context,timeRange);
        }else {
            return buildNomalHourList(context);
        }
    }

    public static ArrayList buildHoursByDay(Context context,TimeRange timeRange) {
        if(isSameDay(timeRange.getStart_time(),timeRange.getEnd_time()))
        {
            return buildHourListStartAndEnd(context,timeRange);
        }else {
            return buildNomalHourList(context);
        }

    }



    public static List<String> buildMinutesByDayHour(Context context,WheelView wheelViewDay, WheelView wheelViewHour, TimeRange timeRange) {
        if (wheelViewDay.getSelectedPosition() == 0 && wheelViewHour.getSelectedPosition() == 0) {
            return buildMinuteListStart(context,timeRange);
        } else if (wheelViewDay.getSelectedPosition() == wheelViewDay.getSize() - 1 &&
                wheelViewHour.getSelectedPosition() == wheelViewHour.getSize() - 1) {
            return buildMinuteListEnd(context,timeRange);
        } else {
            return buildNomalMinuteList(context);
        }
    }

    public static ArrayList buildHourListStart(Context context,TimeRange timeRange) {
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
            hourList.add(i + context.getString(R.string.hour));
        }

        return hourList;
    }
    public static ArrayList buildNomalHourList(Context context) {
        ArrayList hourList = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
            hourList.add(i + context.getString(R.string.hour));
        }

        return hourList;
    }
    public static ArrayList buildHourListEnd(Context context,TimeRange timeRange) {
        Date dateEnd = timeRange.getEnd_time();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateEnd);

        int hourEnd = calendar.get(Calendar.HOUR_OF_DAY);

        ArrayList hourList = new ArrayList<>();

        for (int i = 0; i <= hourEnd; i++) {
            hourList.add(i + context.getString(R.string.hour));
        }

        return hourList;
    }

    public static ArrayList buildHourListStartAndEnd(Context context,TimeRange timeRange) {

        Calendar startcalendar = Calendar.getInstance();
        startcalendar.setTime(timeRange.getStart_time());
        Calendar endcalendar = Calendar.getInstance();
        endcalendar.setTime(timeRange.getEnd_time());
        int hourstart = startcalendar.get(Calendar.HOUR_OF_DAY);
        int hourEnd = endcalendar.get(Calendar.HOUR_OF_DAY);

        ArrayList hourList = new ArrayList<>();

        for (int i = hourstart; i <= hourEnd; i++) {
            hourList.add(i + context.getString(R.string.hour));
        }
        return hourList;
    }

    public static List<String> buildMinute(Context context,int hour,TimeRange timeRange){

        Calendar startcalendar = Calendar.getInstance();
        startcalendar.setTime(timeRange.getStart_time());
        Calendar endcalendar = Calendar.getInstance();
        endcalendar.setTime(timeRange.getEnd_time());
        if(isSameHour(timeRange.getStart_time(),timeRange.getEnd_time()))
        {
            return buildMinuteListStartAndEnd(context,timeRange);
        } else if(hour==startcalendar.get(Calendar.HOUR_OF_DAY))
        {
            return buildMinuteListStart(context,timeRange);
        }else if(hour==endcalendar.get(Calendar.HOUR_OF_DAY))
        {
            return buildHourListEnd(context,timeRange);
        }else{
            return buildNomalMinuteList(context);
        }
    }


    public static List<String> buildMinuteListStart(Context context,TimeRange timeRange ) {
        Date dateStart = timeRange.getStart_time();
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(dateStart);
        List<String> minList = new ArrayList<>();
        for(int i= calendarStart.get(Calendar.MINUTE);i<60;i++)
        {
            minList.add(i + context.getString(R.string.minute));
        }
        return minList;
    }
    public static List<String> buildMinuteListEnd(Context context,TimeRange timeRange) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timeRange.getEnd_time());
        int minEnd = calendar.get(Calendar.MINUTE);
        List<String> minList = new ArrayList<>();
        for (int i = 0; i <= minEnd; i ++) {
            minList.add(i + context.getString(R.string.minute));
        }

        return minList;
    }
    public static List<String> buildNomalMinuteList(Context context) {
        List<String> minuteList = new ArrayList<>();
        for (int i = 0; i < 60; i ++) {
            minuteList.add(i + context.getString(R.string.minute));
        }
        return minuteList;
    }

    public static ArrayList buildMinuteListStartAndEnd(Context context,TimeRange timeRange) {
        Calendar startcalendar = Calendar.getInstance();
        startcalendar.setTime(timeRange.getEnd_time());
        Calendar endcalendar = Calendar.getInstance();
        endcalendar.setTime(timeRange.getEnd_time());
        int minstart = startcalendar.get(Calendar.MINUTE);
        int minEnd = endcalendar.get(Calendar.MINUTE) ;
        ArrayList minList = new ArrayList<>();

        for (int i = minstart; i <= minEnd; i ++) {
            minList.add(i + context.getString(R.string.minute));
        }

        return minList;
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
}
