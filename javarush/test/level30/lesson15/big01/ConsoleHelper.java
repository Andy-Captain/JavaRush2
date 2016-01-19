package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dmitriy on 18.01.2016.
 */
public class ConsoleHelper {
   private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

   public static void writeMessage(String message)
    {
        System.out.println(message);
    }
    public static String readString()
    {    String message ="";

            try {
                message = reader.readLine();
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
                try {
                    message = reader.readLine();
                } catch (IOException e1) {
                    System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
                }
            }

        return message;
    }

    public static int readInt()
    {    int rez = 0;
         try {
            rez = Integer.parseInt(readString());
         }   catch (NumberFormatException e)
         {
             System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
             rez = Integer.parseInt(readString());
         }
     return  rez;
    }
}
