package com.ua.test.my.test;

import java.util.Arrays;

/**
 * Created by Dmitriy on 08.04.2015.
 */
public class Test_04_15 {

    public static void main(String[] args) {


        Holder h = new Holder(10,20);
        f(h);
        System.out.println(h.x + " " + h.y);
        final  String s = "123";

    }

    private static Holder f(Holder  x) {

        x.y = 100;
        x = new Holder(-1,-2);

        return x;
    }

}
class Holder{
        int x;
        int y;

        Holder(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }