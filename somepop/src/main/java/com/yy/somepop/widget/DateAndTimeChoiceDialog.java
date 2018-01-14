package com.yy.somepop.widget;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.yy.somepop.R;
import com.yy.somepop.base.BaseDialog;
import com.yy.somepop.databinding.DialogSelectDateTimeBinding;
import com.yy.somepop.framework.DataChoiceListener;
import com.yy.somepop.framework.DefaultListener;
import com.yy.somepop.utils.DateAndTimeUtils;
import com.yy.somepop.utils.TimeRange;
import com.yy.somepop.utils.TimeUtils;
import com.yy.somepop.utils.Common;
import com.yy.somepop.wheelview.WheelView;

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
    private Date startTime;
    private Date endTime;
    private DialogSelectDateTimeBinding binding;


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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void init() {

        setisShowDivision(true);

        View outerView = LayoutInflater.from(context).inflate(R.layout.dialog_select_date_time,
                null);
        binding = DataBindingUtil.bind(outerView);
        final TimeRange timeRange = DateAndTimeUtils.getTimeRange();
        binding.wv1.setItems(DateAndTimeUtils.buildYears(timeRange),0);
        binding.wv2.setItems(DateAndTimeUtils.buildMonths(binding.wv1,timeRange),0);
        binding.wv4.setItems(Common.buildNomalHourList(),0);
        binding.wv5.setItems(Common.buildNomalHourList(),0);

        binding.wv3.setItems(Common.buildNomalAllMinuteList(),0);
        //联动逻辑效果
        binding.wv1.setOnItemSelectedListener(new WheelView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index,String item) {
                List hourStrList = DateAndTimeUtils.buildMonths(binding.wv1,timeRange);
                int newIndexHour = hourStrList.indexOf(binding.wv2.getSelectedItem());
                binding.wv2.setItems(hourStrList,newIndexHour);
//                List minStrList = Common.buildMinutesByDayHour(wv1, wv2, timeRange);
//                int newIndexMin = minStrList.indexOf(wv3.getSelectedItem());
//                binding.wv3.setItems(minStrList,newIndexMin);
            }
        });
        binding.wv2.setOnItemSelectedListener(new WheelView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index,String item) {
//                List minStrList = Common.buildMinutesByDayHour(wv1, wv2, timeRange);
//                int newIndexMin = minStrList.indexOf(wv3.getSelectedItem());
//                wv3.setItems(minStrList,newIndexMin);
            }
        });
        //将布局设置给Dialog
        setView(outerView);


        baseDialogModel.setRightListener(new DefaultListener() {
            @Override
            public void onClick(Dialog dialog) {
                if(dataChoiceListener!=null)
                {
                    String selectDateTimeStrToShow;
                    long times = 0;
                    String mSelectDate = binding.wv1.getSelectedItem();
                    String mSelectHour = binding.wv2.getSelectedItem();
                    String mSelectMin = binding.wv3.getSelectedItem();
//                    String time = mSelectHour + mSelectMin;
//                    time = Common.timeToStr(Common.dateTimeFromCustomStr( mSelectDate, time));
//                    try {
//                        times = TimeUtils.stringToLong(time,"yyyy-MM-dd HH:mm");
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }
//                    dataChoiceListener.dataChoice(times);
                }
            }
        });

    }


    public DataChoiceListener getDataChoiceListener() {
        return dataChoiceListener;
    }

    public DateAndTimeChoiceDialog setDataChoiceListener(DataChoiceListener dataChoiceListener) {
        this.dataChoiceListener = dataChoiceListener;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
