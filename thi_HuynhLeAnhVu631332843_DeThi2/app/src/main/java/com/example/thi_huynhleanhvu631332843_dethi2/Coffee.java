package com.example.thi_huynhleanhvu631332843_dethi2;

public class Coffee {
    private String name;
    private String address;
    private int imageResId;

    public Coffee(String name, String address, int imageResId) {
        this.name = name;
        this.address = address;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getImageResId() {
        return imageResId;
    }
}
