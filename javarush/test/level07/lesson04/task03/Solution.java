package com.javarush.test.level07.lesson04.task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2 массива
1. Создать массив на 10 строк.
2. Создать массив на 10 чисел.
3. Ввести с клавиатуры 10 строк, заполнить ими массив строк.
4. В каждую ячейку массива чисел записать длину строки из массива строк,
индекс/номер ячейки которой совпадает с текущим индексом из массива чисел.
Вывести содержимое массива чисел на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String ar1[] = new String [10];
        int ar2[] = new int[10];
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < ar1.length; i++){
            String s = rd.readLine();
            ar1 [i] = s;
        }

        for (int j = 0; j < ar2.length; j++){

            ar2 [j] = ar1[j].length();

        }
        for (int i = 0; i < ar2.length; i++)
            System.out.println(ar2 [i]);

    }
}
