package com.javarush.test.level07.lesson06.task03;

/* 5 строчек в обратном порядке
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в него.
3. Расположи их в обратном порядке.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> k = new ArrayList<String>();
        for (int i = 0; i < 5; i++){
            String s = r.readLine();
            k.add(s);
            }
         ArrayList<String> l = new ArrayList<String>();

        for (int j = k.size() -1 ; j >= 0 ; j-- )
        {
            l.add(k.get(j));
            k.remove(j);
        }


            for (int i = 0; i < l.size(); i++)
            {

                System.out.println(l.get(i));
            }


    }
}
