package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private List<Dish> dishes;
    private Tablet tablet;

    public Order(Tablet tablet) throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        this.tablet = tablet;
    }

    @Override
    public String toString() {
        if ( dishes.isEmpty()) {
            return "";
        } else {
            return "Your order: " + dishes.toString() + " of " + tablet.toString();
        }
    }

    public boolean isEmpty() {
           return  dishes.isEmpty();
       }

    public int getTotalCookingTime(){
        int duration = 0;
        for (Dish dish : dishes) {
            duration +=dish.getDuration();

        }
       return duration;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }
}