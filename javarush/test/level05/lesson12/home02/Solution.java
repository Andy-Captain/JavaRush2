package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man1 = new Man("Ivan", 20 , "Kiev");
        Man man2 = new Man("Petr", 25, "Lvov");
        Woman wo1 = new Woman("Ira", 23, "Chernigov");
        Woman wo2 = new Woman("Olja", 25, "Kacapetovka");

        System.out.println(man1.name + " " + man1.age + " " +man1.address);
        System.out.println(man2.name + " " + man2.age + " " +man2.address);
        System.out.println(wo1.name + " " + wo1.age + " " +wo1.address);
        System.out.println(wo2.name + " " + wo2.age + " " +wo2.address);
    }

    public static class Man
    {
        String name;
        int age;
        String address;

        public Man(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    public static class Woman
        {   String name;
                int age;
                String address;


            public Woman(String name, int age, String address)
            {
                this.name = name;
                this.age = age;
                this.address = address;

            }
        }




}
