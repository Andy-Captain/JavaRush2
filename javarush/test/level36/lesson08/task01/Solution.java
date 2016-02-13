package com.javarush.test.level36.lesson08.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];

        TreeSet<Character> rezult = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {


            char[] chars = line.toLowerCase().toCharArray();
            for (char aChar : chars) {
                if (Character.isLetter(aChar)) {
                    rezult.add(aChar);
                }
            }
        }
        reader.close();
        StringBuilder sb = new StringBuilder();

        if (rezult.size() < 5) {
            for (Character character : rezult) {
                sb.append(character);
            }
        } else {
            int i = 0;
            for (Character character : rezult) {

                if (i < 5) {
                    sb.append(character);
                }
                i++;
            }

        }
        System.out.println(sb.toString());


    }
}
