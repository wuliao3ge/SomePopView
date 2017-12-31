package com.yy.somepop.base;

import com.yy.somepop.R;
import com.yy.somepop.framework.DefaultListener;

/**
 * Created by ly on 2017/12/29.
 */

public class BaseDialogModel {
    //标题
    private String title = "";
//    消息
    private String message = "";
    private String leftbtntext = "取消";
    private String rightbtntext = "确定";


//    标题字体大小
    private int titleSize  = R.dimen.font_title;
//    标题颜色
    private int titleColor = R.color.default_text_color;
//    消息字体大小
    private int messageSize = R.dimen.font_title;
//    消息字体颜色
    private int messageColor = R.color.default_text_color;
    //    左侧按钮字体大小
    private int leftBtnSize = R.dimen.font_des;
    //    左侧那妞颜色
    private int leftBtnColor = R.color.default_text_color;
    //    右侧按钮字体大小
    private int rightBtnSize = R.dimen.font_des;
    //    右侧按钮字体颜色
    private int rightBtnColor = R.color.default_text_color;



    private DefaultListener rightListener;
    private DefaultListener leftListener;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public int getMessageSize() {
        return messageSize;
    }

    public void setMessageSize(int messageSize) {
        this.messageSize = messageSize;
    }

    public int getMessageColor() {
        return messageColor;
    }

    public void setMessageColor(int messageColor) {
        this.messageColor = messageColor;
    }

    public String getLeftbtntext() {
        return leftbtntext;
    }

    public void setLeftbtntext(String leftbtntext) {
        this.leftbtntext = leftbtntext;
    }

    public String getRightbtntext() {
        return rightbtntext;
    }

    public void setRightbtntext(String rightbtntext) {
        this.rightbtntext = rightbtntext;
    }

    public int getLeftBtnSize() {
        return leftBtnSize;
    }

    public void setLeftBtnSize(int leftBtnSize) {
        this.leftBtnSize = leftBtnSize;
    }

    public int getLeftBtnColor() {
        return leftBtnColor;
    }

    public void setLeftBtnColor(int leftBtnColor) {
        this.leftBtnColor = leftBtnColor;
    }

    public int getRightBtnSize() {
        return rightBtnSize;
    }

    public void setRightBtnSize(int rightBtnSize) {
        this.rightBtnSize = rightBtnSize;
    }

    public int getRightBtnColor() {
        return rightBtnColor;
    }

    public void setRightBtnColor(int rightBtnColor) {
        this.rightBtnColor = rightBtnColor;
    }
}
