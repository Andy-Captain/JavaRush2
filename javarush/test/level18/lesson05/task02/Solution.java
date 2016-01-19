package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        int summSimbol = 0;
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        while (fis.available() > 0)
        {
            int rezult = fis.read();

            integerArrayList.add(rezult);

        }
        reader.close();
        fis.close();
        for (Integer integer : integerArrayList) {
            if (integer.equals(44))
            {
                summSimbol++;
            }
        }
        System.out.println(summSimbol);
    }
}
