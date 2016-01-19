package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Шварцнеггер", new Date("JULY 5 1962"));
        map.put("Стал", new Date("AUGUST 1 1980"));
        map.put("Сталлон", new Date("SEPTEMBER 1 1984"));
        map.put("Сталло", new Date("DECEMBER 1 1980"));
        map.put("Янукович", new Date("JANUARY 1 1980"));
        map.put("Яценюк", new Date("MAY 1 1980"));
        map.put("Порошенко", new Date("JUNE 1 1965"));
        map.put("Тягнибок", new Date("JUNE 1 1962"));
        map.put("Тимошенко", new Date("JUNE 1 1960"));

        return map;
        //Напишите тут ваш код

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){

            Map.Entry<String,Date> pair = iterator.next();

            if ((pair.getValue().getMonth() == 5) || (pair.getValue().getMonth() == 6)|| (pair.getValue().getMonth() == 7))
                iterator.remove();



        }


        //Напишите тут ваш код

    }






}
