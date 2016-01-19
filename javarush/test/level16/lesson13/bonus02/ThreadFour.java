package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created by Dmitriy on 17.01.2015.
 */
public class ThreadFour extends Thread implements Message {
    @Override
           public  void showWarning()
           {

               this.interrupt();
               try
               {
                   this.join();
               }
               catch(Exception e)
               {

               }

           }

           @Override
           public void run()
           {
               Thread current = Thread.currentThread();
               while(!current.interrupted())
               {

               }


           }
}
