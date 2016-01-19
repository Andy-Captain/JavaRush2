package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            File your_file_name = new File("D:\\your_file_name.tmp");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User one = new User();
            one.setFirstName("Ivan");
            one.setLastName("Ivanov");

            one.setBirthDate(dateFormat.parse("04.02.1979"));
            one.setMale(true);
            one.setCountry(User.Country.UKRAINE);
            javaRush.users.add(one);
            User two = new User();
            two.setFirstName("Anna");
            two.setLastName("Sokol");
            two.setBirthDate(dateFormat.parse("05.06.1975"));
            two.setMale(false);
            two.setCountry(User.Country.RUSSIA);
            javaRush.users.add(two);



            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

            System.out.println(javaRush.users.get(0).equals(loadedObject.users.get(0)));


        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);


        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            String isUser = users != null ? "yes" : "no";
             writer.println(isUser);
            if (isUser.equals("yes") )
            {
                int listSize = users.size();
                writer.println(listSize);
                for (User user : users) {

                    String firstName = user.getFirstName(); if (firstName == null){firstName  = "noName";}
                    writer.println(firstName);
                    String lastName = user.getLastName();if (lastName==null){lastName = "noLastname";}
                    writer.println(lastName);
                    writer.println(dateFormat.format(user.getBirthDate()));
                    writer.println(user.isMale());
                    writer.println(user.getCountry());


                }


            }
            writer.close();


        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream) );
            String isUser = reader.readLine();
            if (isUser.equals("yes"))
            {
                int listSize = Integer.parseInt(reader.readLine());
                users = new ArrayList<>();
                for (int i = 0; i < listSize; i++)
                {
                    User user = new User();
                    String name = reader.readLine();
                    if (name.equals("noName")){name = null; }

                    user.setFirstName(name);
                    String lastName = reader.readLine();
                    if (lastName.equals("noLastname")){ lastName = null;}

                    user.setLastName(lastName);
                    user.setBirthDate(dateFormat.parse(reader.readLine()));
                    user.setMale(reader.readLine().equals("true") ? true : false );
                    user.setCountry(User.Country.valueOf(reader.readLine()));
                    users.add(user);


                }


            }
            reader.close();


        }
    }
}
