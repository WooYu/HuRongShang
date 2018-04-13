package com.lcworld.shopdemo.base;

import java.io.Serializable;

/**
 * Created by xinshuai on 2017/6/30.
 */

public class SettingBean implements Serializable {
    public int image;
    public String name;

    public SettingBean(int image, String name) {
        this.image = image;
        this.name = name;
    }
}
