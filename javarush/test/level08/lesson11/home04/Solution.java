package com.javarush.test.level08.lesson11.home04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Минимальное из N чисел
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();


        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        Iterator<Integer> iterator = array.iterator();
        int min = array.get(0);
        while (iterator.hasNext()){
            int n = iterator.next();
            if (n < min)
            min = n;



        }


        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
         List<Integer> list = new ArrayList<Integer>();

           int n = Integer.parseInt(rd.readLine());

          for (int i = 0; i < n; i++)
          {
              int h = Integer.parseInt(rd.readLine());
              list.add(h);
          }
        return list;
    }
}
