package com.example.cityparcel_listpassed_method;

public class checkout {
    String Name;
    String Address;
    String Email;
    String landmark;
    String State;
    String City;

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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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

    public checkout(String name, String address, String email, String landmark, String state, String city) {
        Name = name;
        Address = address;
        Email = email;
        this.landmark = landmark;
        State = state;
        City = city;
    }
}
