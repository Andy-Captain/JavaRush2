package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n1=Integer.parseInt(r.readLine());
        int n2=Integer.parseInt(r.readLine());
        int n3=Integer.parseInt(r.readLine());
        Reverse(n1, n2, n3);
    }

    public static void Reverse(int a, int b, int c)
    {
        int tmp;
        if (a < b)
        {
            tmp = a;
            a = b;
            b = tmp;
        }

        if (a < c)
        {
            tmp = a;
            a = c;
            c = tmp;
        }

        if (b < c)
        {
            tmp = b;
            b = c;
            c = tmp;
        }

        System.out.println(b);
    }
}
