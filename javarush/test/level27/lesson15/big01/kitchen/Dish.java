package com.javarush.test.level27.lesson15.big01.kitchen;

public enum  Dish {
    Fish, Steak, Soup, Juice, Water;

    public static String allDishesToString()
    {


        return Dish.Fish + ", "+Dish.Steak+", "+Dish.Soup+", "+Dish.Juice+", "+Dish.Water;
    }
}
