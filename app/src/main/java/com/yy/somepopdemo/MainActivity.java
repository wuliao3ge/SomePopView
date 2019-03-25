package com.yy.somepopdemo;


import android.app.ActionBar;
import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.Toast;


import com.yy.somepop.framework.DataChoiceListener;

import com.yy.somepop.framework.DefaultListener;
import com.yy.somepop.framework.ListItemListener;
import com.yy.somepop.widget.DateAndTimeChoiceDialog;
import com.yy.somepop.widget.DateChoiceDialog;
import com.yy.somepop.widget.DefaultDialog;
import com.yy.somepop.widget.ListDialog;
import com.yy.somepop.widget.ProgressBarDialog;
import com.yy.somepop.widget.TimeChoiceDialog;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ProgressBarDialog progressBarDialog;
    private final Timer timer = new Timer();
    private TimerTask task;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            // 要做的事情
            super.handleMessage(msg);
            progressBarDialog.setProgressRead(msg.what);
        }
    };
    private int press=0;
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
                DefaultDialog defaultDialog = new DefaultDialog(this)
                        .setDialogTitle("hahahah")
                        .setDialogMessage("gagagag");
                defaultDialog.setCanceledOnTouchOutside(false);
//                defaultDialog.setCenterListener(new DefaultListener() {
//                    @Override
//                    public void onClick(Dialog dialog) {
//                        Toast.makeText(MainActivity.this,"中间",Toast.LENGTH_LONG).show();
//                    }
//                });
                defaultDialog.setLeftListener(new DefaultListener() {
                    @Override
                    public void onClick(Dialog dialog) {
                        Toast.makeText(MainActivity.this,"zuoanniu",Toast.LENGTH_LONG).show();
                    }
                }).setRightListener(new DefaultListener() {
                    @Override
                    public void onClick(Dialog dialog) {
                        Toast.makeText(MainActivity.this,"youanniu",Toast.LENGTH_LONG).show();
                    }
                });
                defaultDialog.setRightBtnBackground(R.drawable.bg_btn_dialog_left);
                android.widget.TableRow.LayoutParams lp = new android.widget.TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
                lp.setMargins(20, 10, 5, 10);
                defaultDialog.setLeftLp(lp);
                defaultDialog.setLeftBtnBackground(R.drawable.bg_btn_forgetpwd_gray);
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
//                            .setStartTime(2018,4,5)
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
            case R.id.btn5:
                if(progressBarDialog==null)
                {
                    progressBarDialog = new ProgressBarDialog(this,R.style.dialog)
                            .setDefaultBackground(R.drawable.bg_white)
                            .setProgressMax(20);
                    progressBarDialog.show();
                }else{
                    press = 0;
                    progressBarDialog.show();
                }

                task = new TimerTask() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        if(press<20)
                        {
                            press++;
                            handler.sendEmptyMessage(press);
                        }else{
                            progressBarDialog.dismiss();
                        }

                    }
                };
                timer.schedule(task, 1000, 1000);
                break;
            case R.id.btn6:

                break;
            case R.id.btn7:
                DefaultDialog defaultDialog2 = new DefaultDialog(this,R.style.dialog)
                        .setDialogTitle("ddd")
                        .setDialogMessage("cccc")
                        .setCenterBtnText("知道了")
                        .setCenterListener(new DefaultListener() {
                            @Override
                            public void onClick(Dialog dialog) {
                            }
                        });
                defaultDialog2.setCanceledOnTouchOutside(false);
                defaultDialog2.show();
                break;


        }
    }


}
