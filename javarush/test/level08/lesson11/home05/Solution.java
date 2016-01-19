package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:


Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

       char [] s1 = s.toCharArray();

        String s2 ="";
        for (int i = 0; i < s1.length; i++)
        {
            if(!Character.isSpaceChar(s1[0]))
                        {
                            s1[0] = Character.toUpperCase(s1[0]);
                        }

            if(Character.isSpaceChar(s1[i])&&!Character.isSpaceChar(s1[i+1]))
            {
                s1[i+1] = Character.toUpperCase(s1[i+1]);
            }
               s2+= s1[i];

        }

        System.out.println(s2);

        //Напишите тут ваш код
    }


}
