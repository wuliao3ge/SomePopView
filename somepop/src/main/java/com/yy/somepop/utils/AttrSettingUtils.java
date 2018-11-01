package com.yy.somepop.utils;

import android.databinding.BindingAdapter;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.yy.somepop.R;
import com.yy.somepop.enums.Align;
import com.yy.somepop.wheelview.WheelView;

/**
 * Created by ly on 2017/12/28.
 */

public class AttrSettingUtils {

    @BindingAdapter("textgravity")
    public static void setGravity(TextView textView, Align align)
    {
        if(align.equals(Align.CENTER))
        {
            textView.setGravity(Gravity.CENTER);
        }else if(align.equals(Align.LEFT)){
            textView.setGravity(Gravity.LEFT);
        }else if(align.equals(Align.RIGHT))
        {
            textView.setGravity(Gravity.RIGHT);
        }
    }


    @BindingAdapter("lineInterval")
    public static void setLineInterval(WheelView wheelView,int interval){
        wheelView.setInterval(interval);
    }

    @BindingAdapter("itemsSize")
    public static void setItemsSize(WheelView wheelView,int itemsVisible)
    {
        wheelView.setItemsVisible(itemsVisible);
    }

    @BindingAdapter("textSizeCenter")
    public static void setTextSizeCenter(WheelView wheelView,int res)
    {
        wheelView.setTextSizeCenter(wheelView.getContext().getResources().getDimensionPixelSize(res));
    }

    @BindingAdapter("textSizeOuter")
    public static void setTextSizeOuter(WheelView wheelView,int res)
    {
        wheelView.setTextSizeOuter(wheelView.getContext().getResources().getDimensionPixelSize(res));
    }

    @BindingAdapter("textColorOuter")
    public static void setTextColorOuter(WheelView wheelView,int res)
    {
        wheelView.setTextColorOuter(wheelView.getResources().getColor(res));
    }
    @BindingAdapter("textColorCenter")
    public static void setTextColorCenter(WheelView wheelView,int res)
    {
        wheelView.setTextColorCenter(wheelView.getResources().getColor(res));
    }

    @BindingAdapter("lineColor")
    public static void setLineColor(WheelView wheelView,int res)
    {
        wheelView.setLineColor(wheelView.getResources().getColor(res));
    }

    @BindingAdapter("isLoop")
    public static void setIsLoop(WheelView wheelView,boolean isLoop)
    {
        wheelView.setLoop(isLoop);
    }

    @BindingAdapter("lineHeight")
    public static void setLineHeight(WheelView wheelView,int res)
    {
        wheelView.setLineHeight(wheelView.getContext().getResources().getDimensionPixelSize(res));
    }



    /****** baseDialog中使用 start *****/
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


    @BindingAdapter("setLp")
    public static void setLp(TextView textView, TableRow.LayoutParams lp){
        if(lp!=null)
        {
            textView.setLayoutParams(lp);
        }
    }

    /****** baseDialog中使用 end *****/


}
