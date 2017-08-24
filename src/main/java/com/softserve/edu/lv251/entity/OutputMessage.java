package com.softserve.edu.lv251.entity;

import java.util.Date;

/**
 * Created by Yana Martynyak on 23.08.2017.
 */
public class OutputMessage {
    private String from;
    private String text;
    private String date;

    public OutputMessage(String from, String text, String date) {
        this.from = from;
        this.text = text;
        this.date = date;
    }

    public OutputMessage() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
