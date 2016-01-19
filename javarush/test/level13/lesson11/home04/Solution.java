package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException,NumberFormatException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        FileOutputStream fileOutputStream = new FileOutputStream(s);


        while (true)
        {
           String s1 = reader.readLine();
            String s2 = s1 + "\r\n";
              char [] d = s2.toCharArray();
            if (s1.equals("exit"))
            {   s2 = s1 + "\r\n";
                  d = s2.toCharArray();
                for (char c: d)
                {
                    fileOutputStream.write(c);
                }
                break;

            }
            else {

                 for (char c: d){

                     fileOutputStream.write(c);
                 }


            }


        }
         reader.close();
        fileOutputStream.close();

    }
}
