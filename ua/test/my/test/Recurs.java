package com.ua.test.my.test;

/**
 * Created by Dmitriy on 09.04.2015.
 */
public class Recurs {
    public static void main(String[] args) {

        f(1);
    }

    private static void f(int i) {
        System.out.print(i);
        if (i < 7)
        {
            f(2*i);
            System.out.print(i);
        }
    }
}
