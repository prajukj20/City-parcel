package com.example.cityparcel_listpassed_method;

public class aboutlist {
    String hotelid;
    String type;
    String cusine;

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCusine() {
        return cusine;
    }

    public void setCusine(String cusine) {
        this.cusine = cusine;
    }

    public aboutlist(String hotelid, String type, String cusine) {
        this.hotelid = hotelid;
        this.type = type;
        this.cusine = cusine;
    }
}


