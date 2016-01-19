package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная
с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

            try {

                int n = string.indexOf(" ");

                char[] arr = string.toCharArray();
                int count = 5;
                int last = 0;
                for (int i = 0; i < arr.length; i++)
                {
                    if (arr[i] == ' ')
                    {
                        count--;
                        if (count == 0)
                        {
                            last = i;
                        }

                    }

                }


                string = string.substring(n + 1, last);
                System.out.println(string);

            } catch (Exception e) {
                throw new TooShortStringException();
            }

        return string;
    }

    public static class TooShortStringException extends Exception{
    }


}
