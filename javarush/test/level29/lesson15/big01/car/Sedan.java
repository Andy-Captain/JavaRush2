package com.javarush.test.level29.lesson15.big01.car;

/**
 * Created by Dmitriy on 17.01.2016.
 */
public class Sedan extends Car {
    public Sedan(int numberOfPassengers) {
        super(1, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {

        return MAX_SEDAN_SPEED;

    }
}
