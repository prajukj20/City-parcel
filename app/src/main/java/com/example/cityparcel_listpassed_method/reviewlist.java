package com.example.cityparcel_listpassed_method;

public class reviewlist {
    String hotelid;
    String Name;
    String Image;
    String Comment;
    String date;

    public reviewlist(String hotelid, String name, String image, String comment, String date, String reviewAvrage) {
        this.hotelid = hotelid;
        Name = name;
        Image = image;
        Comment = comment;
        this.date = date;
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

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
