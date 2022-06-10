package com.example.mythirdapplication;

public class Brand {
    private int device_count;
    private  String name,slug;

    public Brand(int device_count, String name, String slug) {
        this.device_count = device_count;
        this.name = name;
        this.slug = slug;
    }

    public Brand() {

    }

    public int getDevice_count() {
        return device_count;
    }

    public void setDevice_count(int device_count) {
        this.device_count = device_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
