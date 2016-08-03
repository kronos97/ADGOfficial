package com.example.mayur.adgapp;

public class EventsModel {

    private String event_title;
    private String event_msg;

    EventsModel (){}

    public EventsModel(String event_title, String event_msg) {
        this.event_title = event_title;
        this.event_msg = event_msg;
    }


    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getEvent_msg() {
        return event_msg;
    }

    public void setEvent_msg(String event_msg) {
        this.event_msg = event_msg;
    }

}
