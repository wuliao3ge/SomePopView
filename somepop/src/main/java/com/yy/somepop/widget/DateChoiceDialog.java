package com.yy.somepop.widget;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yy.somepop.R;
import com.yy.somepop.base.BaseDialog;
import com.yy.somepop.databinding.DialogSelectDateBinding;
import com.yy.somepop.framework.DataChoiceListener;
import com.yy.somepop.framework.DefaultListener;
import com.yy.somepop.model.DataAndTimeChoiceModel;
import com.yy.somepop.utils.DateAndTimeUtils;
import com.yy.somepop.utils.StringUtils;
import com.yy.somepop.utils.TimeRange;
import com.yy.somepop.utils.TimeUtils;
import com.yy.somepop.wheelview.WheelView;

import java.text.SimpleDateFormat;
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
        binding.wv1.setItems(DateAndTimeUtils.buildYears(timeRange),0);
        binding.wv2.setItems(DateAndTimeUtils.buildMonths(binding.wv1,timeRange),0);
        binding.wv3.setItems(DateAndTimeUtils.buildDays(binding.wv1,binding.wv2,timeRange),0);
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
        baseDialogModel.setCenterListener(new DefaultListener() {
            @Override
            public void onClick(Dialog dialog) {
                if(dataChoiceListener!=null)
                {
                    String mSelectYear = binding.wv1.getSelectedItem();
                    String mSelectMonth = binding.wv2.getSelectedItem();
                    String mSelectDay = binding.wv3.getSelectedItem();
                    Date date = DateAndTimeUtils.dateTimeFromCustomStr(mSelectYear,mSelectMonth,mSelectDay);
                    String time = TimeUtils.dateTimeToStr(date);
                    Toast.makeText(context, "selectDateTime: "+time+date.getTime(), Toast.LENGTH_SHORT).show();
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
