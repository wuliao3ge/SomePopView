package com.yy.somepopdemo;


import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;


import com.yy.somepop.framework.DataChoiceListener;

import com.yy.somepop.framework.DefaultListener;
import com.yy.somepop.framework.ListItemListener;
import com.yy.somepop.widget.DateAndTimeChoiceDialog;
import com.yy.somepop.widget.DateChoiceDialog;
import com.yy.somepop.widget.DefaultDialog;
import com.yy.somepop.widget.ListDialog;
import com.yy.somepop.widget.TimeChoiceDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    DefaultDialog bottomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id)
        {
            case R.id.btn_default:
                DefaultDialog defaultDialog = new DefaultDialog(this,R.style.dialog)
                        .setDialogTitle("hahahah")
                        .setDialogMessage("gagagag");
                defaultDialog.setCanceledOnTouchOutside(false);
//                defaultDialog.setLeftListener(new DefaultListener() {
//                    @Override
//                    public void onClick(Dialog dialog) {
//                        Toast.makeText(MainActivity.this,"zuoanniu",Toast.LENGTH_LONG).show();
//                    }
//                }).setRightListener(new DefaultListener() {
//                    @Override
//                    public void onClick(Dialog dialog) {
//                        Toast.makeText(MainActivity.this,"youanniu",Toast.LENGTH_LONG).show();
//                    }
//                });
                defaultDialog.show();

//                        .setDialogMessage(R.string.message)
//                        .setTitleSize(R.dimen.font_title )
//                        .setTitleColor(R.color.colorPrimary)
//                        .setMessageSize(R.dimen.font_title)
//                        .setMessageColor(R.color.colorAccent)
//                        .setLeftBtnSize(R.dimen.font_des)
//                        .setLeftBtnColor(R.color.colorPrimaryDark)
//                        .setRightBtnSize(R.dimen.font_title)
//                        .setRightBtnColor(R.color.colorAccent)
//                        .setDivisionColor(R.color.colorPrimary)
//                        .setDivisionSize(R.dimen.division_size1)
//                        .setisShowDivision(false)
//                        .setLeftBtnText("哈哈哈")
//                        .setRightBtnText("嘿嘿嘿");

                break;
            case R.id.btn1:
                new DateAndTimeChoiceDialog(this,R.style.dialog)
                        .setDialogTitle("请选择时间")
//                            .setStartTime(2011,1,5)
                        .setTextColorCenter(R.color.colorPrimary)
//                        .setBtnColor(R.color.colorPrimary)
                        .setDataChoiceListener(new DataChoiceListener() {
                            @Override
                            public void dataChoice(long time) {
                                Log.i("时间选择器",time+"");
                            }
                        })
                        .show();
                break;
            case R.id.btn2:
                new DateChoiceDialog(this,R.style.dialog)
                        .setDialogTitle("请选择时间")
//                            .setStartTime(2011,1,5)
                        .setLineColor(R.color.colorPrimary)
                        .setBtnColor(R.color.colorPrimary)
                        .setDataChoiceListener(new DataChoiceListener() {
                            @Override
                            public void dataChoice(long time) {
                                Log.i("时间选择器",time+"");
                            }
                        })
                        .show();
                break;
            case R.id.btn3:
                    new TimeChoiceDialog(this,R.style.dialog)
                    .setDialogTitle("请选择时间")
//                            .setStartTime(2011,1,5)
                            .setLineColor(R.color.colorPrimary)
                            .setBtnColor(R.color.colorPrimary)
                            .setStartTime(3,10)
//                            .setEndTime(2018,1,12)
                            .setDataChoiceListener(new DataChoiceListener() {
                                @Override
                                public void dataChoice(long time) {
                                    Log.i("时间选择器",time+"");
                                }
                            })
                    .show();
                break;
            case R.id.btn4:
                new ListDialog(this,R.style.dialog)
                        .setDefaultBackground(R.drawable.bg_round_white)
                        .addItem("哈哈哈")
                        .addItem("嘿嘿嘿")
                        .addItem("取消")
                        .setListItemListener(new ListItemListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                switch (position)
                                {

                                }
                            }
                        })
                        .show();
                break;
        }
    }


}
