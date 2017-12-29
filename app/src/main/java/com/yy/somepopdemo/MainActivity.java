package com.yy.somepopdemo;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yy.somepop.framework.DefaultListener;
import com.yy.somepop.widget.DefaultDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.btn_default)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn_no_title)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id)
        {
            case R.id.btn_default:
                new DefaultDialog(this)
                        .show();
//                        .setMessage("默认样式描述")
//                        .setRightListener(new DefaultListener() {
//                            @Override
//                            public void onClick(Dialog dialog, boolean confirm) {
//
//                            }
//                        })
//                        .show();
                break;
            case R.id.btn_no_title:
//                new DefaultDialog(this)
//                        .setMessage("默认样式描述")
//                        .setLeftListener(new DefaultListener() {
//                            @Override
//                            public void onClick(Dialog dialog, boolean confirm) {
//
//                            }
//                        })
//                        .setRightListener(new DefaultListener() {
//                            @Override
//                            public void onClick(Dialog dialog, boolean confirm) {
//
//                            }
//                        })
//                        .show();
                break;
        }
    }
}
