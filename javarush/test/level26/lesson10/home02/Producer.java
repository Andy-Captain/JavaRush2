package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by Dmitriy on 23.06.2015.
 */
public class Producer implements Runnable{
   protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {

        try {

        int i = 1;
               while (true) {
               System.out.printf("Some text for %d", i++);
               System.out.println();

                Thread.sleep(500);

            }
        }catch (InterruptedException e)
        {
            System.out.printf("[%s] thread was terminated", Thread.currentThread().getName());
        }
    }
}
