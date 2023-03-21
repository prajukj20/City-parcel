package com.example.cityparcel_listpassed_method.model;

public class Photosclass {
    String hotelid;
    String ImageURl;

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getImageURl() {
        return ImageURl;
    }

    public void setImageURl(String imageURl) {
        ImageURl = imageURl;
    }

    public Photosclass(String hotelid, String imageURl) {
        this.hotelid = hotelid;
        ImageURl = imageURl;
    }


}