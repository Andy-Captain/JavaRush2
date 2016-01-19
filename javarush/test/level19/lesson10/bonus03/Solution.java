package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег,
 одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(filename));
        String teg = args[0];




        StringBuilder sb = new StringBuilder();
        while (reader.ready())
        {
            String s = reader.readLine();


                sb.append(s);


        }
        String s = sb.toString().replaceAll("\r\n","");
        reader.close();

            if (!s.contains("CDATA")) {

                find(s, teg,0);
            }








    }

    public static void find (String data, String teg, int count)
    {    String  tegOpen = "<" + teg ;
         String tegClosed = "</" + teg ;
        int i = count;
        int containceTeg = 0;
        int start = 0;

         while ((data.length()-tegOpen.length()-1) > i )
         {

           if (data.substring(i,i+tegOpen.length()).contains(tegOpen))
           {
               if (containceTeg == 0) {
                   start = i;
               }
               containceTeg++;

           }  else if (data.substring(i,i+tegClosed.length()).contains(tegClosed))
           {
               containceTeg--;


               if (containceTeg == 0)
               {
                   String rezult = data.substring(start,i+tegClosed.length()+1);
                   System.out.println(rezult);
                   find(rezult,teg,1);
               }

           }

           i++;


         }


    }
}
