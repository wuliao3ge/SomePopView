package com.yy.somepop.widget;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.yy.somepop.R;
import com.yy.somepop.base.BaseDialog;
import com.yy.somepop.databinding.DialogProgressbarBinding;

/**
 * <pre>
 *     author : lyy
 *     time   : 2018/02/12
 *     desc   :
 *     version: 1.0
 * </pre>
 */


public class ProgressBarDialog extends BaseDialog<ProgressBarDialog>{


    private DialogProgressbarBinding dialogProgressbarBinding;

    public ProgressBarDialog(@NonNull Context context) {
        super(context);
    }

    public ProgressBarDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected ProgressBarDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void init() {
        View outerView = LayoutInflater.from(context)
                .inflate(R.layout.dialog_progressbar,
                        null);
        dialogProgressbarBinding = DataBindingUtil.bind(outerView);
    }


    @Override
    public void setView() {
        isShowBtn(false);
        //将布局设置给Dialog
        addView(dialogProgressbarBinding.getRoot());
    }


    public ProgressBarDialog setProgressMax(int max)
    {
        dialogProgressbarBinding.numberProgressBar.setMax(max);
        return this;
    }
    public ProgressBarDialog setProgressRead(int readLength)
    {
        dialogProgressbarBinding.numberProgressBar.setProgress(readLength);
        return this;
    }

    public ProgressBarDialog upProgress(int max,int readLength)
    {
        dialogProgressbarBinding.numberProgressBar.setMax(max);
        dialogProgressbarBinding.numberProgressBar.setProgress(readLength);
        return this;
    }

}
