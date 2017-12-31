package com.yy.somepop.base;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.AnyRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

/**
 * Created by ly on 2017/12/29.
 */

public class BaseDialog extends Dialog {

    protected BaseDialogModel baseDialogModel;
    protected Context context;
    public BaseDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        baseDialogModel = new BaseDialogModel();
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
        baseDialogModel = new BaseDialogModel();
    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
        baseDialogModel = new BaseDialogModel();
    }
    /**
     * 设置标题
     * @param title 标题
     * @return
     */
    public BaseDialog setDialogTitle(@Nullable CharSequence title){
        baseDialogModel.setTitle(title.toString());
        return this;
    }

    /**
     * 设置标题
     * @param titleId 资源id
     * @return
     */
    public BaseDialog setDialogTitle(@StringRes int titleId)
    {
        baseDialogModel.setTitle(context.getResources().getString(titleId));
        return this;
    }

    /**
     * 设置消息
     * @param message 消息字符
     * @return
     */
    public BaseDialog setDialogMessage(@NonNull CharSequence message){
        baseDialogModel.setMessage(message.toString());
        return this;
    }

    /**
     * 设置消息
     * @param messageId 消息id
     * @return
     */
    public BaseDialog setDialogMessage(@StringRes int messageId)
    {
        baseDialogModel.setMessage(context.getResources().getString(messageId));
        return this;
    }
    /**
     * 设置标题字大小
     * @param id 字体大小资源id
     * @return
     */
    public BaseDialog setTitleSize(@DimenRes int id)
    {
        baseDialogModel.setTitleSize(id);
        return this;
    }

//    /**
//     * 设置标题字大小
//     * @param size
//     * @return
//     */
//    public BaseDialog setDialogTitleSize(float size)
//    {
//        baseDialogModel.setTitleSize(size);
//        return this;
//    }

    /**
     * 设置标题颜色
     * @param id 颜色资源id
     * @return
     */
    public BaseDialog setTitleColor(@ColorRes int id)
    {
        baseDialogModel.setTitleColor(id);
        return this;
    }

    /**
     * 设置消息字体大小
     * @param id 字体大小资源id
     * @return
     */
    public BaseDialog setMessageSize(@DimenRes int id)
    {
        baseDialogModel.setMessageSize(id);
        return this;
    }

    /**
     * 设置消息颜色
     * @param id 颜色资源id
     * @return
     */
    public BaseDialog setMessageColor(@ColorRes int id)
    {
        baseDialogModel.setMessageColor(id);
        return this;
    }

    /**
     * 设置左侧按钮字体大小
     * @param id 字体大小资源id
     * @return
     */
    public BaseDialog setLeftBtnSize(@DimenRes int id)
    {
        baseDialogModel.setLeftBtnSize(id);
        return this;
    }

    /**
     * 设置左侧按钮颜色
     * @param id 颜色资源id
     * @return
     */
    public BaseDialog setLeftBtnColor(@ColorRes int id)
    {
        baseDialogModel.setLeftBtnColor(id);
        return this;
    }
    /**
     * 设置右侧按钮字体大小
     * @param id 字体大小资源id
     * @return
     */
    public BaseDialog setRightBtnSize(@DimenRes int id)
    {
        baseDialogModel.setRightBtnSize(id);
        return this;
    }

    /**
     * 设置右侧按钮颜色
     * @param id 颜色资源id
     * @return
     */
    public BaseDialog setRightBtnColor(@ColorRes int id)
    {
        baseDialogModel.setRightBtnColor(id);
        return this;
    }


    /**
     * 设置整体背景
     * @param id 背景id
     * @return
     */
    public BaseDialog setDefaultBackground(@DrawableRes int id){
        baseDialogModel.setDefaultBackground(id);
        return this;
    }


    /**
     * 设置标题背景
     * @param id 背景id
     * @return
     */
    public BaseDialog setTitleBackground(@DrawableRes int id){
        baseDialogModel.setTitleBackground(id);
        return this;
    }

    /**
     * 设置消息背景
     * @param id 背景id
     * @return
     */
    public BaseDialog setMessageBackground(@DrawableRes int id){
        baseDialogModel.setMessageBackground(id);
        return this;
    }


    /**
     * 设置左侧按钮背景
     * @param id 背景id
     * @return
     */
    public BaseDialog setLeftBtnBackground(@DrawableRes int id){
        baseDialogModel.setLeftBtnBackground(id);
        return this;
    }

    /**
     * 设置右侧按钮背景
     * @param id 背景id
     * @return
     */
    public BaseDialog setRightBtnBackground(@DrawableRes int id){
        baseDialogModel.setRightBtnBackground(id);
        return this;
    }


    /**
     * 设置是否显示横向分割线
     * @param
     * @return
     */
    public BaseDialog setisShowDivision(boolean ishsow){
        baseDialogModel.setShowDivision(ishsow);
        return this;
    }








}
