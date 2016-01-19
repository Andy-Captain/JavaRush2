package com.javarush.test.level29.lesson15.big01.car;

/**
 * Created by Dmitriy on 17.01.2016.
 */
public class Cabriolet extends Car {
    public Cabriolet(int numberOfPassengers) {
        super(2, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {

        return MAX_CABRIOLET_SPEED;
    }
}
