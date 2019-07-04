package com.yy.somepop.base;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ly on 2018/1/10.
 */

public abstract class BaseBindListAdapter<B extends ViewDataBinding,T> extends BaseAdapter {
    private List<T> list;
    protected Context context;
    private int LayoutRes;
    public B b;
    protected LayoutInflater mInflater;
    public BaseBindListAdapter(Context context,int LayoutRes) {
        super();
        this.context = context;
        mInflater = LayoutInflater.from(context);
        this.LayoutRes = LayoutRes;
    }

    @Override
    public int getCount() {
        if (list != null)
            return list.size();
        else
            return 0;
    }

    @Override
    public T getItem(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder<B>();
            //获取item布局的binding
            b = DataBindingUtil.inflate(mInflater,
                    LayoutRes, parent, false);
            //获取布局
            convertView = b.getRoot();
            //缓存binding到holder
            holder.setB(b);
            //设置Tag
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            b = (B)holder.getB();
        }
        setData(position,b,list.get(position));
        return convertView;
    }



    abstract public void setData(int position,B b,T t);

    public void removeList() {
        this.list = null;
        notifyDataSetInvalidated();
    }

    public void addItem(T t)
    {
        if (list == null) {
            list = new ArrayList<>();
        }
        if(t!=null)
        {
            list.add(t);
        }
        notifyDataSetChanged();
    }
    public void addAll(List<T> datas)
    {
        if (list == null) {
            list = new ArrayList<>();
        }
        if(datas!=null)
        {
            list.addAll(datas);
        }
        notifyDataSetChanged();

    }

    //viewholder类里只有一个binding对象和它的get,set方法
    private class ViewHolder<B extends ViewDataBinding> {

        private B b;

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }




    }


}
