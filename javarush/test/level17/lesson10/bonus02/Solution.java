package com.javarush.test.level17.lesson10.bonus02;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople,
выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {



        if(args[0].equals("-c") )
           {
               creation(args);

           }
        else if(args[0].equals("-u"))
        {
             update(args);
        }
        else if(args[0].equals("-d"))
        {
             delition(args);
        }
        else if(args[0].equals("-i"))
        {
            printInformation(args);
        }

    }

    public static  void  creation(String[] array ) throws ParseException {   SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

           for (int i = 1; i < array.length; i += 3) {

               if (array[i + 1].equals("м")) {

                   allPeople.add(allPeople.size(), Person.createMale(array[i], dateFormat.parse(array[i + 2])));
                   System.out.println(allPeople.size() - 1);
               } else {
                   allPeople.add(allPeople.size(), Person.createFemale(array[i], dateFormat.parse(array[i + 2])));
                   System.out.println(allPeople.size() - 1);
               }
           }

    }
    public static  void update(String [] array) throws ParseException {

            for (int i = 1; i < array.length; i += 4) {

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Person thisPerson = allPeople.get(Integer.parseInt(array[i]));
                thisPerson.setName(array[i + 1]);
                thisPerson.setBirthDay(dateFormat.parse(array[i + 3]));
                if (array[i + 2].equals("м")) {
                    thisPerson.setSex(Sex.MALE);
                } else thisPerson.setSex(Sex.FEMALE);

            }


    }
    public static  void delition(String [] array)
    {

            for (int i = 1; i < array.length; i++) {
                Person person = allPeople.get(Integer.parseInt(array[i]));
                person.setName(null);
                person.setSex(null);
                person.setBirthDay(null);
            }

    }
    public static  void printInformation(String[] array)
    {

            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            for (int i = 1; i < array.length; i++) {
                Person person = allPeople.get(Integer.parseInt(array[i]));
                System.out.printf("%s %s %s ",
                        person.getName(),
                        person.getSex().equals(Sex.MALE) ? "м" : "ж",
                        dateFormat1.format(person.getBirthDay()));
                System.out.println();
            }


    }
}
