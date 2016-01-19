package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        String s = "JANUARY 25 2020";
        isDateOdd(s);



    }


    public static boolean isDateOdd(String date)
    {       Date date1 = new Date(date);
            int y = date1.getYear();
            Date date2 = new Date(y,0,1);
            long l1 = date1.getTime();
            long l2 = date2.getTime();
            long l3 = l1-l2;
            long l4 = ((((l3/1000)/60)/60)/24)+1;

        if (l4%2==0)
        {

            return false;
        }
         else
        {

            return true;
        }
    }
}
