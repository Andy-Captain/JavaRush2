package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                                FileInputStream fis = new FileInputStream(reader.readLine());


                                ArrayList<Integer> listByte = new ArrayList<>();
                                while (fis.available() > 0)
                                {
                                    int  value = fis.read();

                                     listByte.add(value);

                                }
                                reader.close();
                                fis.close();

                ArrayList<Integer> listByteDublicats = new ArrayList<>();

                 int [] arr = new int[listByte.size()];
                for (int i = 0; i < listByte.size(); i++ ) {

                     int num = Collections.frequency(listByte, listByte.get(i));
                      arr[i] = num;
                }
                  int min = Integer.MAX_VALUE;
             for (int i = 0; i < arr.length; i++)
             {
                 if (arr[i] < min)
                     min = arr[i];
             }

        for (int i = 0; i < listByte.size(); i++) {
                    if (!listByteDublicats.contains(listByte.get(i))&&arr[i]==min) listByteDublicats.add(listByte.get(i));

                }
        

        for (int i = 0; i < listByteDublicats.size(); i++)
                {
                    System.out.print(listByteDublicats.get(i)+" ");
                }
    }
}
