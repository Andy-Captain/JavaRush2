package com.javarush.test.level27.lesson15.big01.kitchen;

public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);
    private int duration;

    Dish(int i) {
        this.duration = i;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        if (values().length == 0) {
            return "";
        }

        return Dish.Fish + ", " + Dish.Steak + ", " + Dish.Soup + ", " + Dish.Juice + ", " + Dish.Water;
    }
}
