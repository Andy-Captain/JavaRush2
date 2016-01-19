package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
       int a[] = new int[10]; //Напишите тут ваш код
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < a.length; i++)
        {
            a [i] = Integer.parseInt(rd.readLine());
        }
        int i, tmp;
         for ( i = 0; i < a.length/2; i++) {
                    tmp = a [i];
                  a[i] = a[a.length-1-i];
                  a [a.length-1-i] = tmp;  }




        for (int g = 0; g < a.length; g++)
            System.out.println(a[g]);

    }
}
