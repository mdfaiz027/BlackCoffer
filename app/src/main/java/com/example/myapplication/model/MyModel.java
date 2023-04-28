package com.example.myapplication.model;

public class MyModel {
    private String name, address, within, group, group_description;
    private int progress;
    private int image, phone_call, add_contact, location;

    public MyModel(String name, String address, String within, int progress, String group, String group_description, int image) {
        this.name = name;
        this.address = address;
        this.within = within;
        this.progress = progress;
        this.group = group;
        this.group_description = group_description;
        this.image = image;
    }

    public MyModel(String name, String address, String within, int progress, String group, String group_description, int image, int phone_call, int add_contact) {
        this.name = name;
        this.address = address;
        this.within = within;
        this.progress = progress;
        this.group = group;
        this.group_description = group_description;
        this.image = image;
        this.phone_call = phone_call;
        this.add_contact = add_contact;
    }

    public MyModel(String name, String address, String within, int progress, String group, String group_description, int image, int phone_call, int add_contact, int location) {
        this.name = name;
        this.address = address;
        this.within = within;
        this.progress = progress;
        this.group = group;
        this.group_description = group_description;
        this.image = image;
        this.phone_call = phone_call;
        this.add_contact = add_contact;
        this.location = location;
    }

    public int getPhone_call() {
        return phone_call;
    }

    public void setPhone_call(int phone_call) {
        this.phone_call = phone_call;
    }

    public int getAdd_contact() {
        return add_contact;
    }

    public void setAdd_contact(int add_contact) {
        this.add_contact = add_contact;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWithin() {return within; }

    public void setWithin(String within) {this.within = within; }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup_description() {
        return group_description;
    }

    public void setGroup_description(String group_description) {
        this.group_description = group_description;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
