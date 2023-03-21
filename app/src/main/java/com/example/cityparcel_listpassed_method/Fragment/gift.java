package com.example.cityparcel_listpassed_method.Fragment;

public class gift {
    String image;
    String Name;
    String Description;
    String faverites;
    String prize;

    public gift(String image, String name, String description, String faverites, String prize) {
        this.image = image;
        Name = name;
        Description = description;
        this.faverites = faverites;
        this.prize = prize;
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

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }
}
