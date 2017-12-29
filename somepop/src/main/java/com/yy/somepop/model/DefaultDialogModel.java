package com.yy.somepop.model;

import com.yy.somepop.R;
import com.yy.somepop.framework.DefaultListener;

/**
 * Created by ly on 2017/12/28.
 */

public class DefaultDialogModel {
    private String title = "这是一个标题";
    private String des = "这是弹出框描述";
    private DefaultListener rightListener;
    private DefaultListener leftListener;
    private DefaultListener centerListener;
    private int titleSize = R.dimen.font_title;
    private int titleColor = R.color.default_text_color;





    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public DefaultListener getRightListener() {
        return rightListener;
    }

    public void setRightListener(DefaultListener rightListener) {
        this.rightListener = rightListener;
    }

    public DefaultListener getLeftListener() {
        return leftListener;
    }

    public void setLeftListener(DefaultListener leftListener) {
        this.leftListener = leftListener;
    }

    public DefaultListener getCenterListener() {
        return centerListener;
    }

    public void setCenterListener(DefaultListener centerListener) {
        this.centerListener = centerListener;
    }

    public int getTitleSize() {
        return titleSize;
    }

    public void setTitleSize(int titleSize) {
        this.titleSize = titleSize;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
    }
}
