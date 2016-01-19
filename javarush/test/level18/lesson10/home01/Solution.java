package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/


import java.io.FileReader;
import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);


        int data;
        int countLetter = 0;
        while ((data = reader.read()) != -1)
        {

            char addData = (char)data;
            String s = Character.toString(addData);
            if (test(s) )
                         {
                             countLetter++;
                         }
        }
        reader.close();



        System.out.println(countLetter);

    }
    public static boolean test(String testString){
            Pattern p = Pattern.compile("[a-zA-Z]");
            Matcher m = p.matcher(testString);
            return m.matches(); }
}
