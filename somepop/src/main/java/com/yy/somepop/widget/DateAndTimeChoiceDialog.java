package com.yy.somepop.widget;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.yy.somepop.R;
import com.yy.somepop.base.BaseDialog;
import com.yy.somepop.databinding.DialogSelectDateTimeBinding;
import com.yy.somepop.framework.DataChoiceListener;
import com.yy.somepop.framework.DefaultListener;
import com.yy.somepop.utils.DateAndTimeUtils;
import com.yy.somepop.utils.TimeRange;
import com.yy.somepop.utils.TimeUtils;
import com.yy.somepop.wheelview.WheelView;

import java.text.SimpleDateFormat;
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
    private int lineColor;
    private int interval;

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
        timeRange = DateAndTimeUtils.getTimeRange();
        View outerView = LayoutInflater.from(context).inflate(R.layout.dialog_select_date_time,
                null);
        binding = DataBindingUtil.bind(outerView);
    }

    @Override
    public void setView() {
        setisShowDivision(true);
        binding.wv1.setItems(DateAndTimeUtils.buildYears(timeRange),0);
        binding.wv2.setItems(DateAndTimeUtils.buildMonths(binding.wv1,timeRange),0);
        binding.wv3.setItems(DateAndTimeUtils.buildDays(binding.wv1,binding.wv2,timeRange),0);
        binding.wv4.setItems(DateAndTimeUtils.buildNomalHourList(),0);
        binding.wv5.setItems(DateAndTimeUtils.buildNomalMinuteList(),0);
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
                    String time = TimeUtils.dateTimeToStr(date);
                    Toast.makeText(context, "selectDateTime: "+time+date.getTime(), Toast.LENGTH_SHORT).show();
                    Log.i("selectDateTime:",String.valueOf(date.getTime()));
                    Log.i("longToDate：",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(date.getTime())));
                    dataChoiceListener.dataChoice(date.getTime());
                }
            }
        });
        //将布局设置给Dialog
        addView(binding.getRoot());
    }


    public int getLineColor() {
        return lineColor;
    }

    public DateAndTimeChoiceDialog setLineColor(@ColorRes int Res) {
        this.lineColor = Res;
        binding.wv1.setLineColor(Res);
        binding.wv2.setLineColor(Res);
        binding.wv3.setLineColor(Res);
        binding.wv4.setLineColor(Res);
        binding.wv5.setLineColor(Res);
        return this;
    }

    public DataChoiceListener getDataChoiceListener() {
        return dataChoiceListener;
    }

    public DateAndTimeChoiceDialog setDataChoiceListener(DataChoiceListener dataChoiceListener) {
        this.dataChoiceListener = dataChoiceListener;
        return this;
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
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month-1,day);
        timeRange.setStart_time(calendar.getTime());
        return this;
    }

    public DateAndTimeChoiceDialog setEndTime(int year,int month,int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month-1,day);
        timeRange.setEnd_time(calendar.getTime());
        return this;
    }


    public int getInterval() {
        return interval;
    }

    public DateAndTimeChoiceDialog setInterval(int interval) {
        this.interval = interval;
        binding.wv1.setInterval(interval);
        binding.wv2.setInterval(interval);
        binding.wv3.setInterval(interval);
        binding.wv4.setInterval(interval);
        binding.wv5.setInterval(interval);
        return this;
    }
}
