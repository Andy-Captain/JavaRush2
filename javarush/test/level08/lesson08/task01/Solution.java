package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> set= new HashSet<String>();
        set.add("Лена");
        set.add("Любовь");
        set.add("Люкс");
        set.add("Леопард");
        set.add("Леон");
        set.add("Лайк");
        set.add("Л");
        set.add("Лн");
        set.add("Ла");
        set.add("Лб");
        set.add("Лв");
        set.add("Ле");
        set.add("Лен");
        set.add("Лк");
        set.add("Лс");
        set.add("Лг");
        set.add("Лщ");
        set.add("Лз");
        set.add("Лх");
        set.add("Лц");
        return set;
    }
}
