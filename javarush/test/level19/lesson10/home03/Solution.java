package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        String fileName = "";
        String data = "";
        int day = 0,mounth = 0,year = 0;
        if (args.length < 1)
        {
            return;
        } else {fileName = args[0];}
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        while ((data = reader.readLine()) != null)
        {
            if (!data.isEmpty()) {
                String[] parseData = data.split(" ");

                    year = Integer.parseInt(parseData[parseData.length - 1]);
                    mounth = Integer.parseInt(parseData[parseData.length - 2]);
                    day = Integer.parseInt(parseData[parseData.length - 3]);

                String name = "";
                 if(parseData.length >= 4 && parseData.length < 7){
                    for (int i = 0; i < parseData.length - 3; i++) {
                        name = name + parseData[i] + " ";
                    }

                }

                Calendar cal = new GregorianCalendar(year,mounth-1,day);
                name = name.substring(0,name.length()-1);
                Date birthday = cal.getTime();
                Person person = new Person(name, birthday);
                PEOPLE.add(person);
            }
        }
        reader.close();







    }

}
