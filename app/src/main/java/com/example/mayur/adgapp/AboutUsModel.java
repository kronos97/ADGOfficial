package com.example.mayur.adgapp;

/**
 * Created by mayur on 31/07/16.
 */
public class AboutUsModel {

    private String title;
    private String msg;
    private int img;

    public AboutUsModel(String title, String msg, int img) {
        this.title = title;
        this.msg = msg;
        this.img = img;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


}
