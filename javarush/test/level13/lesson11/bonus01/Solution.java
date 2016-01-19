package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(s)));
        ArrayList<Integer> list = new ArrayList<Integer>();


        while (reader.ready())
        {
            int n = Integer.parseInt(reader.readLine());

              if(n%2 == 0)
              {
                  list.add(n);
              }



        }




        reader.close();


        Collections.sort(list);




        for (Integer i: list)
            System.out.println(i);
        // напишите тут ваш код
    }
}
