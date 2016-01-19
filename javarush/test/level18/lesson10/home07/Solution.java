package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id,
 и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        int id = 0;
        if (args.length > 0)
        {
            id = Integer.parseInt(args[0]);
        }
        String data;

        while ((data = fileReader.readLine()) != null)
        {

            String [] dataId = data.split(" ");

            int num = Integer.parseInt(dataId[0]);
            if (id == num)
            {
                System.out.println(data);
                break;
            }


        }
        reader.close();
        fileReader.close();

    }
}
