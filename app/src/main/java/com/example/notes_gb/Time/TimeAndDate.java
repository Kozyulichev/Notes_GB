package com.example.notes_gb.Time;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeAndDate {

    private String TIMEZONE;
    private String dateTime;

    @SuppressLint("SimpleDateFormat")
    public TimeAndDate() {
        TIMEZONE = "Asia/Moscow";
        Date date = new Date();
        TimeZone timeZone;
        timeZone = TimeZone.getTimeZone(TIMEZONE);
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setTimeZone(timeZone);
        dateTime = dateFormat.format(date);
    }

    public String getTimeAndDate() {
        return dateTime;
    }
}

