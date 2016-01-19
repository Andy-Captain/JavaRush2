package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Пример вывода:
12345678
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream console = System.out;

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(out);

        System.setOut(stream);

        testString.printSomething();

        String data = out.toString();

        System.setOut(console);

        char[] chars = data.toCharArray();

        for (char aChar : chars) {

            if (Character.isDigit(aChar))
            {
                System.out.print(aChar);
            }

        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
