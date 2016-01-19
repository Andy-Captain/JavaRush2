package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Dmitriy on 12.01.2015.
 */
public class Plane implements Flyable
{
    public static int passengers;
    @Override
    public void fly()
    {

    }

    public Plane(int passengers)
    {
        this.passengers = passengers;
    }
}
