package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        String thirdFileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(firstFileName);
        FileOutputStream fileOutputStream1 = new FileOutputStream(secondFileName);
        FileOutputStream fileOutputStream2 = new FileOutputStream(thirdFileName);


        ArrayList<Integer> dataList = new ArrayList<>();

            while (fileInputStream.available() > 0 )
               {
                int fileBytes = fileInputStream.read();
                dataList.add(fileBytes);

               }
           if (dataList.size() % 2 == 0) {
               for (int i = 0; i < dataList.size() / 2; i++) {
                   int data = dataList.get(i);
                   fileOutputStream1.write(data);
               }
               for (int i = dataList.size() / 2; i < dataList.size(); i++) {
                   int data = dataList.get(i);
                   fileOutputStream2.write(data);
               }
           } else
              {
                  for (int i = 0; i < ((dataList.size() / 2)+1); i++)
                     {
                      int data = dataList.get(i);
                      fileOutputStream1.write(data);
                     }
                                 for (int i = ((dataList.size() / 2)+1); i < dataList.size(); i++) {
                                     int data = dataList.get(i);
                                     fileOutputStream2.write(data);
                                 }

              }

             reader.close();
             fileInputStream.close();
             fileOutputStream1.close();
             fileOutputStream2.close();








    }
}
