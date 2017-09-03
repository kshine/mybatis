package com.freedom.po;

import java.util.Date;

public class Item {
    private int item_id;
    private String item_name;
    private double item_price;
    private String item_detail;
    private String pic;
    private Date item_createtime;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

    public String getItem_detail() {
        return item_detail;
    }

    public void setItem_detail(String item_detail) {
        this.item_detail = item_detail;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getItem_createtime() {
        return item_createtime;
    }

    public void setItem_createtime(Date item_createtime) {
        this.item_createtime = item_createtime;
    }

    @Override
    public String toString() {
        return "item{" +
                "item_id=" + item_id +
                ", item_name='" + item_name + '\'' +
                ", item_price=" + item_price +
                ", item_detail='" + item_detail + '\'' +
                ", pic='" + pic + '\'' +
                ", item_createtime=" + item_createtime +
                '}';
    }
}
