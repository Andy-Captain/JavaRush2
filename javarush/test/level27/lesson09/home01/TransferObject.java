package com.javarush.test.level27.lesson09.home01;

import java.util.concurrent.ConcurrentLinkedQueue;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable
    ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue();

    public synchronized int get() {
        if (queue.size() > 0) {

            this.notify();
            value = queue.poll();

            System.out.println("Got: " + value);
        }


        return value;
    }

    public synchronized void put(int value) {

        try {
            queue.add(value);

                    System.out.println("Put: " + value);
             while (queue.size() >0)
             {
                 this.wait();
             }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
