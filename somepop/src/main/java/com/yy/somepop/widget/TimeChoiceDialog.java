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
import com.yy.somepop.databinding.DialogSelectTimeBinding;
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
 * <pre>
 *     author : lyy
 *     time   : 2018/01/16
 *     desc   :
 *     version: 1.0
 * </pre>
 */


public class TimeChoiceDialog extends BaseDialog<TimeChoiceDialog> {

    private DataChoiceListener dataChoiceListener;
    private TimeRange timeRange;
    private DialogSelectTimeBinding binding;
    private DataAndTimeChoiceModel model;


    private int currentHourIndex = 0;
    private int currentMinuIndex = 0;

    public TimeChoiceDialog(@NonNull Context context) {
        super(context);
    }

    public TimeChoiceDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected TimeChoiceDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void init() {
        model = new DataAndTimeChoiceModel();
        timeRange = DateAndTimeUtils.getTimeRange();
        setStartTime(0,0);
        setEndTime(23,59);
        View outerView = LayoutInflater.from(context).inflate(R.layout.dialog_select_time,
                null);
        binding = DataBindingUtil.bind(outerView);
    }

    @Override
    public void setView() {
        setisShowDivision(true);
        binding.setModel(model);

        Date currentDate = new Date();
        Date startDate = getStartTime();

        if(startDate.getTime()<currentDate.getTime())
        {
            Calendar currentcalendar=Calendar.getInstance();
            currentcalendar.setTime(currentDate);

            Calendar startcalendar=Calendar.getInstance();
            startcalendar.setTime(startDate);


            currentHourIndex = currentcalendar.get(Calendar.HOUR_OF_DAY)-startcalendar.get(Calendar.HOUR_OF_DAY);

            if(currentHourIndex==0)
            {
                currentMinuIndex = currentcalendar.get(Calendar.MINUTE)-startcalendar.get(Calendar.MINUTE);
            }else{
                currentMinuIndex = currentcalendar.get(Calendar.MINUTE)-1;
            }
        }

        binding.wv1.setItems(DateAndTimeUtils.buildHoursByDay(context,timeRange), currentHourIndex);
        binding.wv2.setItems(DateAndTimeUtils.buildMinute(context,Integer.valueOf(binding.wv1.getSelectedItem().replace(context.getString(R.string.hour),"")), timeRange), currentMinuIndex);
        //联动逻辑效果
        binding.wv1.setOnItemSelectedListener(new WheelView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index, String item) {
                List<String> monthsStrList = DateAndTimeUtils.buildMinute(context,Integer.valueOf(binding.wv1.getSelectedItem().replace(context.getString(R.string.hour),"")), timeRange);
                int newIndexHour = monthsStrList.indexOf(binding.wv2.getSelectedItem());
                binding.wv2.setItems(monthsStrList, newIndexHour);
            }
        });
        baseDialogModel.setRightListener(new DefaultListener() {
            @Override
            public void onClick(Dialog dialog) {
                if (dataChoiceListener != null) {
                    String mSelectHour = binding.wv1.getSelectedItem();
                    String mSelectMin = binding.wv2.getSelectedItem();
                    Date date = DateAndTimeUtils.dateTimeFromCustomStr(context,mSelectHour, mSelectMin);
//                    String time = TimeUtils.dateTimeToStr(date);
//                    Toast.makeText(context, "selectDateTime: " + time + date.getTime(), Toast.LENGTH_SHORT).show();
//                    Log.i("selectDateTime:", String.valueOf(date.getTime()));
//                    Log.i("longToDate：", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(date.getTime())));
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

    public TimeChoiceDialog setStartTime(Date startTime) {
        timeRange.setStart_time(startTime);
        return this;
    }

    public Date getEndTime() {
        return timeRange.getEnd_time();
    }

    public TimeChoiceDialog setEndTime(Date endTime) {
        timeRange.setEnd_time(endTime);
        return this;
    }


    public TimeChoiceDialog setStartTime(int hour,int min) {

        timeRange.setStart_time(hour,min);
        return this;
    }

    public TimeChoiceDialog setEndTime(int hour,int min) {
        timeRange.setEnd_time(hour,min);
        return this;
    }

    public DataChoiceListener getDataChoiceListener() {
        return dataChoiceListener;
    }

    public TimeChoiceDialog setDataChoiceListener(DataChoiceListener dataChoiceListener) {
        this.dataChoiceListener = dataChoiceListener;
        return this;
    }

    public TimeChoiceDialog setLineColor(@ColorRes int Res) {
        model.setLineColor(Res);
        return this;
    }

    public TimeChoiceDialog setInterval(int interval) {
        model.setInterval(interval);
        return this;
    }




    public TimeChoiceDialog setItemsVisible(int itemsVisible) {
        model.setItemsVisible(itemsVisible);
        return this;
    }



    public TimeChoiceDialog setTextSizeCenter(@DimenRes int textSizeCenter) {
        model.setTextSizeCenter(textSizeCenter);
        return this;
    }



    public TimeChoiceDialog setTextSizeOuter(@DimenRes int textSizeOuter) {
        model.setTextSizeOuter(textSizeOuter);
        return this;
    }



    public TimeChoiceDialog setTextColorOuter(@ColorRes int textColorOuter) {
        model.setTextColorOuter(textColorOuter);
        return this;
    }



    public TimeChoiceDialog setTextColorCenter(@ColorRes int textColorCenter) {
        model.setTextColorCenter(textColorCenter);
        return this;
    }



    public TimeChoiceDialog setLoop(boolean loop) {
        model.setLoop(loop);
        return this;
    }



    public TimeChoiceDialog setLineHeight(@DimenRes int lineHeight) {
        model.setLineHeight(lineHeight);
        return this;
    }
}
