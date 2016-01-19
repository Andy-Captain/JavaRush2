package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();


        FileInputStream fis1 = new FileInputStream(firstFileName);

        ArrayList<Integer> dataFistFile = new ArrayList<>();

        while (fis1.available() > 0)
                {
                    int f = fis1.read();
                    dataFistFile.add(f);
                }

        fis1.close();
        FileInputStream fis2 = new FileInputStream(secondFileName);
        FileOutputStream fos = new FileOutputStream(firstFileName);
        FileOutputStream fos2 = new FileOutputStream(firstFileName,true);
        while (fis2.available() > 0)
                {
                    int n = fis2.read();
                    fos.write(n);
                }
        for (Integer integer : dataFistFile) {
                      fos2.write(integer);

                }

        fis2.close();
        fos.close();
        fos2.close();
    }
}
