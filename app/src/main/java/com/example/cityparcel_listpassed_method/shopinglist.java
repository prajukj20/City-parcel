package com.example.cityparcel_listpassed_method;

public class shopinglist {
    String hotelid;
    String image;
    String Name;
    String Prize;

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrize() {
        return Prize;
    }

    public void setPrize(String prize) {
        Prize = prize;
    }

    public shopinglist(String hotelid, String image, String name, String prize) {
        this.hotelid = hotelid;
        this.image = image;
        Name = name;
        Prize = prize;
    }

  }
