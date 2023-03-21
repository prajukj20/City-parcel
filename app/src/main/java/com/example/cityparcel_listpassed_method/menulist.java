package com.example.cityparcel_listpassed_method;

public class menulist {
    String hotelid;
    String Name;
    String Prize;
    String Contain;
    String category;
    String service_type;
    String Url;
    String count = "1";

    public menulist(String hotelid, String name, String prize, String contain, String category, String service_type, String url, String count) {
        this.hotelid = hotelid;
        Name = name;
        Prize = prize;
        Contain = contain;
        this.category = category;
        this.service_type = service_type;
        Url = url;
        this.count = count;
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

    public String getPrize() {
        return Prize;
    }

    public void setPrize(String prize) {
        Prize = prize;
    }

    public String getContain() {
        return Contain;
    }

    public void setContain(String contain) {
        Contain = contain;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}

