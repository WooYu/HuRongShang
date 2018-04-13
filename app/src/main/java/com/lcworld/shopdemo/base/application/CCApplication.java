package com.lcworld.shopdemo.base.application;

import android.app.Application;
import android.content.Context;


/**
 * 创建：duke
 * 日期： 2017/4/13
 * 注释：application
 */
public class CCApplication extends Application {
    public static CCApplication app;


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}