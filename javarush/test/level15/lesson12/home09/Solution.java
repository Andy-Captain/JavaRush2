package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String URI = reader.readLine();
                String params = URI.substring(URI.indexOf("?")+1);

                String[] parsed = params.split("&");

                ArrayList<String> paramsString = new ArrayList<String>();
                ArrayList<String> obj = new ArrayList<String>();
                for (String s : parsed)
                {
                    String[] keys = s.split("=");
                    paramsString.add(keys[0]);
                    if (keys[0].equals("obj"))
                    {
                        obj.add(keys[1]);
                    }
                }
                for (String s : paramsString)
                    System.out.print(s + " ");
                if (obj.size()!= 0)
                {
                    System.out.println();
                    for (String s : obj)
                    {
                        try
                        {
                            Double doubleValue = Double.parseDouble(s);
                            alert(doubleValue);
                        }
                        catch (Exception e)
                        {
                            alert(s);
                        }
                    }
                }
            }





    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
