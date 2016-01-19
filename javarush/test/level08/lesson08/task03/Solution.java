package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{


    public static HashMap<String, String> createMap()
    {
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("Ivanov", "Ivan");
        map.put("Petrov", "Ivan");
        map.put("Sidorov", "Petr");
        map.put("Sid", "Petr");
        map.put("Iv", "Ivan");
        map.put("Klima", "Vano");
        map.put("Sidor", "Gleb");
        map.put("Kim", "Ir");
        map.put("Poroh", "Petr");
        map.put("Fat", "Sergey");

         return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {

        int count = 0;
        for (Map.Entry<String,String> pair: map.entrySet()){



             if (pair.getValue().equals(name))
                 count+=1;


        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int count = 0;
               for (Map.Entry<String,String> pair: map.entrySet()){



                    if (pair.getKey().equals(familiya))
                        count+=1;


               }
               return count;

    }
}
