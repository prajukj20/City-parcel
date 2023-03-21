package com.example.cityparcel_listpassed_method;

public class paymentlist {
    String hotelid;
    String Name;
    String Address;
    String landmark;
    String State;
    String City;

    public paymentlist(String hotelid, String name, String address, String landmark, String state, String city) {
        this.hotelid = hotelid;
        Name = name;
        Address = address;
        this.landmark = landmark;
        State = state;
        City = city;
    }

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
