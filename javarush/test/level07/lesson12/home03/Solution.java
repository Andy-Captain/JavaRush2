package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int  maximum;
        int  minimum;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++){
            int n = Integer.parseInt(reader.readLine());
            list.add(n);
        }
          maximum = max(list);
          minimum = min(list);



          System.out.println(maximum + " " + minimum);


    }
    public static int max(ArrayList<Integer> list)
                 {  int max = list.get(0);
                for (int i = 1; i < list.size(); i++)
                    if (list.get(i) > max)
                     max = list.get(i);


                     return max;
                 }

    public static int min(ArrayList<Integer> list)
                     {  int min = list.get(0);
                    for (int i = 1; i < list.size(); i++){
                         if (list.get(i) < min)
                            min = list.get(i);

                    }
                         return min;
                     }

}
