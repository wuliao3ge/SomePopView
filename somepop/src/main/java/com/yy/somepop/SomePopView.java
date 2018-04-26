package com.yy.somepop;

import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;

import com.yy.somepop.base.BaseDialogModel;
import com.yy.somepop.enums.Align;

/**
 * Created by lyly on 2018/1/17.
 */

public class SomePopView {

    public static SomePopView somePopView;


    //整体背景颜色
    private int defaultBackground  = R.drawable.bg_round_white;
    //    标题背景颜色
    private int titleBackground ;
    //    标题字体大小
    private int titleSize  = R.dimen.font_title;
    //    标题颜色
    private int titleColor = R.color.default_text_color;
    //消息背景颜色
    private int messageBackground ;
    //    消息字体大小
    private int messageSize = R.dimen.font_title;
    //    消息字体颜色
    private int messageColor = R.color.default_text_color;
    //    左侧按钮背景颜色
    private int leftBtnBackground;
    //    左侧按钮字体大小
    private int leftBtnSize = R.dimen.font_des;
    //    左侧那妞颜色
    private int leftBtnColor = R.color.default_text_color;
    //    右侧按钮背景颜色
    private int rightBtnBackground;
    //    右侧按钮字体大小
    private int rightBtnSize = R.dimen.font_des;
    //    右侧按钮字体颜色
    private int rightBtnColor = R.color.default_text_color;
    //    右侧按钮背景颜色
    private int centerBtnBackground;
    //    右侧按钮字体大小
    private int centerBtnSize = R.dimen.font_des;
    //    右侧按钮字体颜色
    private int centerBtnColor = R.color.default_text_color;


    //是否显示标题和消息之间的分割线 默认不显示
    private boolean isShowDivision = false;
    //  分割线颜色
    private int divisionColor = R.color.default_division_color;
    //    分割线大小
    private int divisionSize =R.dimen.division_size;

    private Align titleAlign=Align.CENTER;
    private Align messageAlign = Align.CENTER;

    public static SomePopView getInstance() {
        if(somePopView==null)
        {
            somePopView = new SomePopView();
        }
        return somePopView;
    }



    /**
     * 设置标题字大小
     * @param id 字体大小资源id
     * @return
     */
    public  SomePopView setTitleSize(@DimenRes int id)
    {
        this.titleSize = id;
        return this;
    }


    /**
     * 设置标题颜色
     * @param id 颜色资源id
     * @return
     */
    public SomePopView setTitleColor(@ColorRes int id)
    {
        this.titleColor = id;
        return this;
    }

    /**
     * 设置消息字体大小
     * @param id 字体大小资源id
     * @return
     */
    public SomePopView setMessageSize(@DimenRes int id)
    {
        this.messageSize = id;
        return this;
    }

    /**
     * 设置消息颜色
     * @param id 颜色资源id
     * @return
     */
    public SomePopView setMessageColor(@ColorRes int id)
    {
        this.messageColor = id;
        return this;
    }


    /**
     * 设置左侧按钮字体大小
     * @param id 字体大小资源id
     * @return
     */
    public SomePopView setLeftBtnSize(@DimenRes int id)
    {
        this.leftBtnSize = id;
        return this;
    }

    /**
     * 设置左侧按钮颜色
     * @param id 颜色资源id
     * @return
     */
    public SomePopView setLeftBtnColor(@ColorRes int id)
    {
        this.leftBtnColor = id;
        return this;
    }


    /**
     * 设置右侧按钮字体大小
     * @param id 字体大小资源id
     * @return
     */
    public SomePopView setRightBtnSize(@DimenRes int id)
    {
        this.rightBtnSize = id;
        return this;
    }

    /**
     * 设置右侧按钮颜色
     * @param id 颜色资源id
     * @return
     */
    public SomePopView setRightBtnColor(@ColorRes int id)
    {
        this.rightBtnColor = id;
        return this;
    }


