package com.iwtechnocrat.waljon.Model;

public class Shop_by_Brand_model {
    String name;
    int image;

    public Shop_by_Brand_model(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}