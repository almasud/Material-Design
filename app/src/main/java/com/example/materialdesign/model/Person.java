package com.example.materialdesign.model;

public class Person {
    private String name, phone;
    private int photoId;

    public Person(String name, String phone, int photoId) {
        this.name = name;
        this.phone = phone;
        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getPhotoId() {
        return photoId;
    }
}
