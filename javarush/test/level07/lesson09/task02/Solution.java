package com.javarush.test.level07.lesson09.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 5 слов в обратном порядке
Введи с клавиатуры 5 слов в список строк. Выведи их в обратном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> l = new ArrayList<String>();
        for (int i = 0; i < 5; i++){
           String s = rd.readLine();
            l.add(s);

        }
        for (int i = l.size() - 1; i >= 0; i--){
            System.out.println(l.get(i));
        }

    }
}
