package com.lcworld.shopdemo.base;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * 创建：dongxiaoshuai
 * fragment 基类
 */
public abstract class BaseFragment extends BaseFragment_base {


    public BaseFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(setContentView(), container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        setListener();
    }


    //设置view
    protected abstract int setContentView();

    //是否有标题栏(在布局文件中标题栏id必须为：actionbar!!!)
    protected abstract boolean setActionBarView();

    //初始化view
    protected abstract void initView(View view);

    //初始化数据
    protected abstract void initData();

    //设置监听
    protected abstract void setListener();


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}

