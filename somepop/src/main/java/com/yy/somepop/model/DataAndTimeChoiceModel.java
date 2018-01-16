package com.yy.somepop.model;

import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;

import com.yy.somepop.R;
import com.yy.somepop.utils.TimeRange;

/**
 * <pre>
 *     author : lyy
 *     time   : 2018/01/12
 *     desc   :
 *     version: 1.0
 * </pre>
 */


public class DataAndTimeChoiceModel  {

    //间隔
    private int interval =5;
    // 显示几个条目
    private int itemsVisible = 5;
    // 当前选中的字体大小
    private int textSizeCenter = R.dimen.textsizecenter;
    //为选中的字体大小
    private int textSizeOuter = R.dimen.textsizeouter;
    //未选中的字体颜色
    private int textColorOuter = R.color.textcolorouter;
    //选中的字体颜色
    private int textColorCenter = R.color.textcolorcenter;
    //分割线颜色
    private int lineColor = R.color.linescolor;
    //是否循环
    private boolean isLoop = true;
    //分割线高度
    private int lineHeight = R.dimen.lineheight;




    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getItemsVisible() {
        return itemsVisible;
    }

    public void setItemsVisible(int itemsVisible) {
        this.itemsVisible = itemsVisible;
    }

    public int getTextSizeCenter() {
        return textSizeCenter;
    }

    public void setTextSizeCenter(@DimenRes int textSizeCenter) {
        this.textSizeCenter = textSizeCenter;
    }

    public int getTextSizeOuter() {
        return textSizeOuter;
    }

    public void setTextSizeOuter(@DimenRes int textSizeOuter) {
        this.textSizeOuter = textSizeOuter;
    }

    public int getTextColorOuter() {
        return textColorOuter;
    }

    public void setTextColorOuter(@ColorRes int textColorOuter) {
        this.textColorOuter = textColorOuter;
    }

    public int getTextColorCenter() {
        return textColorCenter;
    }

    public void setTextColorCenter(@ColorRes int textColorCenter) {
        this.textColorCenter = textColorCenter;
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(@ColorRes int lineColor) {
        this.lineColor = lineColor;
    }

    public boolean isLoop() {
        return isLoop;
    }

    public void setLoop(boolean loop) {
        isLoop = loop;
    }

    public int getLineHeight() {
        return lineHeight;
    }

    public void setLineHeight(@DimenRes int lineHeight) {
        this.lineHeight = lineHeight;
    }
}
