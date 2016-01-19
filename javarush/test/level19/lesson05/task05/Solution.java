package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки ввода-вывода.
Темповые файлы создавать нельзя,
 т.к. на сервере заблокирована возможность создания каких любо файлов.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first = reader.readLine();
        String second = reader.readLine();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(first));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(second));
        String s = "";


        while ((s = bufferedReader.readLine()) != null)
        {

           String s1 = s.replaceAll("\\p{Punct}", "");



             bufferedWriter.write(s1 + "\r\n");
        }
        reader.close();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
