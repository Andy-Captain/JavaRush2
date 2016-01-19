package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(5.21, "abc");
        labels.put(6.21, "abd");
        labels.put(7.21, "abe");
        labels.put(8.21, "abr");
        labels.put(9.21, "abt");


    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
