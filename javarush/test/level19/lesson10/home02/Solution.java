package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = "";
                if (args.length < 1)
                {return;}
                else {
                    filename = args[0];
                }

                TreeMap<String,Double> stringDoubleMap = new TreeMap<>();
                BufferedReader reader = new BufferedReader(new FileReader(filename));

                String data = "";

                while ((data = reader.readLine()) != null)
                {
                    String [] parsData = data.split(" ");
                    String secondName = parsData[0];
                    double salary = Double.parseDouble(parsData[1]);

                    if (!stringDoubleMap.containsKey(secondName))
                    {
                         stringDoubleMap.put(secondName,salary);
                    }
                    else if (stringDoubleMap.containsKey(secondName))
                    {
                        double value = stringDoubleMap.get(secondName);

                        stringDoubleMap.put(secondName,salary+value);

                    }
               }
                reader.close();
               double max = Double.MIN_VALUE;
                for (Map.Entry<String, Double> entry : stringDoubleMap.entrySet()) {
                     double value = entry.getValue();
                   if (max < value)
                   {
                       max = value;
                   }

                }
        for (Map.Entry<String, Double> entry : stringDoubleMap.entrySet()) {
            String name = entry.getKey();
            double value = entry.getValue();

            if (max == value)
            {
                System.out.println(name);
            }

        }


    }
}
