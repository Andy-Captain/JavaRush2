package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        ArrayList<String> firstDataList = new ArrayList<>();
        ArrayList<String> secondDataList = new ArrayList<>();
        reader = new BufferedReader(new FileReader(filename1));

        String data = "";

        while (reader.ready())
                {
                    data = reader.readLine();
                    firstDataList.add(data);

                }
        reader.close();
        reader = new BufferedReader(new FileReader(filename2));
        while (reader.ready())
                {
                    data = reader.readLine();
                    secondDataList.add(data);

                }
        reader.close();
         int i,j;

        for ( i = 0,j = 0; i < firstDataList.size(); ) {

           if (j < secondDataList.size() && i < firstDataList.size()) {

               if (firstDataList.get(i).equals(secondDataList.get(j))) {
                   lines.add(new LineItem(Type.SAME, firstDataList.get(i)));

                   i++;
                   j++;

               } else if (!firstDataList.get(i).equals(secondDataList.get(j))) {


                   if (firstDataList.get(i).equals(secondDataList.get(j + 1))) {
                       lines.add(new LineItem(Type.ADDED, secondDataList.get(j)));
                       if (j + 1 < secondDataList.size()) {
                           j++;
                       }

                   } else if (firstDataList.get(i + 1).equals(secondDataList.get(j))) {
                       lines.add(new LineItem(Type.REMOVED, firstDataList.get(i)));
                       if (i + 1 < firstDataList.size()) {
                           i++;
                       }

                   }


               }
           }

               if ((i == firstDataList.size()) && j < secondDataList.size()  )
                    {
                      lines.add( new LineItem(Type.ADDED,secondDataList.get(j)));
                     }
                 else   if (j == secondDataList.size()  && i < firstDataList.size() )
                     {

                   lines.add( new LineItem(Type.REMOVED,firstDataList.get(i)));
                    }






        }











    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }


    }
}
