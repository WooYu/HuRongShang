package com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.bean;

import java.util.List;

/**
 * 购物车商品
 */

public class GoodsCartListBean {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsCartListBean)) return false;

        GoodsCartListBean that = (GoodsCartListBean) o;

        return getShop_id() == that.getShop_id();

    }

    @Override
    public int hashCode() {
        return getShop_id();
    }

    private int shop_id;
    private int shop_selected;//  0为未选中
    private String shop_name;
    private List<GoodsListBean> list;

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public int getShop_selected() {
        return shop_selected;
    }

    public void setShop_selected(int shop_selected) {
        this.shop_selected = shop_selected;
    }

    public List<GoodsListBean> getList() {
        return list;
    }

    public void setList(List<GoodsListBean> list) {
        this.list = list;
    }

    public static class GoodsListBean {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof GoodsListBean)) return false;

            GoodsListBean that = (GoodsListBean) o;

            return getGoods_id().equals(that.getGoods_id());

        }

        @Override
        public int hashCode() {
            return getGoods_id().hashCode();
        }

        private int shop_id;
        private String goods_id;
        private String goods_image;
        private String goods_name;
        private int goods_number;
        private double goods_price;
        private int user_id;
        private int goods_selected;// 非编辑状态   0为选中
        private int goods_deletSelet;//编辑状态  0为非选中

        public int getGoods_deletSelet() {
            return goods_deletSelet;
        }

        public void setGoods_deletSelet(int goods_deletSelet) {
            this.goods_deletSelet = goods_deletSelet;
        }


        public int getGoods_selected() {
            return goods_selected;
        }

        public void setGoods_selected(int goods_selected) {
            this.goods_selected = goods_selected;
        }


        public int getShop_id() {
            return shop_id;
        }

        public void setShop_id(int shop_id) {
            this.shop_id = shop_id;
        }

        public String getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(String goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_image() {
            return goods_image;
        }

        public void setGoods_image(String goods_image) {
            this.goods_image = goods_image;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public int getGoods_number() {
            return goods_number;
        }

        public void setGoods_number(int goods_number) {
            this.goods_number = goods_number;
        }

        public double getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(double goods_price) {
            this.goods_price = goods_price;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        @Override
        public String toString() {
            return "GoodsListBean{" +
                    "shop_id=" + shop_id +
                    ", goods_id='" + goods_id + '\'' +
                    ", goods_image='" + goods_image + '\'' +
                    ", goods_name='" + goods_name + '\'' +
                    ", goods_number=" + goods_number +
                    ", goods_price=" + goods_price +
                    ", user_id=" + user_id +
                    ", goods_selected=" + goods_selected +
                    ", goods_deletSelet=" + goods_deletSelet +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "GoodsCartListBean{" +
                "shop_id=" + shop_id +
                ", shop_selected=" + shop_selected +
                ", shop_name='" + shop_name + '\'' +
                ", list=" + list +
                '}';
    }
}
