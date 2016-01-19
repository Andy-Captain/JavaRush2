package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dmitriy on 17.01.2015.
 */
public class ThreadFive extends Thread {

    @Override
    public void run() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int summ = 0;
        try {

           while (!isInterrupted())
           {
               s = reader.readLine();
               if (s.equals("N")) {this.interrupt();}
               else{
                   summ = summ + (Integer.parseInt(s));


               }


           }

           throw new InterruptedException();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
         catch (InterruptedException  e)
        {
            System.out.println(summ);
        }


    }
}
