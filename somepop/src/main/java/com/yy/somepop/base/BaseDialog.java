package com.yy.somepop.base;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
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
     * @param id
     * @return
     */
    public BaseDialog setDialogTitleSize(@DimenRes int id)
    {
        baseDialogModel.setTitleSize(context.getResources().getDimensionPixelSize(id));
        return this;
    }

    /**
     * 设置标题字大小
     * @param size
     * @return
     */
    public BaseDialog setDialogTitleSize(float size)
    {
        baseDialogModel.setTitleSize(size);
        return this;
    }

    public BaseDialog setDialogTitleColor(@ColorRes int id)
    {
//        baseDialogModel.setTitleColor(context.getResources().);
        return this;
    }











}
