package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople,
выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws  ParseException {



            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String name = "";

            if(args[0].equals("-c") )
               {
                          if (args.length == 5 )
                          {
                                name = args[1] + " " + args[2];
                          } else name = args[1];

                        if (args[2].equals("м")) {

                            allPeople.add(allPeople.size(), Person.createMale(name, dateFormat.parse(args[args.length-1])));
                            System.out.println(allPeople.size() - 1);
                        } else {
                            allPeople.add(allPeople.size(), Person.createFemale(name, dateFormat.parse(args[args.length-1])));
                            System.out.println(allPeople.size() - 1);
                        }

               }
            else if(args[0].equals("-u"))
            {
                if (args.length == 6 )
                   {
                   name = args[2] + " " + args[3];
                   } else name = args[2];


                    Person thisPerson = allPeople.get(Integer.parseInt(args[1]));
                    thisPerson.setName(name);
                    thisPerson.setBirthDay(dateFormat.parse(args[args.length-1]));
                if (args[args.length-2].equals("м"))
                   {
                       thisPerson.setSex(Sex.MALE);
                   } else   thisPerson.setSex(Sex.FEMALE);



            }
            else if(args[0].equals("-d"))
            {

                Person person =allPeople.get(Integer.parseInt(args[1]));
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDay(null);
            }
            else if(args[0].equals("-i"))
            {

                Person person = allPeople.get(Integer.parseInt(args[1]));
                System.out.printf("%s %s %s",
                        person.getName(),
                        person.getSex().equals(Sex.MALE) ? "м" : "ж",
                        dateFormat1.format(person.getBirthDay()));
            }


            }


    }
