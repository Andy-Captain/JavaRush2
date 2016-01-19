package com.javarush.test.level07.lesson09.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> l = new ArrayList<String>();
        Collections.addAll(l,"мама","мыла","раму");
        l.add(1,"именно");
        l.add(3,"именно");
        l.add("именно");
        for (int i = 0; i < l.size(); i++)
            System.out.println(l.get(i));

     }
}
