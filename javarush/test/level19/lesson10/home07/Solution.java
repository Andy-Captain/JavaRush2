package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {


        String firstFileName = "";
        String secondFileName = "";

        if (args.length < 2)
        {return;}
        else {
            firstFileName = args[0];
            secondFileName = args[1];

        }

        BufferedReader reader = new BufferedReader(new FileReader(firstFileName));
          String data = "";
        StringBuilder sb = new StringBuilder();
        while (reader.ready())
        {
            data = reader.readLine();

            String [] splitArray = data.split(" ");

            for (String s : splitArray) {

                if (s.length() > 6)
                {
                    sb.append(s + ",");
                }

            }

        }
        reader.close();
        String rezult = sb.toString();
        rezult = rezult.substring(0,rezult.length()-1);
        BufferedWriter writer = new BufferedWriter(new FileWriter(secondFileName));
        writer.write(rezult);
        writer.close();




    }
}
