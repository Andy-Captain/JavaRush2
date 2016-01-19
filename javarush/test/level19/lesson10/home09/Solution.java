package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream temp = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(baos);

        System.setOut(stream);

        testString.printSomething();

        ArrayList<String> list = new ArrayList<>();

        String data = baos.toString();

        System.setOut(temp);

        String [] splitArray = data.split("\n");



        for (int i = 0; i < splitArray.length; i ++)
        {
            if (i%2 == 0 && i !=0)
            {
                System.out.println("JavaRush - курсы Java онлайн");
            }
            System.out.println(splitArray[i]);

        }





    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");

        }
    }
}
