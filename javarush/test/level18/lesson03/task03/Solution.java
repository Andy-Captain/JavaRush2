package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                        FileInputStream fis = new FileInputStream(reader.readLine());


                        ArrayList<Integer> listByte = new ArrayList<>();
                        while (fis.available() > 0)
                        {
                            int  value = fis.read();

                             listByte.add(value);

                        }
                        reader.close();
                        fis.close();
        ArrayList<Integer> listByteDublicats = new ArrayList<>();

            int [] arr = new int [listByte.size()];

        for (int i = 0; i < listByte.size()-1; i++ ) {
            arr[i] = 0;
            for (int j = i+1; j < listByte.size(); j++)
            {
               if ((listByte.get(i)).equals(listByte.get(j)))
               {

                     arr[i]++;
               }

            }

        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++){
            if (arr[i]> max)
            {
                max = arr[i];
            }
        }
        for (int i = 0; i < listByte.size(); i++) {
            if (!listByteDublicats.contains(listByte.get(i))&&arr[i]==max) listByteDublicats.add(listByte.get(i));

        }
        for (int i = 0; i < listByteDublicats.size(); i++)
        {
            System.out.print(listByteDublicats.get(i)+" ");
        }



    }

}
