package com.example.notes_gb.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.notes_gb.Time.TimeAndDate;

public class Note implements Parcelable {

    private String name;
    private String content;
    private String dateTime;
    private static int number = 0;
    private int serialNumber;

    protected Note(Parcel in) {
        name = in.readString();
        content = in.readString();
        dateTime = in.readString();
        serialNumber = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getDateTime() {
        return dateTime;
    }

    public Note(String name, String content) {
        this.name = name;
        this.content = content;
        serialNumber=++number;
        dateTime = new TimeAndDate().getTimeAndDate();
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public static int getNumber() {
        return number;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void setNumber(int number) {
        Note.number = 0;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(content);
        dest.writeString(dateTime);
        dest.writeInt(serialNumber);
    }
}
