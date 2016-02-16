package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
   private final static Logger logger = Logger.getLogger(Tablet.class.getName());
    private final int number;

    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder() {
        Order order = null;
        try {

                order = new Order(this);
                if (!order.isEmpty()) {
                    AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime());
                    manager.processVideos();
                    ConsoleHelper.writeMessage(order.toString());
                    setChanged();
                    notifyObservers(order);
                }


        }
        catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }



    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }
}