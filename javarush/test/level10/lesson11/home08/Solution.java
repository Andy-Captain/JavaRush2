package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести на их экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {     ArrayList<String>[] list = new ArrayList[2];
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("drg");
        list1.add("4t4t6");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("ert");
         list[0] = list1;
        list[1] = list2;

        //Напишите тут ваш код

        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}