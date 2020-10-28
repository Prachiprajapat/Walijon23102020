package com.iwtechnocrat.waljon.Model;

public class WishListModel {

    String name,price,off;
    int image;

    public WishListModel(String name, String price, String off, int image) {
        this.name = name;
        this.price = price;
        this.off = off;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOff() {
        return off;
    }

    public void setOff(String off) {
        this.off = off;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
