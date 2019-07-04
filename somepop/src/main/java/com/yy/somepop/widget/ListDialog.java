package com.yy.somepop.widget;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;

import com.yy.somepop.R;
import com.yy.somepop.base.BaseBindListAdapter;
import com.yy.somepop.base.BaseDialog;
import com.yy.somepop.databinding.DialogListBinding;
import com.yy.somepop.databinding.ItemListBinding;
import com.yy.somepop.framework.ListItemListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ly on 2018/4/13.
 */

public class ListDialog extends BaseDialog<ListDialog>{


    private LitsItemAdapter litsItemAdapter;
    private List<String> list;
    private DialogListBinding binding;

    private ListItemListener listItemListener;

    public ListDialog(@NonNull Context context) {
        super(context);
    }

    public ListDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected ListDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void init() {
        litsItemAdapter = new LitsItemAdapter(context, R.layout.item_list);
        list = new ArrayList<>();
        View outerView = LayoutInflater.from(context).inflate(R.layout.dialog_list,
                null);
        binding = DataBindingUtil.bind(outerView);
        isShowBtn(false);
    }


    public ListDialog addItem(String s)
    {
        list.add(s);
        return this;
    }
    public ListDialog addAllItem(List<String> list)
    {
        list.addAll(list);
        return this;
    }

    public ListDialog setListItemListener(ListItemListener listItemListener) {
        this.listItemListener = listItemListener;
        return this;
    }

    @Override
    public void setView() {
        litsItemAdapter.addAll(list);
        binding.list.setAdapter(litsItemAdapter);
        binding.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(listItemListener!=null)
                {
                    ListDialog.this.dismiss();
                    listItemListener.onItemClick(parent,view,position,id);
                }
            }
        });
        //将布局设置给Dialog
        addView(binding.getRoot());
    }



    public class LitsItemAdapter extends BaseBindListAdapter<ItemListBinding,String>
    {
        private int textColor =-1;
        private int textSize = -1;
        public LitsItemAdapter(Context context, int LayoutRes) {
            super(context, LayoutRes);
        }

        @Override
        public void setData(int position, ItemListBinding itemListBinding, String s) {
                itemListBinding.setName(s);
                if(textColor!=-1)
                {
                    itemListBinding.tvName.setTextColor(textColor);
                }
                if(textSize!=-1)
                {
                    itemListBinding.tvName.setTextSize(TypedValue.COMPLEX_UNIT_SP,
                            itemListBinding.tvName.getContext().getResources().getDimensionPixelSize(textSize));
                }
        }

        public int getTextColor() {
            return textColor;
        }

        public void setTextColor(int textColor) {
            this.textColor = textColor;
        }

        public int getTextSize() {
            return textSize;
        }

        public void setTextSize(int textSize) {
            this.textSize = textSize;
        }
    }


}
