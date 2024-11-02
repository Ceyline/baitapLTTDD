package com.example.myapplication.Model;

public class Contact {
    private String name;
    private int avatar;

    private String phone;

    public Contact(String name, int avatar, String phone) {
        this.name = name;
        this.avatar = avatar;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAvatar() {
        return avatar;
    }
    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
