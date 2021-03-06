package com.yy.somepop.widget;

import android.app.Dialog;
import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;

import com.yy.somepop.R;
import com.yy.somepop.base.BaseDialog;
import com.yy.somepop.databinding.DialogSelectDateBinding;
import com.yy.somepop.framework.DataChoiceListener;
import com.yy.somepop.framework.DefaultListener;
import com.yy.somepop.model.DataAndTimeChoiceModel;
import com.yy.somepop.utils.DateAndTimeUtils;
import com.yy.somepop.utils.TimeRange;
import com.yy.somepop.wheelview.WheelView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ly on 2017/12/25.
 */

public class DateChoiceDialog extends BaseDialog<DateChoiceDialog> {

    private DataChoiceListener dataChoiceListener;
    private TimeRange timeRange;
    private DialogSelectDateBinding binding;
    private DataAndTimeChoiceModel model;


    private int currentYearIndex = 0;
    private int currentMonthIndex = 0;
    private int currentDayIndex = 0;

    public DateChoiceDialog(@NonNull Context context) {
        super(context);
    }

    public DateChoiceDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected DateChoiceDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void init() {
        model = new DataAndTimeChoiceModel();
        timeRange = DateAndTimeUtils.getTimeRange();
        View outerView = LayoutInflater.from(context).inflate(R.layout.dialog_select_date,
                null);
        binding = DataBindingUtil.bind(outerView);
    }