    /**
     * 设置左侧和右侧按钮颜色
     * @param id 颜色资源id
     * @return
     */
    public SomePopView setBtnColor(@ColorRes int id)
    {
        this.leftBtnColor=id;
        this.rightBtnColor = id;
        return this;
    }


    /**
     * 设置整体背景
     * @param id 背景id
     * @return
     */
    public SomePopView setDefaultBackground(@DrawableRes int id){
        this.defaultBackground = id;
        return this;
    }


    /**
     * 设置标题背景
     * @param id 背景id
     * @return
     */
    public SomePopView setTitleBackground(@DrawableRes int id){
        this.titleBackground = id;
        return this;
    }

    /**
     * 设置消息背景
     * @param id 背景id
     * @return
     */
    public SomePopView setMessageBackground(@DrawableRes int id){
        this.messageBackground = id;
        return this;
    }


    /**
     * 设置左侧按钮背景
     * @param id 背景id
     * @return
     */
    public SomePopView setLeftBtnBackground(@DrawableRes int id){
        this.leftBtnBackground = id;
        return this;
    }

    /**
     * 设置右侧按钮背景
     * @param id 背景id
     * @return
     */
    public SomePopView setRightBtnBackground(@DrawableRes int id){
        this.rightBtnBackground = id;
        return this;
    }


    /**
     * 设置是否显示横向分割线
     * @param  ishsow 是否显示
     * @return
     */
    public SomePopView setisShowDivision(boolean ishsow){
        this.isShowDivision = ishsow;
        return this;
    }

    /**
     * 设置分割线的颜色
     * @param id 颜色id
     * @return
     */
    public SomePopView setDivisionColor(@ColorRes int id){
        this.divisionColor = id;
        return this;
    }

    /**
     * 设置风格线高度（宽度）
     * @param id 资源id
     * @return
     */
    public SomePopView setDivisionSize(@DimenRes int id)
    {
        this.divisionSize = id;
        return this;
    }

    public SomePopView setTitleAlign(Align titleAlign) {
        this.titleAlign = titleAlign;
        return this;
    }

    public SomePopView setMessageAlign(Align messageAlign) {
        this.messageAlign = messageAlign;
        return this;
    }

    public SomePopView setCenterBtnBackground(int centerBtnBackground) {
        this.centerBtnBackground = centerBtnBackground;
        return this;
    }

    public SomePopView setCenterBtnSize(int centerBtnSize) {
        this.centerBtnSize = centerBtnSize;
        return this;
    }

    public SomePopView setCenterBtnColor(int centerBtnColor) {
        this.centerBtnColor = centerBtnColor;
        return this;
    }

    public Align getTitleAlign() {
        return titleAlign;

    }

    public Align getMessageAlign() {
        return messageAlign;
    }

    public int getDefaultBackground() {
        return defaultBackground;
    }

    public int getTitleBackground() {
        return titleBackground;
    }

    public int getTitleSize() {
        return titleSize;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public int getMessageBackground() {
        return messageBackground;
    }

    public int getMessageSize() {
        return messageSize;
    }

    public int getMessageColor() {
        return messageColor;
    }

    public int getLeftBtnBackground() {
        return leftBtnBackground;
    }

    public int getLeftBtnSize() {
        return leftBtnSize;
    }

    public int getLeftBtnColor() {
        return leftBtnColor;
    }

    public int getRightBtnBackground() {
        return rightBtnBackground;
    }

    public int getRightBtnSize() {
        return rightBtnSize;
    }

    public int getRightBtnColor() {
        return rightBtnColor;
    }

    public boolean isShowDivision() {
        return isShowDivision;
    }

    public int getDivisionColor() {
        return divisionColor;
    }

    public int getDivisionSize() {
        return divisionSize;
    }

    public int getCenterBtnBackground() {
        return centerBtnBackground;
    }

    public int getCenterBtnSize() {
        return centerBtnSize;
    }

    public int getCenterBtnColor() {
        return centerBtnColor;
    }
}
