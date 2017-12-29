package com.yy.somepop.widget;

import android.app.Dialog;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.yy.somepop.R;
import com.yy.somepop.base.BaseDialog;
import com.yy.somepop.databinding.DialogDefaultBinding;
import com.yy.somepop.framework.DefaultListener;
import com.yy.somepop.model.DefaultDialogModel;

/**
 * Created by ly on 2017/12/27.
 */

public class DefaultDialog extends BaseDialog {

    private DialogDefaultBinding binding;
//    private DefaultDialogModel defaultDialogModel;

    public DefaultDialog(@NonNull Context context) {
        super(context);
        init();
    }

    public DefaultDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        init();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_default,
                null, false);
        binding = DataBindingUtil.bind(view);
        setContentView(binding.getRoot());
        binding.setModel(baseDialogModel);
    }

    private void init(){
//        defaultDialogModel = new DefaultDialogModel();
    }

}

