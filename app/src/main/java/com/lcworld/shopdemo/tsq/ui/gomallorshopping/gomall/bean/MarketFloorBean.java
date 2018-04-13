package com.lcworld.shopdemo.tsq.ui.gomallorshopping.gomall.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 商铺 楼层
 */
public class MarketFloorBean implements Serializable {
    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public String getFloordec() {
        return floordec;
    }

    public void setFloordec(String floordec) {
        this.floordec = floordec;
    }

    public ArrayList<MarketFloorShopBean> getFloorshop() {
        return floorshop;
    }

    public void setFloorshop(ArrayList<MarketFloorShopBean> floorshop) {
        this.floorshop = floorshop;
    }

    private int floorNum; //楼层
    private String floordec; //楼层描述

    public int getCanMore() {
        return canMore;
    }

    public void setCanMore(int canMore) {
        this.canMore = canMore;
    }

    private int canMore; //更多
    private ArrayList<MarketFloorShopBean> floorshop; //楼层商店

}
