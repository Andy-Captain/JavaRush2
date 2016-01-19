package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstFileName = reader.readLine();
        String secondFileName =reader.readLine();

        FileInputStream fis = new FileInputStream(firstFileName);
        FileOutputStream fos = new FileOutputStream(secondFileName);

        ArrayList<Integer> dataList = new ArrayList<>();

        while (fis.available() > 0)
        {
           int data = fis.read();
            dataList.add(data);
        }

        for (int i = dataList.size()-1; i >=  0; i--)
        {
            int data = dataList.get(i);
            fos.write(data);
        }
        reader.close();
        fis.close();
        fos.close();

    }
}
