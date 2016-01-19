package com.javarush.test.level08.lesson08.task02;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(5);
        set.add(77);
        set.add(41);
        set.add(2);
        set.add(6);
        set.add(8);
        set.add(75);
        set.add(12);
        set.add(10);
        set.add(4);
        set.add(18);
        set.add(9);
        set.add(45);
        set.add(32);
        set.add(17);
        set.add(15);
        set.add(111);
        set.add(7);
        set.add(19);
         return set;

    }

    public static HashSet<Integer> removeAllNumbersMoreThen10(HashSet<Integer> set)
    {
            Iterator<Integer> iterator = set.iterator();
            while(iterator.hasNext())
            {   int n = iterator.next();
                 if (n > 10)
                     iterator.remove();


            }
        return set;
    }
}
