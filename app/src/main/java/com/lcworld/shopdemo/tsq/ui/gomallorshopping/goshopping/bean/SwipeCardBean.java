package com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/12/18.
 */

public class SwipeCardBean {
    private int postition;
    private String url;
    private String name;

    public SwipeCardBean(int postition, String url, String name) {
        this.postition = postition;
        this.url = url;
        this.name = name;
    }

    public int getPostition() {
        return postition;
    }

    public SwipeCardBean setPostition(int postition) {
        this.postition = postition;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SwipeCardBean setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public SwipeCardBean setName(String name) {
        this.name = name;
        return this;
    }

    public static List<SwipeCardBean> initDatas() {
        List<SwipeCardBean> datas = new ArrayList<>();
        int i = 1;
        datas.add(new SwipeCardBean(i++, "", "张"));
        datas.add(new SwipeCardBean(i++, "", "旭童"));
        datas.add(new SwipeCardBean(i++, "", "多种type"));
        datas.add(new SwipeCardBean(i++, "", "多种type"));
        datas.add(new SwipeCardBean(i++, "", "多种type"));
        datas.add(new SwipeCardBean(i++, "", "多种type"));
        datas.add(new SwipeCardBean(i++, "", "多种type"));
        datas.add(new SwipeCardBean(i++, "", "多种type"));
        return datas;
    }
}
