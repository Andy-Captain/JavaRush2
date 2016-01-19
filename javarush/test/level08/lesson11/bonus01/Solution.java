package com.javarush.test.level08.lesson11.bonus01;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String s = reader.readLine();
       /* int n = 0;
        if(s.equals("January"))
            n = 1;
        else if (s.equals("February"))
            n = 2;
        else if (s.equals("March"))
                   n = 3;
        else if (s.equals("April"))
                   n = 4;
        else if (s.equals("May"))
                   n = 5;
        else if (s.equals("June"))
                           n = 6;
        else if (s.equals("July"))
                           n = 7;
        else if (s.equals("August"))
                           n = 8;
        else if (s.equals("September"))
                           n = 9;
        else if (s.equals("October"))
                           n = 10;
        else if (s.equals("November"))
                           n = 11;
        else if (s.equals("December"))
                           n = 12;
        System.out.printf("%s is %d month", s, n);  */
        //add your code here - напиши код тут

        SimpleDateFormat df = new SimpleDateFormat("MMM", Locale.US);
                Calendar cal = Calendar.getInstance();
                try
                {
                    cal.setTime(df.parse(s));
                    System.out.println(s + " is " + (cal.get(Calendar.MONTH)+1) + " month");
                }
                catch (java.text.ParseException e)
                {

                }



    }

}
