package com.javarush.test.level40.lesson10.task01;

/* Работа с датами
Реализуй метод printDate(String date).
Он должен в качестве параметра принимать дату (в одном из 3х форматов)
и выводить ее в консоль в соответсвии с примером:

1) Для "21.4.2014 15:56:45" вывод должен быть:
День: 21
День недели: 2
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 3
Год: 2014
Эра: 1
AM или PM: 1
Часы: 3
Часы дня: 15
Минуты: 56
Секунды: 45

2) Для "21.4.2014":
День: 21
День недели: 2
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 3
Год: 2014
Эра: 1

3) Для "17:33:40":
AM или PM: 1
Часы: 5
Часы дня: 17
Минуты: 33
Секунды: 40
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");

    }

    public static void printDate(String date) {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = null;
        SimpleDateFormat dateFormat = null;
        if (checkAllDate(date)) {
            dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            try {
                currentDate = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            calendar.setTime(currentDate);
            System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День недели: " + calendar.get(Calendar.DAY_OF_WEEK));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + calendar.get(Calendar.MONTH));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
            System.out.println("Эра: " + calendar.get(Calendar.ERA));
            System.out.println("AM или PM: " + calendar.get(Calendar.AM_PM));
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));

        }
        if (checkStartDate(date)) {
            dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            try {
                currentDate = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            calendar.setTime(currentDate);
            System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День недели: " + calendar.get(Calendar.DAY_OF_WEEK));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + calendar.get(Calendar.MONTH));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
            System.out.println("Эра: " + calendar.get(Calendar.ERA));


        }
        if (checkEndDate(date)) {
            dateFormat = new SimpleDateFormat("HH:mm:ss");
            try {
                currentDate = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            calendar.setTime(currentDate);
            System.out.println("AM или PM: " + calendar.get(Calendar.AM_PM));
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));


        }

    }


    private static boolean checkEndDate(String s) {

        Pattern p = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    private static boolean checkStartDate(String s) {
        Pattern p = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((19|20)\\d\\d)");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    private static boolean checkAllDate(String s) {
        Pattern p = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((19|20)\\d\\d) ([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");
        Matcher m = p.matcher(s);
        return m.matches();

    }
}
