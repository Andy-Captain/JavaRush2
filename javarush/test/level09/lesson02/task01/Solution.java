package com.javarush.test.level09.lesson02.task01;

/* Каждый метод должен возвращать свой StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать свой StackTrace.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        method1();
    }

    public static StackTraceElement[] method1()
    {
        method2();
        StackTraceElement[] stackTraceElements1 = Thread.currentThread().getStackTrace();
                for (StackTraceElement element: stackTraceElements1)
                       {
                           System.out.println(element.getMethodName());
                       }
        return stackTraceElements1;
        //Напишите тут ваш код

    }

    public static StackTraceElement[] method2()
    {
        method3();
        StackTraceElement[] stackTraceElements2 = Thread.currentThread().getStackTrace();
                for (StackTraceElement element: stackTraceElements2)
                       {
                           System.out.println(element.getMethodName());
                       }
        return stackTraceElements2;
        //Напишите тут ваш код

    }

    public static StackTraceElement[] method3()
    {
        method4();
        StackTraceElement[] stackTraceElements3 = Thread.currentThread().getStackTrace();
                       for (StackTraceElement element: stackTraceElements3)
                              {
                                  System.out.println(element.getMethodName());
                              }
               return stackTraceElements3;
        //Напишите тут ваш код

    }

    public static StackTraceElement[] method4()
    {
        method5();
        StackTraceElement[] stackTraceElements4 = Thread.currentThread().getStackTrace();
                       for (StackTraceElement element: stackTraceElements4)
                              {
                                  System.out.println(element.getMethodName());
                              }
               return stackTraceElements4;
        //Напишите тут ваш код

    }

    public static  StackTraceElement[] method5()
    {
        StackTraceElement[] stackTraceElements5 = Thread.currentThread().getStackTrace();
        for (StackTraceElement element: stackTraceElements5)
               {
                   System.out.println(element.getMethodName());
               }


        return  stackTraceElements5;
       //Напишите тут ваш код

    }
}
