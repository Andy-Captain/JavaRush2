package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка  с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++){
            Integer n = Integer.parseInt(rd.readLine());
            l.add(n);

        }
        ArrayList<Integer> l3 = new ArrayList<Integer>();
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        ArrayList<Integer> ln = new ArrayList<Integer>();
        for (int i = 0; i < l.size(); i++){
            if (l.get(i) % 3 == 0 && l.get(i) % 2 == 0 )
            {
                l2.add(l.get(i));
                l3.add(l.get(i));
            }
            else if (l.get(i) % 3 == 0)
             l3.add(l.get(i));
            else if (l.get(i) % 2 == 0)
             l2.add(l.get(i));
            else ln.add(l.get(i));

        }
        printList(l3);
        printList(l2);
        printList(ln);

    }

    public static void printList(List<Integer> list) {
        for (Integer x : list)
          System.out.println (x);
    }
}
