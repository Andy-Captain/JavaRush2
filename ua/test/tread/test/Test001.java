package com.ua.test.tread.test;

/**
 * Created by Dmitriy on 24.04.2015.
 */
public class Test001 {
      public static volatile int count;
    public static void main(String[] args) throws InterruptedException {

       Thread thread =  new Thread(new Runnable() {
             @Override
             public void run() {
                 while (!Thread.currentThread().isInterrupted())
                              {
                                 System.out.println("!");
                                  System.out.println(count++);
//                                  try {
//                                      Thread.sleep(100);
//                                  } catch (InterruptedException e) {
//                                      System.out.println("Buy!");
//                                      break;
//                                  }

                              }
             }
         });
        thread.start();



        Thread.sleep(1000);
        //System.out.println();
       thread.interrupt();

    }}
