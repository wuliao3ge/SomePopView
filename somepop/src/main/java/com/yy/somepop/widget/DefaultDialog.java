package com.yy.somepop.widget;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.yy.somepop.R;
import com.yy.somepop.base.BaseDialog;
import com.yy.somepop.databinding.DialogDefaultBinding;

/**
 * Created by ly on 2017/12/27.
 */

public class DefaultDialog extends BaseDialog {

    private DialogDefaultBinding binding;

    public DefaultDialog(@NonNull Context context) {
        super(context);
//        init();
    }

    public DefaultDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
//        init();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_default,
//                null, false);
//        binding = DataBindingUtil.bind(view);
//        setContentView(binding.getRoot());
//        binding.setModel(baseDialogModel);
    }
}

