package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created by Dmitriy on 17.01.2015.
 */
public class ThreadTwo extends Thread {

    @Override
    public void run() {
       try{

          while (!isInterrupted())
          {}
           throw new InterruptedException();
       } catch (InterruptedException e)
       {
           System.out.println("InterruptedException");
       }
    }
}
