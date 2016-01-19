package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Dmitriy on 24.12.2015.
 */
public class Order {
    private List<Dish> dishes;
    private Tablet tablet;

    public Order(Tablet tablet) throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        this.tablet = tablet;
    }

    @Override
    public String toString() {
        if ( dishes.isEmpty()|| dishes == null ) {
            return "";
        } else {
            return "Your order: " + dishes.toString() + " of " + tablet;
        }
    }

    public boolean isEmpty() {
           return dishes == null || dishes.isEmpty();
       }
}