    @Override
    public void setView() {
        setisShowDivision(true);
        binding.setModel(model);

        Date currentDate = new Date();
        Date startDate = getStartTime();
        Date endDate = getEndTime();

        //开始时间小于当前时间并且结束时间大于当前时间
        if(startDate.getTime()<=currentDate.getTime()&&endDate.getTime()>=currentDate.getTime())
        {
            Calendar currentcalendar=Calendar.getInstance();
            currentcalendar.setTime(currentDate);
            int currentyear=currentcalendar.get(Calendar.YEAR);
            Calendar startcalendar=Calendar.getInstance();
            startcalendar.setTime(startDate);
            int startyear=startcalendar.get(Calendar.YEAR);

            currentYearIndex = currentyear - startyear;
            if(currentYearIndex==0)
            {
                currentMonthIndex = currentcalendar.get(Calendar.MONTH)-startcalendar.get(Calendar.MONTH);
            }else{
                currentMonthIndex = currentcalendar.get(Calendar.MONTH);
            }
            if(currentMonthIndex==0&&currentYearIndex==0)
            {
                currentDayIndex = currentcalendar.get(Calendar.DAY_OF_MONTH)-startcalendar.get(Calendar.DAY_OF_MONTH);
            }else{
                currentDayIndex = currentcalendar.get(Calendar.DAY_OF_MONTH)-1;
            }
        }
        //开始时间小于当前时间并且结束时间也小于当前时间
        else if(startDate.getTime()<=currentDate.getTime()&&endDate.getTime()<=currentDate.getTime()){
            Calendar currentcalendar=Calendar.getInstance();
            currentcalendar.setTime(endDate);
            int currentyear=currentcalendar.get(Calendar.YEAR);
            Calendar startcalendar=Calendar.getInstance();
            startcalendar.setTime(startDate);
            int startyear=startcalendar.get(Calendar.YEAR);

            currentYearIndex = currentyear - startyear;
            if(currentYearIndex==0)
            {
                currentMonthIndex = currentcalendar.get(Calendar.MONTH)-startcalendar.get(Calendar.MONTH);
            }else{
                currentMonthIndex = currentcalendar.get(Calendar.MONTH);
            }
            if(currentMonthIndex==0&&currentYearIndex==0)
            {
                currentDayIndex = currentcalendar.get(Calendar.DAY_OF_MONTH)-startcalendar.get(Calendar.DAY_OF_MONTH);
            }else{
                currentDayIndex = currentcalendar.get(Calendar.DAY_OF_MONTH)-1;
            }
        }


        binding.wv1.setItems(DateAndTimeUtils.buildYears(context,timeRange),currentYearIndex);
        binding.wv2.setItems(DateAndTimeUtils.buildMonths(context,binding.wv1,timeRange),currentMonthIndex);
        binding.wv3.setItems(DateAndTimeUtils.buildDays(context,binding.wv1,binding.wv2,timeRange),currentDayIndex);
        //联动逻辑效果
        binding.wv1.setOnItemSelectedListener(new WheelView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index,String item) {
                List<String> monthsStrList = DateAndTimeUtils.buildMonths(context,binding.wv1,timeRange);
                int newIndexHour = monthsStrList.indexOf(binding.wv2.getSelectedItem());
                binding.wv2.setItems(monthsStrList,newIndexHour);
            }
        });
        binding.wv2.setOnItemSelectedListener(new WheelView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index,String item) {
                List<String> daysStrList = DateAndTimeUtils.buildDays(context,binding.wv1, binding.wv2, timeRange);
                int newIndexMin = daysStrList.indexOf(binding.wv3.getSelectedItem());
                binding.wv3.setItems(daysStrList,newIndexMin);
            }
        });
        baseDialogModel.setRightListener(new DefaultListener() {
            @Override
            public void onClick(Dialog dialog) {
                if(dataChoiceListener!=null)
                {
                    String mSelectYear = binding.wv1.getSelectedItem();
                    String mSelectMonth = binding.wv2.getSelectedItem();
                    String mSelectDay = binding.wv3.getSelectedItem();
                    Date date = DateAndTimeUtils.dateTimeFromCustomStr(context,mSelectYear,mSelectMonth,mSelectDay);
//                    String time = TimeUtils.dateTimeToStr(date);
//                    Toast.makeText(context, "selectDateTime: "+time+date.getTime(), Toast.LENGTH_SHORT).show();
//                    Log.i("selectDateTime:",String.valueOf(date.getTime()));
//                    Log.i("longToDate：",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(date.getTime())));
                    dataChoiceListener.dataChoice(date.getTime());
                }
            }
        });
        //将布局设置给Dialog
        addView(binding.getRoot());
    }





    public Date getStartTime() {
        return timeRange.getStart_time();
    }

    public DateChoiceDialog setStartTime(Date startTime) {
        timeRange.setStart_time(startTime);
        return this;
    }

    public Date getEndTime() {
        return timeRange.getEnd_time();
    }

    public DateChoiceDialog setEndTime(Date endTime) {
        timeRange.setEnd_time(endTime);
        return this;
    }


    public DateChoiceDialog setStartTime(int year,int month,int day) {

        timeRange.setStart_time(year,month,day);
        return this;
    }

    public DateChoiceDialog setEndTime(int year,int month,int day) {
        timeRange.setEnd_time(year,month,day);
        return this;
    }

    public DataChoiceListener getDataChoiceListener() {
        return dataChoiceListener;
    }

    public DateChoiceDialog setDataChoiceListener(DataChoiceListener dataChoiceListener) {
        this.dataChoiceListener = dataChoiceListener;
        return this;
    }

    public DateChoiceDialog setLineColor(@ColorRes int Res) {
        model.setLineColor(Res);
        return this;
    }

    public DateChoiceDialog setInterval(int interval) {
        model.setInterval(interval);
        return this;
    }




    public DateChoiceDialog setItemsVisible(int itemsVisible) {
        model.setItemsVisible(itemsVisible);
        return this;
    }



    public DateChoiceDialog setTextSizeCenter(@DimenRes int textSizeCenter) {
        model.setTextSizeCenter(textSizeCenter);
        return this;
    }



    public DateChoiceDialog setTextSizeOuter(@DimenRes int textSizeOuter) {
        model.setTextSizeOuter(textSizeOuter);
        return this;
    }



    public DateChoiceDialog setTextColorOuter(@ColorRes int textColorOuter) {
        model.setTextColorOuter(textColorOuter);
        return this;
    }



    public DateChoiceDialog setTextColorCenter(@ColorRes int textColorCenter) {
        model.setTextColorCenter(textColorCenter);
        return this;
    }



    public DateChoiceDialog setLoop(boolean loop) {
        model.setLoop(loop);
        return this;
    }



    public DateChoiceDialog setLineHeight(@DimenRes int lineHeight) {
        model.setLineHeight(lineHeight);
        return this;
    }

}
