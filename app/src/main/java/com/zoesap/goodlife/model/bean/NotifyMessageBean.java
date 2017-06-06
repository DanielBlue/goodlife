package com.zoesap.goodlife.model.bean;

/**
 * Created by 毛琦 on 2017/6/3.
 */

public class NotifyMessageBean {
    private String title;
    private String date;
    private String des;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public NotifyMessageBean(String title, String date, String des) {

        this.title = title;
        this.date = date;
        this.des = des;
    }

}
