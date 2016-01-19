package com.javarush.test.level08.lesson11.home03;

import java.util.*;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {
        Map<String,String> mp = new LinkedHashMap<String, String>() ;



           mp.put("Ivanov", "Ivan");
        mp.put("Ivanov2", "Ivan2");
        mp.put("Ivanov3", "Ivan3");
        mp.put("Ivanov4", "Ivan4");
        mp.put("Ivanov5", "Ivan5");
        mp.put("Ivanov6", "Ivan6");
        mp.put("Ivanov7", "Ivan7");
        mp.put("Ivanov8", "Ivan8");
        mp.put("Ivanov9", "Ivan9");
        mp.put("Ivanov", "Ivan");


            return mp;
        }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
