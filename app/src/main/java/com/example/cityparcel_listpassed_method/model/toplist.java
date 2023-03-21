package com.example.cityparcel_listpassed_method.model;

public class toplist {
    String Name;
    int image;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public toplist(String name, int image) {
        Name = name;
        this.image = image;
    }
}
