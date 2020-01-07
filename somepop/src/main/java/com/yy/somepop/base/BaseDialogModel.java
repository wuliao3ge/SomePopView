package com.yy.somepop.base;

import android.app.Application;
import android.widget.TableRow;

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
    private String centerbtntext = "确定";
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
    //    中间按钮背景颜色
    private int centerBtnBackground = SomePopView.getInstance().getCenterBtnBackground();
    //    中间按钮字体大小
    private int centerBtnSize = SomePopView.getInstance().getCenterBtnSize();
    //    中间按钮字体颜色
    private int centerBtnColor = SomePopView.getInstance().getCenterBtnColor();

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
    private boolean isShowBtn = true;

    private Align titleAlign=SomePopView.getInstance().getTitleAlign();
    private Align messageAlign = SomePopView.getInstance().getMessageAlign();

    private TableRow.LayoutParams leftLp;
    private TableRow.LayoutParams rightLp;
    private TableRow.LayoutParams centerLp;

    private BaseDialog baseDialog;

    public BaseDialogModel() {

    }

    public BaseDialogModel(BaseDialog baseDialog) {
        this.baseDialog = baseDialog;
        leftbtntext = baseDialog.getContext().getString(R.string.cancel);
        rightbtntext = baseDialog.getContext().getString(R.string.confirm);
        centerbtntext = baseDialog.getContext().getString(R.string.confirm);
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

    public void onCenterListener(){
        if(baseDialog!=null)
        {
            baseDialog.dismiss();
            if(centerListener!=null)
            {
                centerListener.onClick(baseDialog);
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

    public String getCenterbtntext() {
        return centerbtntext;
    }

    public void setCenterBtntext(String centerbtntext) {
        this.centerbtntext = centerbtntext;
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

    public int getCenterBtnBackground() {
        return centerBtnBackground;
    }

    public void setCenterBtnBackground(int centerBtnBackground) {
        this.centerBtnBackground = centerBtnBackground;
    }

    public int getCenterBtnSize() {
        return centerBtnSize;
    }

    public void setCenterBtnSize(int centerBtnSize) {
        this.centerBtnSize = centerBtnSize;
    }

    public int getCenterBtnColor() {
        return centerBtnColor;
    }

    public void setCenterBtnColor(int centerBtnColor) {
        this.centerBtnColor = centerBtnColor;
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


    public TableRow.LayoutParams getLeftLp() {
        return leftLp;
    }

    public void setLeftLp(TableRow.LayoutParams leftLp) {
        this.leftLp = leftLp;
    }

    public TableRow.LayoutParams getRightLp() {
        return rightLp;
    }

    public void setRightLp(TableRow.LayoutParams rightLp) {
        this.rightLp = rightLp;
    }

    public TableRow.LayoutParams getCenterLp() {
        return centerLp;
    }

    public void setCenterLp(TableRow.LayoutParams centerLp) {
        this.centerLp = centerLp;
    }
}
