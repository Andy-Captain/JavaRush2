package com.javarush.test.level07.lesson06.task01;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        ArrayList<String> list = new ArrayList<String>();


            list.add("String1");
        list.add("String2");
        list.add("String3");
        list.add("String4");
        list.add("String5");


        System.out.println(list.size());
        for (int j = 0; j < list.size(); j++)
        {
            System.out.println(list.get(j));

        }

    }
}
