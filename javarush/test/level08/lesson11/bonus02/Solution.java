package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String,String> addresses = new HashMap<String,String>();

        while(true){
            String town = reader.readLine();

            if(town.isEmpty())
            {
                break;
            }

                String family = reader.readLine();
                addresses.put(town, family);


        }

        String town2 = reader.readLine();


          for(Map.Entry<String, String> pair : addresses.entrySet())
          {
              String key = pair.getKey();
              String value = pair.getValue();
              if (town2.equals(key))
                  System.out.println(value);

          }


        //list of addresses
              /*  List<String> addresses = new ArrayList<String>();
                while (true)
                {   System.out.println("Family");//
                    String family = reader.readLine();
                    if (family.isEmpty()) break;

                    addresses.add(family);
                }

                //read home number
                int houseNumber = Integer.parseInt(reader.readLine());
                System.out.println("hause num");//

                if (0 <= houseNumber && houseNumber < addresses.size())
                {
                    String familySecondName = addresses.get(houseNumber);
                    System.out.println(familySecondName);
                }  */


    }
}

