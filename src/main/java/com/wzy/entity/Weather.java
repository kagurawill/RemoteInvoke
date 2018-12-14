package com.wzy.entity;

public class Weather {

    //城市
    private String city;

    //温度
    private String temp;

    //湿度
    private String sd;

    //天气概述
    private String desc;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "天气信息{" +
                "城市='" + city + '\'' +
                ", 温度='" + temp + '\'' +
                ", 湿度='" + sd + '\'' +
                ", 天气描述='" + desc + '\'' +
                '}';
    }
}
