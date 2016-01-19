package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
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
        Collections.sort(listByte);


        ArrayList<Integer> listByteDublicats = new ArrayList<>();

        for (Integer integer : listByte) {
           if (!listByteDublicats.contains(integer)) {
               listByteDublicats.add(integer);
           }
        }

        for (Integer dublicat : listByteDublicats) {
            System.out.print(dublicat + " ");
        }

    }
}
