package com.javarush.test.level22.lesson09.task02;

import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {

        if ( params.isEmpty())
        {
            return new StringBuilder();
        }
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> stringStringEntry : params.entrySet()) {
              String key = stringStringEntry.getKey();
              String value = stringStringEntry.getValue();


            if ( value != null)
            {

                sb.append(String.format("%s = '%s' and ", key, value));


            }


        }
        sb.replace(sb.length()-5,sb.length(),"");
        return sb;
    }




}
