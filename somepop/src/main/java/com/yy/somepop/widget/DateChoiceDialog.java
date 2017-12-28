package com.yy.somepop.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.yy.somepop.R;
import com.yy.somepop.framework.DateInterface;
import com.yy.somepop.framework.DefaultListener;
import com.yy.somepop.utils.StringUtils;
import com.yy.somepop.wheelview.WheelView;

import java.util.Date;

/**
 * Created by ly on 2017/12/25.
 */

public class DateChoiceDialog extends Dialog implements View.OnClickListener{

    //
    private String title;
    private DefaultListener leftlistener;
    private DefaultListener rightlistener;
    private DateInterface centerDateInterface;
    private DefaultState defaultState;
    private Context context;
    private String confirm;


    private TextView tvTitle;
    private WheelView wvYear;
    private WheelView wvMonth;
    private WheelView wvDay;
    private TextView tvBtn1;
    private TextView tvBtn2;
    private TextView tvBtn3;


    private Date StartTime;
    private Date endTime;


    public DateChoiceDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public DateChoiceDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_datechoice);
        init();
    }

    private void init(){
        tvTitle = (TextView)findViewById(R.id.dialog_date_title);
        wvYear = (WheelView)findViewById(R.id.dialog_date_wv1);
        wvMonth = (WheelView)findViewById(R.id.dialog_date_wv2);
        wvDay = (WheelView)findViewById(R.id.dialog_date_wv3);
        tvBtn1 = (TextView)findViewById(R.id.dialog_date_btn1);
        tvBtn2 = (TextView)findViewById(R.id.dialog_date_btn2);
        tvBtn3 = (TextView)findViewById(R.id.dialog_date_btn3);

        /** 设置标题*/
        if(!StringUtils.isEmpty(title))
        {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(title);
        }else{
            tvTitle.setVisibility(View.GONE);
        }



        /** 设置按钮监听 */
        tvBtn1.setOnClickListener(this);
        tvBtn2.setOnClickListener(this);
        tvBtn3.setOnClickListener(this);
    }

    public DateChoiceDialog setTitle(String title) {
        this.title = title;
        return this;
    }



    @Override
    public void onClick(View v) {
//        int i = v.getId();
//        if (i == R.id.dialog_date_btn1) {
//            if (leftlistener != null) {
//                leftlistener.onClick(this, false);
//            }
//            this.dismiss();
//        } else if (i == R.id.dialog_date_btn2) {
//            if (rightlistener != null) {
//                rightlistener.onClick(this, true);
//            }
//            this.dismiss();
//        } else if (i == R.id.dialog_date_btn3) {
//            if (rightlistener != null) {
//                rightlistener.onClick(this, true);
//            }
//            this.dismiss();
//        }
    }




}
