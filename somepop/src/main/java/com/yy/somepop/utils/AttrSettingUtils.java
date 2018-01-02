package com.yy.somepop.utils;

import android.databinding.BindingAdapter;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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


    //设置LinearLayout背景颜色
    @BindingAdapter("setLayoutBackground")
    public static void setLLBackground(LinearLayout linearLayout, int Res){
        if(Res>0)
        {
            linearLayout.setBackgroundResource(Res);
        }

    }

    //设置TextView的背景颜色
    @BindingAdapter("setTvBackground")
    public static void setTvBackground(TextView textView, int Res){
        if(Res>0)
        {
            textView.setBackgroundResource(Res);
        }
    }
    @BindingAdapter("setDivisionSizeForH")
    public static void setDivisionSizeForH(View view, int Res)
    {
        if(Res>0)
        {
            LinearLayout.LayoutParams params=
                    new LinearLayout.LayoutParams(
                            view.getContext().getResources().getDimensionPixelSize(Res), ViewGroup.LayoutParams.MATCH_PARENT );
            view.setLayoutParams(params);
        }
    }


    @BindingAdapter("setDivisionSizeForV")
    public static void setDivisionSizeForV(View view, int Res)
    {
        if(Res>0)
        {
            LinearLayout.LayoutParams params=
                    new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                            view.getContext().getResources().getDimensionPixelSize(Res));
            view.setLayoutParams(params);
        }
    }

    @BindingAdapter("setDivisionColor")
    public static void setDivisionColor(View view, int Res){
        if(Res>0)
        {
            view.setBackgroundColor(Res);
        }
    }



}
