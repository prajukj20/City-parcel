package com.example.cityparcel_listpassed_method;

public class aboutdata {
    String Name;
    String Address;
    String contact;
    String email;

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public aboutdata(String name, String address, String contact, String email) {
        Name = name;
        Address = address;
        this.contact = contact;
        this.email = email;
    }
}
