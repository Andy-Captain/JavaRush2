package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();


        char [] chars = s.toCharArray();

        ArrayList<Character> chars1 = new ArrayList<Character>();
        ArrayList<Character> chars2 = new ArrayList<Character>();
        char char3 = ' ';

        for (int i = 0; i < chars.length; i++){
            if (isVowel(chars[i]) && chars[i] != char3)
            {
                chars1.add(chars[i]);

            }
            else if (!isVowel(chars[i]) && chars[i] != char3)
                chars2.add(chars[i]);
        }

        for (Character character: chars1)
        {
            System.out.print(character + " ");
        }
        System.out.println();
       for (Character character: chars2)
                {
                    System.out.print(character + " ");
                }

        //Написать тут ваш код
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
