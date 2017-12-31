package com.yy.somepop.utils;

import android.databinding.BindingAdapter;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ly on 2017/12/28.
 */

public class AttrSettingUtils {
//    设置textview的字体大小
    @BindingAdapter("setTextSize")
    public static void setTextSize(TextView textView, int font){
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                textView.getContext().getResources().getDimensionPixelSize(font));
    }

//  设置textview的字体颜色
    @BindingAdapter("setTextColor")
    public static void setTextColor(TextView textView, int color){
        textView.setTextColor(textView.getResources().getColor(color));
    }


    @BindingAdapter("setLayoutBackground")
    public static void setLLBackground(LinearLayout linearLayout, int Res){
        if(Res>0)
        {
            linearLayout.setBackgroundResource(Res);
        }

    }


    @BindingAdapter("setTvBackground")
    public static void setTvBackground(TextView textView, int Res){
        if(Res>0)
        {
            textView.setBackgroundResource(Res);
        }

    }

}
