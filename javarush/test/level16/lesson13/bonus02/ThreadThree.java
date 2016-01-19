package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created by Dmitriy on 17.01.2015.
 */
public class ThreadThree extends Thread {

    @Override
    public void run() {


           try {
               while (true) {
                   System.out.println("Ура");
                   Thread.sleep(500);
               }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }
}
