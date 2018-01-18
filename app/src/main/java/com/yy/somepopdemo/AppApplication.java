package com.yy.somepopdemo;

import android.app.Application;

import com.yy.somepop.SomePopView;
import com.yy.somepop.enums.Align;

/**
 * Created by lyly on 2018/1/17.
 */

public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SomePopView.getInstance()
                .setBtnColor(R.color.colorAccent)
//                .setMessageAlign(Align.LEFT)
//                .setTitleAlign(Align.LEFT)
        .setDefaultBackground(R.drawable.bg_white);
    }
}
