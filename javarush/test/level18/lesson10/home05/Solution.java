package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
               BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
               String firstFileName = reader.readLine();
              String secondFileName = reader.readLine();
               FileReader fileReader = new FileReader(firstFileName);
        FileWriter fileWriter = new FileWriter(secondFileName,true);
           int data;
            char d;
        ArrayList<Character> dataListCharacter = new ArrayList<>();
        while ((data = fileReader.read()) != -1)
        {
            d =(char) data;
           dataListCharacter.add(d);

        }
        StringBuilder sb = new StringBuilder();
        for (Character character : dataListCharacter) {
           sb.append(character);
        }
        String fileString = sb.toString();
        String [] dataString = fileString.split(" ");

        for (String s : dataString) {
            double ds = Double.parseDouble(s);

            long newDouble = Math.round(ds);
            String sd = String.valueOf(newDouble);
            fileWriter.write(sd + " ");


        }


        reader.close();
        fileReader.close();
        fileWriter.close();


    }
}
