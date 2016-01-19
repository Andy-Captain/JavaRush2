package com.ua.test.my.test;

/**
 * Created by Dmitriy on 04.06.2015.
 */
public class ThreadName {
    public static void main(String[] args) {

        //String name = Thread.currentThread().getName();
        String name= "123454567";
        System.out.println(name);
        int num = name.length();
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < num; i++)
                        {
                            sb.append("*");
                        }
                        String newName = sb.toString();
                        Thread.currentThread().setName(newName);
        System.out.println(Thread.currentThread().getName());



    }
}
