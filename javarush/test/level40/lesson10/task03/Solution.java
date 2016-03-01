package com.javarush.test.level40.lesson10.task03;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/* В какой день недели день рождения?
Реализуй метод weekDayOfBirthday.
Метод должен возвращать день недели на итальянском языке, в который будет день рождения в определенном году.
Пример формата дат смотри в методе main.

Пример:
1) Для "30.05.1984" и "2015" метод должен вернуть: sabato
2) Для "1.12.2015" и "2016" метод должен вернуть: giovedì

Выполни задание, используя библиотеку Joda Time версии 2.9.1
*/

public class Solution {
    public static void main(String[] args) {

        System.out.println(weekDayOfBirthday("30.05.1984", "2015"));
        System.out.println(weekDayOfBirthday("1.12.2015", "2016"));
    }

    public static String weekDayOfBirthday(String birthday, String year) {


        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTimeFormatter dateFormatNew = DateTimeFormat.forPattern("yyyy");
        DateTime dt = dateFormat.parseDateTime(birthday);
        DateTime dt2 = dateFormatNew.parseDateTime(year);
        DateTime dateTime = new DateTime(dt2.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 0, 0);

        int dayOfWeek = dateTime.getDayOfWeek();
        String rez = "";
        switch (dayOfWeek) {
            case 1:
                rez = "lunedi";
                break;
            case 2:
                rez = "martedi";
                break;
            case 3:
                rez = "mercoledi";
                break;
            case 4:
                rez = "giovedi";
                break;
            case 5:
                rez = "venerdi";
                break;
            case 6:
                rez = "sabato";
                break;
            case 7:
                rez = "domenica";
                break;


        }


        return rez;
    }
}
