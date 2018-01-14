package com.yy.somepop.base;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;

import com.yy.somepop.R;
import com.yy.somepop.databinding.DialogBaseBinding;

/**
 * Created by ly on 2017/12/29.
 */

public abstract class BaseDialog<T> extends Dialog {

    protected BaseDialogModel baseDialogModel;
    protected Context context;
    private DialogBaseBinding binding;
    private View additionalView;
    public BaseDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        baseDialogModel = new BaseDialogModel(this);
        init();
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
        baseDialogModel = new BaseDialogModel(this);
        init();
    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
        baseDialogModel = new BaseDialogModel(this);
        init();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }



    protected void initView(){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_base,
                null, false);
        binding = DataBindingUtil.bind(view);
        setContentView(binding.getRoot());
        binding.setModel(baseDialogModel);
        binding.isview.setVisibility(View.VISIBLE);
        if(additionalView!=null)
        {
            binding.isview.addView(additionalView);
        }
    }


    abstract public void init();


    public void setView(View view){
        this.additionalView = view;
    }



    /**
     * 设置标题
     * @param title 标题
     * @return
     */
    public T setDialogTitle(@Nullable CharSequence title){
        baseDialogModel.setTitle(title.toString());
        return (T)this;
    }

    /**
     * 设置标题
     * @param titleId 资源id
     * @return
     */
    public  T setDialogTitle(@StringRes int titleId)
    {
        baseDialogModel.setTitle(context.getResources().getString(titleId));
        return (T)this;
    }

    /**
     * 设置消息
     * @param message 消息字符
     * @return
     */
    public  T setDialogMessage(@NonNull CharSequence message){
        baseDialogModel.setMessage(message.toString());
        return (T)this;
    }

    /**
     * 设置消息
     * @param messageId 消息id
     * @return
     */
    public  T setDialogMessage(@StringRes int messageId)
    {
        baseDialogModel.setMessage(context.getResources().getString(messageId));
        return (T)this;
    }
    /**
     * 设置标题字大小
     * @param id 字体大小资源id
     * @return
     */
    public  T setTitleSize(@DimenRes int id)
    {
        baseDialogModel.setTitleSize(id);
        return (T)this;
    }


    /**
     * 设置标题颜色
     * @param id 颜色资源id
     * @return
     */
    public  T setTitleColor(@ColorRes int id)
    {
        baseDialogModel.setTitleColor(id);
        return (T)this;
    }

    /**
     * 设置消息字体大小
     * @param id 字体大小资源id
     * @return
     */
    public  T setMessageSize(@DimenRes int id)
    {
        baseDialogModel.setMessageSize(id);
        return (T)this;
    }

    /**
     * 设置消息颜色
     * @param id 颜色资源id
     * @return
     */
    public  T setMessageColor(@ColorRes int id)
    {
        baseDialogModel.setMessageColor(id);
        return (T)this;
    }



    /**
     * 设置左侧按钮描述
     * @param id 资源id
     * @return
     */
    public  T setLeftBtnText(@StringRes int id)
    {
        baseDialogModel.setLeftbtntext(context.getResources().getString(id));
        return (T)this;
    }

    /**
     * 设置左侧按钮描述
     * @param text 描述
     * @return
     */
    public  T setLeftBtnText(@NonNull CharSequence text)
    {
        baseDialogModel.setLeftbtntext(text.toString());
        return (T)this;
    }

    /**
     * 设置左侧按钮字体大小
     * @param id 字体大小资源id
     * @return
     */
    public  T setLeftBtnSize(@DimenRes int id)
    {
        baseDialogModel.setLeftBtnSize(id);
        return (T)this;
    }

    /**
     * 设置左侧按钮颜色
     * @param id 颜色资源id
     * @return
     */
    public  T setLeftBtnColor(@ColorRes int id)
    {
        baseDialogModel.setLeftBtnColor(id);
        return (T)this;
    }

    /**
     * 设置右侧按钮描述
     * @param id 资源id
     * @return
     */
    public  T setRightBtnText(@StringRes int id)
    {
        baseDialogModel.setRightbtntext(context.getResources().getString(id));
        return (T)this;
    }

    /**
     * 设置右侧按钮描述
     * @param text 描述
     * @return
     */
    public  T setRightBtnText(@NonNull CharSequence text)
    {
        baseDialogModel.setRightbtntext(text.toString());
        return (T)this;
    }


    /**
     * 设置右侧按钮字体大小
     * @param id 字体大小资源id
     * @return
     */
    public  T setRightBtnSize(@DimenRes int id)
    {
        baseDialogModel.setRightBtnSize(id);
        return (T)this;
    }

    /**
     * 设置右侧按钮颜色
     * @param id 颜色资源id
     * @return
     */
    public  T setRightBtnColor(@ColorRes int id)
    {
        baseDialogModel.setRightBtnColor(id);
        return (T)this;
    }


    /**
     * 设置整体背景
     * @param id 背景id
     * @return
     */
    public  T setDefaultBackground(@DrawableRes int id){
        baseDialogModel.setDefaultBackground(id);
        return (T)this;
    }


    /**
     * 设置标题背景
     * @param id 背景id
     * @return
     */
    public  T setTitleBackground(@DrawableRes int id){
        baseDialogModel.setTitleBackground(id);
        return (T)this;
    }

    /**
     * 设置消息背景
     * @param id 背景id
     * @return
     */
    public  T setMessageBackground(@DrawableRes int id){
        baseDialogModel.setMessageBackground(id);
        return (T)this;
    }


    /**
     * 设置左侧按钮背景
     * @param id 背景id
     * @return
     */
    public  T setLeftBtnBackground(@DrawableRes int id){
        baseDialogModel.setLeftBtnBackground(id);
        return (T)this;
    }

    /**
     * 设置右侧按钮背景
     * @param id 背景id
     * @return
     */
    public  T setRightBtnBackground(@DrawableRes int id){
        baseDialogModel.setRightBtnBackground(id);
        return (T)this;
    }


    /**
     * 设置是否显示横向分割线
     * @param  ishsow 是否显示
     * @return
     */
    public  T setisShowDivision(boolean ishsow){
        baseDialogModel.setShowDivision(ishsow);
        return (T)this;
    }

    /**
     * 设置分割线的颜色
     * @param id 颜色id
     * @return
     */
    public  T setDivisionColor(@ColorRes int id){
       baseDialogModel.setDivisionColor(id);
        return (T)this;
    }

    /**
     * 设置风格线高度（宽度）
     * @param id 资源id
     * @return
     */
    public  T setDivisionSize(@DimenRes int id)
    {
        baseDialogModel.setDivisionSize(id);
        return (T)this;
    }
}
