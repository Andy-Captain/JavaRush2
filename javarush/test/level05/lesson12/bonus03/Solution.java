package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         int maximum = 0;
        int tmp;



        int n = Integer.parseInt(reader.readLine());
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            a[i] = Integer.parseInt(reader.readLine());

         }

          for(int j = 0; j < a.length-1; j++){
              for (int k = 1; k < a.length; k++){
                  if (a[j] < a[k]){
                      tmp = a[j] ;
                      a[j] = a[k];
                      a[k] = tmp;
                  }
              }
          }
          maximum= a[0];
        System.out.println(maximum);


} }
