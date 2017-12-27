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

    //标题内容
    private String title;
//    描述内容
    private String des;
//    左侧按钮
    private DefaultInterface leftListener;
//    右侧按钮
    private DefaultInterface rightListener;
//    中间按钮
    private DefaultInterface centerListener;

//    全局举兵
    private Context context;
    //左侧按钮描述
    private String leftBtnDes;
    //右侧按钮描述
    private String rightBtnDes;
    //中间按钮描述
    private String centerBtnDes;

//    标题
    private TextView tvTitle;
//   描述
    private TextView tvDes;
//    标题和描述的分割线
    private View division1;

//    左侧按钮
    private TextView tvBtn1;
//    右侧按钮
    private TextView tvBtn2;
//    中间按钮
    private TextView tvBtn3;


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
        setContentView(R.layout.dialog_default);
        init();
    }

    private void init(){
        tvTitle = (TextView)findViewById(R.id.dialog_default_title);
        tvDes = (TextView)findViewById(R.id.dialog_default_des);
        division1 = (View)findViewById(R.id.dialog_default_division1);

        tvBtn1 = (TextView)findViewById(R.id.dialog_default_btn1);
        tvBtn2 = (TextView)findViewById(R.id.dialog_default_btn2);
        tvBtn3 = (TextView)findViewById(R.id.dialog_default_btn3);


        /** 设置按钮监听 */
        tvBtn1.setOnClickListener(this);
        tvBtn2.setOnClickListener(this);
        tvBtn3.setOnClickListener(this);


        /** 设置标题*/
        if(!StringUtils.isEmpty(title))
        {
            tvTitle.setVisibility(View.VISIBLE);
            division1.setVisibility(View.VISIBLE);
            tvTitle.setText(title);
        }else{
            division1.setVisibility(View.GONE);
            tvTitle.setVisibility(View.GONE);
        }
        /** 设置描述*/
        if(!StringUtils.isEmpty(des))
        {
            tvDes.setVisibility(View.VISIBLE);
            tvDes.setText(des);
        }else{
            tvDes.setVisibility(View.GONE);
        }

        if(leftListener!=null&&rightListener!=null&&centerListener!=null)
        {
            tvBtn1.setVisibility(View.VISIBLE);
            tvBtn2.setVisibility(View.VISIBLE);
            tvBtn3.setVisibility(View.VISIBLE);
            tvBtn3.setBackgroundResource(R.drawable.bg_btn_square_white);
        }else if(leftListener==null||rightListener==null&&centerListener!=null){
            tvBtn1.setVisibility(View.GONE);
            tvBtn2.setVisibility(View.GONE);
            tvBtn3.setVisibility(View.VISIBLE);
            tvBtn3.setBackgroundResource(R.drawable.bg_btn_round_white);
        }else{

        }



    }

    public DefaultDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public String getDes() {
        return des;
    }

    public DefaultDialog setDes(String des) {
        this.des = des;
        return this;
    }


    public String getLeftBtnDes() {
        return leftBtnDes;
    }

    public DefaultDialog setLeftBtnDes(String leftBtnDes) {
        this.leftBtnDes = leftBtnDes;
        return this;
    }

    public String getRightBtnDes() {
        return rightBtnDes;
    }

    public DefaultDialog setRightBtnDes(String rightBtnDes) {
        this.rightBtnDes = rightBtnDes;
        return this;
    }

    public String getCenterBtnDes() {
        return centerBtnDes;
    }

    public DefaultDialog setCenterBtnDes(String centerBtnDes) {
        this.centerBtnDes = centerBtnDes;
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
        if (i == R.id.dialog_default_btn1) {
            if (leftListener != null) {
                leftListener.onClick(this, false);
            }
            this.dismiss();
        } else if (i == R.id.dialog_default_btn2) {
            if (rightListener != null) {
                rightListener.onClick(this, true);
            }
            this.dismiss();
        } else if (i == R.id.dialog_default_btn3) {
            if (centerListener != null) {
                centerListener.onClick(this, true);
            }
            this.dismiss();
        }
    }




}

