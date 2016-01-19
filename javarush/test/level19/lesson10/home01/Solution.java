package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
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
        for (Map.Entry<String, Double> entry : stringDoubleMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }
}
