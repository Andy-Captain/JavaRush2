package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        try
        {
            int first = string.indexOf("\t");
            int second = 0;
            int count = 2;
         char[] arr = string.toCharArray();

            for (int i = 0; i < arr.length; i++)
            {
                if (arr[i] == '\t')
                {
                    count--;
                    if (count == 0)
                    {
                      second = i;
                    }

                }

            }
            string = string.substring(first+1,second);

        } catch (Exception e)
        {
           throw new TooShortStringException();
        }




        return string.trim();
    }

    public static class TooShortStringException extends Exception {
    }


}
