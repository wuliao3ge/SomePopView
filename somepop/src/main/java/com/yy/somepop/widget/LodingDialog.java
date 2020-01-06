package com.yy.somepop.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.yy.somepop.R;
import com.yy.somepop.databinding.DialogLodingBinding;



public class LodingDialog extends Dialog {

    private DialogLodingBinding binding;
//    private Sprite sprite = new FadingCircle();
    private Context context;

    private View view;

    public LodingDialog(@NonNull Context context) {
        super(context, R.style.dialog);
        this.context = context;
        init();
    }

    public LodingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
        init();
    }

    protected LodingDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
        init();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }


    public void init() {
        View outerView = LayoutInflater.from(context)
                .inflate(R.layout.dialog_loding,
                        null);
        binding = DataBindingUtil.bind(outerView);
    }


    public void initView() {
        binding.layout.addView(getView());
        setContentView(binding.getRoot());
    }

    public View getView() {
        return view;
    }

    public LodingDialog setView(View view) {
        this.view = view;
        return this;
    }
}
