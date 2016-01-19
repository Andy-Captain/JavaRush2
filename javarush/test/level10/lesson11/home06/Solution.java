package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name;
        int age;
        boolean sex;
        int growt;
        int weight;
        String surname;

        public Human()
        {

        }

        public Human(String name)
        {
            this.name = name;
        }
        public Human (String name,String surname)
        {
            this.name = name;
            this.surname = surname;
        }
        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }
        public Human(String name, int age, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        public Human(String name, int age, boolean sex, int growt)

        {
                        this.name = name;
                        this.age = age;
                        this.sex = sex;
                        this.growt = growt;
        }
        public Human(String name, int age, boolean sex, int growt, int weight)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.growt = growt;
            this.weight = weight;


        }
        public Human(String name,String surname, int age, boolean sex, int growt, int weight)
                {
                    this.name = name;
                    this.surname = surname;
                    this.age = age;
                    this.sex = sex;
                    this.growt = growt;
                    this.weight = weight;


                }
        public Human(String name,String surname, int age, int growt, int weight)
                        {
                            this.name = name;
                            this.surname = surname;
                            this.age = age;

                            this.growt = growt;
                            this.weight = weight;


                        }
        public Human(String name,String surname, int age, boolean sex,  int weight)
                        {
                            this.name = name;
                            this.surname = surname;
                            this.age = age;
                            this.sex = sex;

                            this.weight = weight;


                        }
        //напишите тут ваши переменные и конструкторы
    }
}
