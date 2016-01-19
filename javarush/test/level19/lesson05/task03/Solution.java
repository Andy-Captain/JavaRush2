package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
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
            String [] data = s.split(" ");
            for (String s1 : data) {

                char [] chars = s1.toCharArray();
                int count = chars.length;
                int count2 = 0;
                for (char aChar : chars) {


                    if (Character.isDigit(aChar)){
                               count2++;
                        if (count == count2){

                            bufferedWriter.write(s1 + " ");
                            count2 = 0;
                                            }


                                                 }

                     }


            }


        }
        reader.close();
        bufferedReader.close();
        bufferedWriter.close();





    }
}
