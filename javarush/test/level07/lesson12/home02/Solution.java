package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


            String n = reader.readLine();
            String m = reader.readLine();
            int N = Integer.parseInt(n);
            int M = Integer.parseInt(m);

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < N; i++ ){
            String s = reader.readLine();
            list.add(s);
        }

        for (int j = 0; j < M; j++){
            list.add(list.get(0));
            list.remove(0);
        }

        for (String x : list)
            System.out.println(x);
    }
}
