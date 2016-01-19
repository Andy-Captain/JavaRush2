package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map= new HashMap<String,String>();
        map.put("Ivanov", "Ivan");
        map.put("Petrov", "Sergey");
        map.put("Sidorov", "Oleg");
        map.put("Kim", "Dima");
        map.put("Chir", "Oleg");
        map.put("Ir", "Ivan");
        map.put("Mao", "Kolja");
        map.put("Dze", "Mitjaj");
        map.put("Dun", "Oleg");
        map.put("Fil", "Sasha");
        return map;


    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> map2= new HashMap<String,String>(map);
        HashMap<String, String> map3= new HashMap<String,String>(map);
        for (Map.Entry pair: map2.entrySet()) {
            map3.remove(pair.getKey());
         if (map3.containsValue(pair.getValue()))
             removeItemFromMapByValue(map, pair.getValue());



         }



    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, Object value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }


}
