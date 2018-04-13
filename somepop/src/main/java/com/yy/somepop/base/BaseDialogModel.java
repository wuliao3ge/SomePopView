package com.yy.somepop.base;

import android.app.Application;

import com.yy.somepop.R;
import com.yy.somepop.SomePopView;
import com.yy.somepop.enums.Align;
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
    //整体背景颜色
    private int defaultBackground  = SomePopView.getInstance().getDefaultBackground();
//    标题背景颜色
    private int titleBackground  = SomePopView.getInstance().getTitleBackground();
//    标题字体大小
    private int titleSize  = SomePopView.getInstance().getTitleSize();
//    标题颜色
    private int titleColor = SomePopView.getInstance().getTitleColor();
    //消息背景颜色
    private int messageBackground = SomePopView.getInstance().getMessageBackground();
//    消息字体大小
    private int messageSize = SomePopView.getInstance().getMessageSize();
//    消息字体颜色
    private int messageColor = SomePopView.getInstance().getMessageColor();
//    左侧按钮背景颜色
    private int leftBtnBackground = SomePopView.getInstance().getLeftBtnBackground();
    //    左侧按钮字体大小
    private int leftBtnSize = SomePopView.getInstance().getLeftBtnSize();
    //    左侧那妞颜色
    private int leftBtnColor = SomePopView.getInstance().getLeftBtnColor();
    //    右侧按钮背景颜色
    private int rightBtnBackground = SomePopView.getInstance().getRightBtnBackground();
    //    右侧按钮字体大小
    private int rightBtnSize = SomePopView.getInstance().getRightBtnSize();
    //    右侧按钮字体颜色
    private int rightBtnColor = SomePopView.getInstance().getRightBtnColor();
    //是否显示标题和消息之间的分割线 默认不显示
    private boolean isShowDivision = SomePopView.getInstance().isShowDivision();
//  分割线颜色
    private int divisionColor =SomePopView.getInstance().getDivisionColor();
//    分割线大小
    private int divisionSize =SomePopView.getInstance().getDivisionSize();

    //左侧按钮监听
    private DefaultListener rightListener;
    //右侧按钮
    private DefaultListener leftListener;
//  中间按钮监听
    private DefaultListener centerListener;
    private boolean isShowBtn;

    private Align titleAlign=SomePopView.getInstance().getTitleAlign();
    private Align messageAlign = SomePopView.getInstance().getMessageAlign();



    private BaseDialog baseDialog;

    public BaseDialogModel() {

    }

    public BaseDialogModel(BaseDialog baseDialog) {
        this.baseDialog = baseDialog;
    }

    public void onLeftListener(){
        if(baseDialog!=null)
        {
            baseDialog.dismiss();
            if(leftListener!=null)
            {
                leftListener.onClick(baseDialog);
            }
        }
    }

    public void onRightListener(){
        if(baseDialog!=null)
        {
            baseDialog.dismiss();
            if(rightListener!=null)
            {
                rightListener.onClick(baseDialog);
            }
        }
    }


    public BaseDialog getBaseDialog() {
        return baseDialog;
    }

    public void setBaseDialog(BaseDialog baseDialog) {
        this.baseDialog = baseDialog;
    }


    public boolean isShowBtn() {
        return isShowBtn;
    }

    public void setShowBtn(boolean showBtn) {
        isShowBtn = showBtn;
    }

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

    public int getDefaultBackground() {
        return defaultBackground;
    }

    public void setDefaultBackground(int defaultBackground) {
        this.defaultBackground = defaultBackground;
    }

    public int getTitleBackground() {
        return titleBackground;
    }

    public void setTitleBackground(int titleBackground) {
        this.titleBackground = titleBackground;
    }

    public int getMessageBackground() {
        return messageBackground;
    }

    public void setMessageBackground(int messageBackground) {
        this.messageBackground = messageBackground;
    }

    public int getLeftBtnBackground() {
        return leftBtnBackground;
    }

    public void setLeftBtnBackground(int leftBtnBackground) {
        this.leftBtnBackground = leftBtnBackground;
    }

    public int getRightBtnBackground() {
        return rightBtnBackground;
    }

    public void setRightBtnBackground(int rightBtnBackground) {
        this.rightBtnBackground = rightBtnBackground;
    }

    public boolean isShowDivision() {
        return isShowDivision;
    }

    public void setShowDivision(boolean showDivision) {
        isShowDivision = showDivision;
    }

    public int getDivisionColor() {
        return divisionColor;
    }

    public void setDivisionColor(int divisionColor) {
        this.divisionColor = divisionColor;
    }

    public int getDivisionSize() {
        return divisionSize;
    }

    public void setDivisionSize(int divisionSize) {
        this.divisionSize = divisionSize;
    }

    public DefaultListener getCenterListener() {
        return centerListener;
    }

    public void setCenterListener(DefaultListener centerListener) {
        this.centerListener = centerListener;
    }

    public Align getTitleAlign() {
        return titleAlign;
    }

    public void setTitleAlign(Align titleAlign) {
        this.titleAlign = titleAlign;
    }

    public Align getMessageAlign() {
        return messageAlign;
    }

    public void setMessageAlign(Align messageAlign) {
        this.messageAlign = messageAlign;
    }
}
