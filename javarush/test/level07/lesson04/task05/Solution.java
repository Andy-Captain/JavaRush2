package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        int a[] = new int[20];
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < a.length; i++){
            a [i] = Integer.parseInt(r.readLine());

        }


        int a1[] = Arrays.copyOf(a, 10);
        int[] a2 = Arrays.copyOfRange(a, a.length/2, a.length);
        for (int k = 0; k < a2.length; k++)
            System.out.println(a2[k]);

    }
}
