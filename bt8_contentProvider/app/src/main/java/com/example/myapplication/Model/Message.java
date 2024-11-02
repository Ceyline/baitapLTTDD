package com.example.myapplication.Model;

public class Message {
    private String phone;
    private String content;
    private int avatar;
    private String time;

    public Message(String phone, String content, int avatar, String time) {
        this.phone = phone;
        this.content = content;
        this.avatar = avatar;
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
