package com.yy.somepop.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.yy.somepop.R;
import com.yy.somepop.base.BaseDialog;
import com.yy.somepop.databinding.DialogSelectListBinding;
import com.yy.somepop.framework.DefaultListener;
import com.yy.somepop.framework.ListChoiceListener;
import com.yy.somepop.model.DataAndTimeChoiceModel;
import com.yy.somepop.utils.DateAndTimeUtils;
import com.yy.somepop.utils.TimeRange;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

/**
 * 列表选择对话框
 */

public class ListChoiceDialog extends BaseDialog<ListChoiceDialog> {

    private ListChoiceListener listChoiceListener;
    private TimeRange timeRange;
    private DialogSelectListBinding binding;
    private DataAndTimeChoiceModel model;

    private List<String> dataList = new ArrayList<>();

    private int initIndex = 0;


    public ListChoiceDialog(@NonNull Context context) {
        super(context);
    }

    public ListChoiceDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected ListChoiceDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void init() {
        model = new DataAndTimeChoiceModel();
        timeRange = DateAndTimeUtils.getTimeRange();
        View outerView = LayoutInflater.from(context).inflate(R.layout.dialog_select_list,
                null);
        binding = DataBindingUtil.bind(outerView);
    }

    @Override
    public void setView() {
        setisShowDivision(true);
        binding.setModel(model);
        binding.wv1.setItems(dataList,initIndex);


        baseDialogModel.setRightListener(new DefaultListener() {
            @Override
            public void onClick(Dialog dialog) {
                if(listChoiceListener !=null)
                {
                    String mSelectItem = binding.wv1.getSelectedItem();
                    listChoiceListener.dataChoice(mSelectItem);
                }
            }
        });
        //将布局设置给Dialog
        addView(binding.getRoot());
    }


    public List<String> getDataList() {
        return dataList;
    }

    public ListChoiceDialog setDataList(List<String> dataList) {
        this.dataList = dataList;
        return this;
    }

    public int getInitIndex() {
        return initIndex;
    }

    public ListChoiceDialog setInitIndex(int initIndex) {
        this.initIndex = initIndex;
        return this;
    }

    public ListChoiceListener getListChoiceListener() {
        return listChoiceListener;
    }

    public ListChoiceDialog setListChoiceListener(ListChoiceListener dataChoiceListener) {
        this.listChoiceListener = dataChoiceListener;
        return this;
    }

    public ListChoiceDialog setLineColor(@ColorRes int Res) {
        model.setLineColor(Res);
        return this;
    }

    public ListChoiceDialog setInterval(int interval) {
        model.setInterval(interval);
        return this;
    }




    public ListChoiceDialog setItemsVisible(int itemsVisible) {
        model.setItemsVisible(itemsVisible);
        return this;
    }



    public ListChoiceDialog setTextSizeCenter(@DimenRes int textSizeCenter) {
        model.setTextSizeCenter(textSizeCenter);
        return this;
    }



    public ListChoiceDialog setTextSizeOuter(@DimenRes int textSizeOuter) {
        model.setTextSizeOuter(textSizeOuter);
        return this;
    }



    public ListChoiceDialog setTextColorOuter(@ColorRes int textColorOuter) {
        model.setTextColorOuter(textColorOuter);
        return this;
    }



    public ListChoiceDialog setTextColorCenter(@ColorRes int textColorCenter) {
        model.setTextColorCenter(textColorCenter);
        return this;
    }



    public ListChoiceDialog setLoop(boolean loop) {
        model.setLoop(loop);
        return this;
    }



    public ListChoiceDialog setLineHeight(@DimenRes int lineHeight) {
        model.setLineHeight(lineHeight);
        return this;
    }

}
