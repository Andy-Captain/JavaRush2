package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        String thirdFileName = reader.readLine();
        FileInputStream fis1 = new FileInputStream(secondFileName);
        FileInputStream fis2 = new FileInputStream(thirdFileName);
        FileOutputStream fos = new FileOutputStream(firstFileName, true);


        while (fis1.available() > 0)
        {
            int n = fis1.read();
            fos.write(n);
        }
        while (fis2.available() > 0)
        {
            int n = fis2.read();
            fos.write(n);
        }
         fis1.close();
        fis2.close();
        fos.close();

    }
}
