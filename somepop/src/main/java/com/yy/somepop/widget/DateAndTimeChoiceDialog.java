package com.yy.somepop.widget;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.yy.somepop.R;
import com.yy.somepop.base.BaseDialog;
import com.yy.somepop.databinding.DialogSelectDateTimeBinding;
import com.yy.somepop.framework.DataChoiceListener;
import com.yy.somepop.framework.DefaultListener;
import com.yy.somepop.model.DataAndTimeChoiceModel;
import com.yy.somepop.utils.DateAndTimeUtils;
import com.yy.somepop.utils.TimeRange;
import com.yy.somepop.utils.TimeUtils;
import com.yy.somepop.wheelview.WheelView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 *     author : lyy
 *     time   : 2018/01/12
 *     desc   :
 *     version: 1.0
 * </pre>
 */


public class DateAndTimeChoiceDialog extends BaseDialog<DateAndTimeChoiceDialog> {

    private DataChoiceListener dataChoiceListener;
    private DialogSelectDateTimeBinding binding;
    private TimeRange timeRange;



    private DataAndTimeChoiceModel model;
    private int currentYearIndex = 0;
    private int currentMonthIndex = 0;
    private int currentDayIndex = 0;
    private int currentHourIndex = 0;
    private int currentMinuIndex = 0;


    public DateAndTimeChoiceDialog(@NonNull Context context) {
        super(context);
    }

    public DateAndTimeChoiceDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected DateAndTimeChoiceDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    @Override
    public void init() {
        model = new DataAndTimeChoiceModel();
        timeRange = DateAndTimeUtils.getTimeRange();
        View outerView = LayoutInflater.from(context).inflate(R.layout.dialog_select_date_time,
                null);
        binding = DataBindingUtil.bind(outerView);
    }

    @Override
    public void setView() {
        setisShowDivision(true);
        binding.setModel(model);

        Date currentDate = new Date();
        Date startDate = getStartTime();

        if(startDate.getTime()<=currentDate.getTime())
        {
            Calendar currentcalendar=Calendar.getInstance();
            currentcalendar.setTime(currentDate);
            int currentyear=currentcalendar.get(Calendar.YEAR);
            Calendar startcalendar=Calendar.getInstance();
            startcalendar.setTime(startDate);
            int startyear=startcalendar.get(Calendar.YEAR);
            currentYearIndex = currentyear - startyear;
//
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

            if(currentMonthIndex==0&&currentYearIndex==0&&currentDayIndex==0)
            {
                currentHourIndex = currentcalendar.get(Calendar.HOUR_OF_DAY)-startcalendar.get(Calendar.HOUR_OF_DAY);
            }else{
                currentHourIndex = currentcalendar.get(Calendar.HOUR_OF_DAY);
            }

            if(currentMonthIndex==0&&currentYearIndex==0&&currentDayIndex==0&&currentHourIndex==0)
            {
                currentMinuIndex = currentcalendar.get(Calendar.MINUTE)-startcalendar.get(Calendar.MINUTE);
            }else{
                currentMinuIndex = currentcalendar.get(Calendar.MINUTE);
            }
        }

        binding.wv1.setItems(DateAndTimeUtils.buildYears(timeRange), currentYearIndex);
        binding.wv2.setItems(DateAndTimeUtils.buildMonths(binding.wv1,timeRange),currentMonthIndex);
        binding.wv3.setItems(DateAndTimeUtils.buildDays(binding.wv1,binding.wv2,timeRange),currentDayIndex);
        binding.wv4.setItems(DateAndTimeUtils.buildNomalHourList(),currentHourIndex);
        binding.wv5.setItems(DateAndTimeUtils.buildNomalMinuteList(),currentMinuIndex);

        //联动逻辑效果
        binding.wv1.setOnItemSelectedListener(new WheelView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index,String item) {
                List<String> monthsStrList = DateAndTimeUtils.buildMonths(binding.wv1,timeRange);
                int newIndexHour = monthsStrList.indexOf(binding.wv2.getSelectedItem());
                binding.wv2.setItems(monthsStrList,newIndexHour);
            }
        });
        binding.wv2.setOnItemSelectedListener(new WheelView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index,String item) {
                List<String> daysStrList = DateAndTimeUtils.buildDays(binding.wv1, binding.wv2, timeRange);
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
                    String mSelectHour = binding.wv4.getSelectedItem();
                    String mSelectMin = binding.wv5.getSelectedItem();
                    Date date = DateAndTimeUtils.dateTimeFromCustomStr(mSelectYear,mSelectMonth,mSelectDay,mSelectHour,mSelectMin);
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

    public DateAndTimeChoiceDialog setStartTime(Date startTime) {
//        this.startTime = startTime;
        timeRange.setStart_time(startTime);
        return this;
    }

    public Date getEndTime() {
        return timeRange.getEnd_time();
    }

    public DateAndTimeChoiceDialog setEndTime(Date endTime) {
        timeRange.setEnd_time(endTime);
        return this;
    }





    public DateAndTimeChoiceDialog setStartTime(int year,int month,int day) {

        timeRange.setStart_time(year,month,day);
        return this;
    }

    public DateAndTimeChoiceDialog setEndTime(int year,int month,int day) {
        timeRange.setEnd_time(year,month,day);
        return this;
    }

    public DataChoiceListener getDataChoiceListener() {
        return dataChoiceListener;
    }

    public DateAndTimeChoiceDialog setDataChoiceListener(DataChoiceListener dataChoiceListener) {
        this.dataChoiceListener = dataChoiceListener;
        return this;
    }


    public DateAndTimeChoiceDialog setLineColor(@ColorRes int Res) {
        model.setLineColor(Res);
        return this;
    }

    public DateAndTimeChoiceDialog setInterval(int interval) {
        model.setInterval(interval);
        return this;
    }

    public DateAndTimeChoiceDialog setItemsVisible(int itemsVisible) {
        model.setItemsVisible(itemsVisible);
        return this;
    }



    public DateAndTimeChoiceDialog setTextSizeCenter(@DimenRes int textSizeCenter) {
        model.setTextSizeCenter(textSizeCenter);
        return this;
    }



    public DateAndTimeChoiceDialog setTextSizeOuter(@DimenRes int textSizeOuter) {
        model.setTextSizeOuter(textSizeOuter);
        return this;
    }



    public DateAndTimeChoiceDialog setTextColorOuter(@ColorRes int textColorOuter) {
        model.setTextColorOuter(textColorOuter);
        return this;
    }



    public DateAndTimeChoiceDialog setTextColorCenter(@ColorRes int textColorCenter) {
        model.setTextColorCenter(textColorCenter);
        return this;
    }



    public DateAndTimeChoiceDialog setLoop(boolean loop) {
        model.setLoop(loop);
        return this;
    }



    public DateAndTimeChoiceDialog setLineHeight(@DimenRes int lineHeight) {
        model.setLineHeight(lineHeight);
        return this;
    }
}
