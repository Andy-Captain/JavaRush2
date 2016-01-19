package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/



import java.io.FileInputStream;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        String firstFileName;
            if (args.length > 0)
            {
                firstFileName = args[0];
            }
        else {
        firstFileName= "D:\\1.txt";}
        FileInputStream fis = new FileInputStream(firstFileName);
        TreeMap<Character,Integer> characterIntegerTreeMap = new TreeMap<>();
        char data ;

        while (fis.available() > 0)
        {    data = (char)fis.read();
            if (characterIntegerTreeMap.containsKey(data)) {
                characterIntegerTreeMap.put(data, characterIntegerTreeMap.get(data) + 1);
            }
            else characterIntegerTreeMap.put(data,  1);
        }
        fis.close();
        for (Map.Entry<Character,Integer> entry : characterIntegerTreeMap.entrySet()) {
            System.out.println(entry.getKey() +" " + entry.getValue());
            
        }



    }
}
