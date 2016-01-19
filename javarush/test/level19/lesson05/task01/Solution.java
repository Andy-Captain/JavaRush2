package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        FileReader fileReader = new FileReader(firstFileName);
        FileWriter fileWriter = new FileWriter(secondFileName);
        int count = 0;
        while (fileReader.ready())
        {
            count++;
            int data = fileReader.read();
            if (count%2 == 0)
            {
                fileWriter.write(data);
            }

        }
        reader.close();
        fileReader.close();
        fileWriter.close();





    }
}
