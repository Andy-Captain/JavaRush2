package com.javarush.test.level04.lesson16.home04;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception

    {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String n = rd.readLine();
        String y = rd.readLine();
        String m = rd.readLine();
        String d = rd.readLine();

        System.out.println("Меня зовут " + n );
        System.out.print("Я родился "+ d +"."+ m +"."+ y);

    }
}
