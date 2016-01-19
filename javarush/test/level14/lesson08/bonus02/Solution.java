package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(reader.readLine());
        int n2 = Integer.parseInt(reader.readLine());
        System.out.println(delitel(n1,n2));


    }
    public static int delitel(int v, int f)
    {
        int rez  = 1;

        for (int i = 1; i <(v < f ? v : f); i++)
        {
           if (v%i==0 && f%i ==0)
               rez = i;
        }

            return rez;

    }
}
