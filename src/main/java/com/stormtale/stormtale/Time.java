package com.stormtale.stormtale;

import java.io.Serializable;

public class Time implements Serializable {
    Integer currentTime;
    Integer Day;

    //month?

    public String getCurrentTime() {
        String hour = String.valueOf((currentTime / 60));
        String minute = new String();
        if ((currentTime % 60) < 10) {
            minute = "0" + String.valueOf((currentTime % 60));
        } else {
            minute = String.valueOf((currentTime % 60));
        }
        return hour + ":" + minute;
    }

    public void setCurrentTime(Integer time) {
        if (time > 1440) {
            currentTime = time % 1440;
            Day = Day + 1;
        } else {
            currentTime = time;
        }
    }

    public Integer getTime(){
        return currentTime;
    }

    public Time () {
        currentTime = 0;
        Day = 0;
    }

    public void addTime(Integer time) {
        currentTime = currentTime + time;
        if (currentTime > 1440) {
            currentTime = time % 1440;
            Day = Day + 1;
        }
    }

    public Integer getDay() {
        return Day;
    }

    public void setDay(Integer day) {
        Day = day;
    }

    public void addDay(Integer days) {
        Day = Day + days;
    }

}
