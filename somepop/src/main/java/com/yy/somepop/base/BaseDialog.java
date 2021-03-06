package com.yy.somepop.base;

import android.app.Dialog;
import android.content.Context;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableRow;

import com.yy.somepop.R;
import com.yy.somepop.databinding.DialogBaseBinding;
import com.yy.somepop.framework.DefaultListener;

/**
 * Created by ly on 2017/12/29.
 */

public abstract class BaseDialog<T> extends Dialog {

    protected BaseDialogModel baseDialogModel;
    protected Context context;
    protected DialogBaseBinding binding;
    private View additionalView;
    public BaseDialog(@NonNull Context context) {
        super(context,R.style.dialog);
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
        setView();
        if(additionalView!=null)
        {
            binding.isview.addView(additionalView);
        }
    }


    public DialogBaseBinding getBinding() {
        return binding;
    }

    public void setBinding(DialogBaseBinding binding) {
        this.binding = binding;
    }

    abstract public void init();
    abstract public void setView();


    protected void addView(View view){
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
     * 设置右侧按钮描述
     * @param text 描述
     * @return
     */
    public  T setCenterBtnText(@NonNull CharSequence text)
    {
        baseDialogModel.setCenterBtntext(text.toString());
        return (T)this;
    }


    /**
     * 设置右侧按钮字体大小
     * @param id 字体大小资源id
     * @return
     */
    public  T setCenterBtnSize(@DimenRes int id)
    {
        baseDialogModel.setCenterBtnSize(id);
        return (T)this;
    }

    /**
     * 设置右侧按钮颜色
     * @param id 颜色资源id
     * @return
     */
    public  T setCenterBtnColor(@ColorRes int id)
    {
        baseDialogModel.setCenterBtnColor(id);
        return (T)this;
    }




    /**
     * 设置按钮颜色
     * @param id 颜色资源id
     * @return
     */
    public  T setBtnColor(@ColorRes int id)
    {
        baseDialogModel.setLeftBtnColor(id);
        baseDialogModel.setRightBtnColor(id);
        baseDialogModel.setCenterBtnColor(id);
        return (T)this;
    }

    /**
     * 设置按钮字体大小
     * @param id 字体大小资源id
     * @return
     */
    public  T setBtnSize(@DimenRes int id)
    {
        baseDialogModel.setRightBtnSize(id);
        baseDialogModel.setLeftBtnSize(id);
        baseDialogModel.setCenterBtnSize(id);
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
     * 设置右侧按钮背景
     * @param id 背景id
     * @return
     */
    public  T setCenterBtnBackground(@DrawableRes int id){
        baseDialogModel.setCenterBtnBackground(id);
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
     * 设置分割线高度（宽度）
     * @param id 资源id
     * @return
     */
    public  T setDivisionSize(@DimenRes int id)
    {
        baseDialogModel.setDivisionSize(id);
        return (T)this;
    }


    /**
     * 设置右侧按钮监听
     * @param defaultListener
     * @return
     */
    public  T setRightListener(DefaultListener defaultListener)
    {
        baseDialogModel.setRightListener(defaultListener);
        return (T)this;
    }

    /**
     * 设置左侧按钮监听
     * @param defaultListener
     * @return
     */
    public  T setLeftListener(DefaultListener defaultListener)
    {
        baseDialogModel.setLeftListener(defaultListener);
        return (T)this;
    }


    /**
     * 设置中间按钮监听
     * @param defaultListener
     * @return
     */
    public T setCenterListener(DefaultListener defaultListener){
        baseDialogModel.setCenterListener(defaultListener);
        return (T)this;
    }


    /**
     * 是否显示下方按钮
     * @param isShow
     * @return
     */
    public T isShowBtn(boolean isShow)
    {
        baseDialogModel.setShowBtn(isShow);
        return (T)this;
    }


    /**
     * 设置左按钮布局
     * @param lp
     * @return
     */
    public  T setLeftLp(@NonNull TableRow.LayoutParams lp){
        baseDialogModel.setLeftLp(lp);
        return (T)this;
    }

    /**
     * 设置左按钮布局
     * @param lp
     * @return
     */
    public  T setRightLp(@NonNull TableRow.LayoutParams lp){
        baseDialogModel.setRightLp(lp);
        return (T)this;
    }

    /**
     * 设置左按钮布局
     * @param lp
     * @return
     */
    public  T setCenterLp(@NonNull TableRow.LayoutParams lp){
        baseDialogModel.setCenterLp(lp);
        return (T)this;
    }

}
