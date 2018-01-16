package com.yy.somepop.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.yy.somepop.R;
import com.yy.somepop.base.BaseDialog;
import com.yy.somepop.databinding.DialogSelectDateBinding;
import com.yy.somepop.framework.DataChoiceListener;
import com.yy.somepop.framework.DefaultListener;
import com.yy.somepop.utils.StringUtils;
import com.yy.somepop.utils.TimeRange;
import com.yy.somepop.wheelview.WheelView;

import java.util.Date;

/**
 * Created by ly on 2017/12/25.
 */

public class DateChoiceDialog extends BaseDialog {


    private DataChoiceListener dataChoiceListener;
    private DialogSelectDateBinding binding;
    private TimeRange timeRange;
    private int lineColor;
    private int interval;
    public DateChoiceDialog(@NonNull Context context) {
        super(context);
    }

    public DateChoiceDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected DateChoiceDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void init() {

    }

    @Override
    public void setView() {

    }
}
