package com.lcworld.shopdemo.base;


import android.os.Bundle;


/**
 * 创建：dongxiaoshuai
 * activity 基类
 */
public abstract class BaseActivity extends BaseActivity_base implements
        BaseFrameLayout.OnAnewLoadListener, BaseFrameLayout.OnEmptyLoadListener {
    public BaseFrameLayout baseFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseFrameLayout = new BaseFrameLayout(this) {
            @Override
            protected int setContentView() {
                return BaseActivity.this.setContentView();
            }

            @Override
            protected boolean setActionBarView() {
                return BaseActivity.this.setActionBarView();
            }

            @Override
            protected boolean setTitleBarView() {
                return setWindowDye();
            }
        };
        setContentView(baseFrameLayout);
        initView();
        initData();
        setListener();
    }

    //设置view
    protected abstract int setContentView();

    //初始化view
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();

    //设置监听
    protected abstract void setListener();

    //是否使用沉浸式
    protected abstract boolean setWindowDye();

    //是否有标题栏(在布局文件中标题栏id必须为：actionbar)
    protected abstract boolean setActionBarView();


    //实现 重新加载时的接口 子类可重写
    @Override
    public void onEmptyLoadListener() {

    }

    //实现 数据为空时重新加载时的接口 子类可重写
    @Override
    public void onAnewLoadListener() {

    }

    //环信清除通知栏
    @Override
    protected void onResume() {
        super.onResume();
        // cancel the notification
    }

    //环信清除通知栏

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }


}
