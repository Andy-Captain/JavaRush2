package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

public class NoAvailableVideoEventDataRow implements EventDataRow {


    private  Date currentDate;
    private int totalDuration;

   public NoAvailableVideoEventDataRow(int totalDuration){

        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }
}
