package io.github.duechayapolgmit.anpericaleventsmain.utils;

public class Time {
    private int time = 60; // always in seconds

    public Time(int time) {
        this.time = time;
    }

    public void decrement(){
        this.time--;
    }

    public void increment(){
        this.time++;
    }

    public String getTime(){
        int mins = (time % 3600) / 60;
        int secs = time % 60;

        return String.format("%02d:%02d", mins, secs);
    }

    public int getRawTime(){
        return time;
    }
}
