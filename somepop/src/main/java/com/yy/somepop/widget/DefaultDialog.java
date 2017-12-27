package com.yy.somepop.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.yy.somepop.R;
import com.yy.somepop.framework.DefaultInterface;
import com.yy.somepop.utils.StringUtils;
import com.yy.somepop.wheelview.WheelView;

import java.util.Date;

/**
 * Created by ly on 2017/12/27.
 */

public class DefaultDialog extends Dialog implements View.OnClickListener{

    //
    private String title;
    private DefaultInterface leftListener;
    private DefaultInterface rightListener;
    private DefaultInterface centerListener;
    private Context context;
    //左侧按钮描述
    private String leftBtnDes;
    //右侧按钮描述
    private String rightBtnDes;
    //中间按钮描述
    private String centerBtnDes;

    private TextView tvTitle;
    private WheelView wvYear;
    private WheelView wvMonth;
    private WheelView wvDay;
    private TextView tvBtn1;
    private TextView tvBtn2;
    private TextView tvBtn3;


    private Date StartTime;
    private Date endTime;


    public DefaultDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public DefaultDialog(@NonNull Context context, int themeResId) {
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

    public DefaultDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public DefaultInterface getLeftListener() {
        return leftListener;
    }

    public DefaultDialog setLeftListener(DefaultInterface leftListener) {
        this.leftListener = leftListener;
        return this;
    }

    public DefaultInterface getRightListener() {
        return rightListener;
    }

    public DefaultDialog setRightListener(DefaultInterface rightListener) {
        this.rightListener = rightListener;
        return this;
    }

    public DefaultInterface getCenterListener() {
        return centerListener;
    }

    public DefaultDialog setCenterListener(DefaultInterface centerListener) {
        this.centerListener = centerListener;
        return this;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.dialog_date_btn1) {
            if (leftListener != null) {
                leftListener.onClick(this, false);
            }
            this.dismiss();
        } else if (i == R.id.dialog_date_btn2) {
            if (rightListener != null) {
                rightListener.onClick(this, true);
            }
            this.dismiss();
        } else if (i == R.id.dialog_date_btn3) {
            if (centerListener != null) {
                centerListener.onClick(this, true);
            }
            this.dismiss();
        }
    }




}

