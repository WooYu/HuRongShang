package com.lcworld.shopdemo.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 创建：dongshuaijun
 * 日期：2016/7/18
 * 注释：
 */
public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {
    private List<T> list;
    public LayoutInflater inflater;
    public Context context;

    public BaseAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list != null && !list.isEmpty() ? list.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createView(position, convertView, parent);
    }


    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    public abstract View createView(int position, View convertView, ViewGroup parent);
}
