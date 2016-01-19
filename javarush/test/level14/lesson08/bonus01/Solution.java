package com.javarush.test.level14.lesson08.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            int [] ar= new int[3];
            ar[5] = 2;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
                {
                    BufferedReader reader = new BufferedReader(new FileReader("1.txt"));

                } catch (Exception e)
                {
                    exceptions.add(e);
                }
        try
                {
                    int k = Integer.parseInt("123abc");

                } catch (Exception e)
                {
                    exceptions.add(e);
                }
        try
                        {

                           throw   new IllegalStateException();

                        } catch (Exception e)
                        {
                            exceptions.add(e);
                        }
        try
                                {

                                   throw   new RuntimeException();
                                } catch (Exception e)
                                {
                                    exceptions.add(e);
                                }
        try
                                        {
                                            throw  new IllegalArgumentException();

                                        } catch (Exception e)
                                        {
                                            exceptions.add(e);
                                        }
        try
                                                {
                                                    throw  new IOException();

                                                } catch (Exception e)
                                                {
                                                    exceptions.add(e);
                                                }


        try
                                {

                                   throw   new ArrayStoreException();

                                } catch (Exception e)
                                {
                                    exceptions.add(e);
                                }
        try
                                {

                                   throw   new ClassCastException();

                                } catch (Exception e)
                                {
                                    exceptions.add(e);
                                }

        //Add your code here

    }


}
