/** 
 * adapter基类
 * @author xianlin.liang
 * @time 2015年5月7日下午2:26:37 
 */
package com.yy.somepop.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseListAdapter<T> extends BaseAdapter {

	protected List<T> mList;
	protected Context mContext;
	protected ListView mListView;
	protected LayoutInflater mInflater;


	public BaseListAdapter(Context context) {
		this.mContext = context;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		if (mList != null)
			return mList.size();
		else
			return 0;
	}

	@Override
	public T getItem(int position) {
		return mList == null ? null : mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	abstract public View getView(int position, View convertView, ViewGroup parent);

	public void setList(List<T> list) {
		this.mList = list;
		notifyDataSetChanged();
	}

	public List<T> getList() {
		return mList;
	}

	public void setList(T[] array) {
		if (isNotEmpty(array)) {
			ArrayList<T> list = new ArrayList<T>(array.length);
			for (T t : array) {
				list.add(t);
			}
			setList(list);
		} else {
			mList = null;
			notifyDataSetChanged();
		}
	}

	public ListView getListView() {
		return mListView;
	}

	public void setListView(ListView listView) {
		mListView = listView;
	}

	public void removeList() {
		this.mList = null;
		notifyDataSetInvalidated();
	}

	public Context getContext() {
		return mContext;
	}

	public void addList(List<T> list) {
		if (mList == null) {
			mList = new ArrayList<T>();
		}
		this.mList.addAll(list);
		notifyDataSetChanged();
	}


	public static <T> boolean isNotEmpty(T[] array) {
		return (array != null && array.length != 0);
	}

}
