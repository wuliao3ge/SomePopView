package com.yy.somepop.base;

import android.app.Dialog;
import android.content.Context;
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


//    设置标题
    public BaseDialog setDialogTitle(@Nullable CharSequence title){
        baseDialogModel.setTitle(title.toString());
        return this;
    }
    //设置标题
    public BaseDialog setDialogTitle(@StringRes int titleId)
    {
        baseDialogModel.setTitle(context.getResources().getString(titleId));
        return this;
    }


    public BaseDialog setDialogMessage(@Nullable CharSequence title){
        baseDialogModel.setMessage(title.toString());
        return this;
    }
    public BaseDialog setDialogMessage(@StringRes int titleId)
    {
        baseDialogModel.setMessage(context.getResources().getString(titleId));
        return this;
    }









}
