package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
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

        while ((s=bufferedReader.readLine()) != null)
        {
           String  s1 = s.replaceAll("\\.","!");
            bufferedWriter.write(s1 + "\r\n");


        }

        reader.close();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
