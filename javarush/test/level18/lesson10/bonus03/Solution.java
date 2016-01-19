package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

import java.util.Formatter;

import java.util.LinkedHashMap;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
              String fileName = reader.readLine();
              BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

               LinkedHashMap<Integer,String> integerStringHashMap = new LinkedHashMap<>();

                 String id = "";
               String productName = "";
               String price = "";
               String quantity = "";
                 String key = "";

               if (args.length < 2 && args.length == 3 && args.length == 4)
               {
                   return;
               }
               else if (args.length > 4 && args[0].equals("-u") )
               {
                   quantity = args[args.length-1];

                   price = args[args.length-2];

                   key = args[0];
                   id = args[1];

                   if (args.length == 5)
                   {
                       productName = args[2];
                   } else
                   {
                       for (int i = 2; i < args.length-2; i++)
                       {
                           productName +=  args[i] + " ";
                       }
                   }


               }else if (args.length == 2 && args[0].equals("-d"))
               {
                   key = args[0];
                   id = args[1];
                   if (id.length() > 8)
                      {
                      id = id.substring(0,8);
                      }
               }




               Formatter formatter = new Formatter();
               if (key.equals("-u"))
               {
                    String s = "";
                  while (bufferedReader.ready())
                   {     s = bufferedReader.readLine();
                       if (!s.isEmpty()) {
                           if (s.contains("\uFEFF")) {
                               s = s.replace("\uFEFF", "");
                           }
                           int n = Integer.parseInt(s.substring(0, 8).trim());

                           integerStringHashMap.put(n,s);
                       }
                   }

                   bufferedReader.close();
                   reader.close();
                   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
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
                   if (id.length() > 8)
                   {
                       id = id.substring(0,8);
                   }

                   int idInLHM = Integer.parseInt(id);
                   formatter.format("%-8s%-30s%-8s%-4s",id,productName,price,quantity);
                   for (Integer integer : integerStringHashMap.keySet()) {
                       if (integer == idInLHM){
                           integerStringHashMap.put(idInLHM,formatter.toString());

                       }

                   }

                   for (String s1 : integerStringHashMap.values()) {

                        bufferedWriter.write( s1 + "\r\n");
                   }




                   bufferedWriter.close();
                }
               else if ((key.equals("-d")))
                    {
                        String s = "";
                        while (bufferedReader.ready())
                        {     s = bufferedReader.readLine();
                        if (!s.isEmpty()) {
                        if (s.contains("\uFEFF")) {
                         s = s.replace("\uFEFF", "");
                          }
                        int n = Integer.parseInt(s.substring(0, 8).trim());

                       integerStringHashMap.put(n,s);
                          }
                          }

                        bufferedReader.close();
                        reader.close();

                        integerStringHashMap.remove(Integer.parseInt(id));
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
                        for (String s1 : integerStringHashMap.values()) {

                             bufferedWriter.write( s1 + "\r\n");
                        }




                        bufferedWriter.close();




                    }







               }




           }
