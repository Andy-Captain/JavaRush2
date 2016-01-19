package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно,
инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/



import java.io.*;

import java.util.ArrayList;
import java.util.Formatter;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String fileName = reader.readLine();
       BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));


        ArrayList<String> stringArrayList = new ArrayList<>();
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,true));


          String id;
        String productName = "";
        String price;
        String quantity;
          String key = "";

        if (args.length < 3 && !args[0].equals("-c"))
        {
            return;
        }
        else
        {
            quantity = args[args.length-1];

            price = args[args.length-2];

            key = (args[0]);


            if (args.length == 3)
            {
                productName = args[1];
            } else
            {
                for (int i = 1; i < args.length-2; i++)
                {
                    productName +=  args[i] + " ";
                }
            }


        }


        Formatter formatter = new Formatter();
        if (key.equals("-c"))
        {
             String s = "";
           while (bufferedReader.ready())
            {     s = bufferedReader.readLine();
                if (!s.isEmpty()) {
                    if (s.contains("\uFEFF")) {
                        s = s.replace("\uFEFF", "");
                    }
                    stringArrayList.add(s);
                }
            }



             int max = Integer.MIN_VALUE;
            for (String s1 : stringArrayList) {

                    int n = Integer.parseInt(s1.substring(0, 8).trim());

                    if (max < n) {
                        max = n;
                    }

                }
            max++;

             if (productName.length() > 30)
             {
                 productName = productName.substring(0,30);
             }
             if (price.length() > 8)
             {
                 price = price.substring(0,8);
             }
             if (quantity.length() > 4)
             {
                 quantity = quantity.substring(0,4);
             }

            formatter.format("%-8d%-30s%-8s%-4s",max,productName,price,quantity);

            bufferedWriter.write("\r\n"+formatter.toString());
            reader.close();

            bufferedReader.close();
            bufferedWriter.close();
            }
        }

    }

