package com.lcworld.shopdemo.tsq.ui.gomallorshopping.gomall.bean;

import java.io.Serializable;

/**
 * 商铺 楼层-商店
 */
public class MarketFloorShopBean implements Serializable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    private String id; //商店id
    private String name; //商店名称
    private String imgUrl; //商店图片
}
