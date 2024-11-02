package com.example.myapplication.Model;

public class Call {
    private String phone;
    private String time;
    private String duration;

    public Call(String phone, String time, String duration) {
        this.phone = phone;
        this.time = time;
        this.duration = duration;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
