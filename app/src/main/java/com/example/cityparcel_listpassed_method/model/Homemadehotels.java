package com.example.cityparcel_listpassed_method.model;

public class Homemadehotels {
    String id;
    String image;
    String Name;
    String Description;
    String faverites;
    String Prize;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Homemadehotels(String id) {
        this.id = id;
    }

    public Homemadehotels(String image, String name, String description, String faverites, String prize) {
        this.image = image;
        Name = name;
        Description = description;
        this.faverites = faverites;
        Prize = prize;
    }

    public String getPrize() {
        return Prize;
    }

    public void setPrize(String prize) {
        Prize = prize;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getFaverites() {
        return faverites;
    }

    public void setFaverites(String faverites) {
        this.faverites = faverites;
    }
}
