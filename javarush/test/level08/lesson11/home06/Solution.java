package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> children = new ArrayList<Human>();
        Human ch1 = new Human("Oleg",true,8,new ArrayList<Human>());
        children.add(ch1);
        Human ch2 = new Human("Olga",false,6,new ArrayList<Human>());
        children.add(ch2);
        Human ch3 = new Human("Ira",false,3,new ArrayList<Human>());
        children.add(ch3);

        ArrayList<Human> parents = new ArrayList<Human>();
        Human father = new Human("Ilja", true, 40, children);
        parents.add(father);
        Human mother = new Human("Ira", false, 37, children);
        parents.add(mother);

        Human grandFather1 = new Human("Ostap", true, 84, parents);
        Human grandFather2 = new Human("Orest", true, 82, parents);
        Human grandMother1 = new Human("Parasha", false, 79, parents);
        Human grandMother2 = new Human("Ivanna", false, 76, parents);

        System.out.println(ch1.toString());
        System.out.println(ch2.toString());
        System.out.println(ch3.toString());

        System.out.println(father.toString());
        System.out.println(mother.toString());


        System.out.println(grandFather1.toString());
        System.out.println(grandFather2.toString());
        System.out.println(grandMother1.toString());
        System.out.println(grandMother2.toString());

        //Написать тут ваш код
    }

    public static class Human
    {
        public String name;
        public boolean sex;
        public int age;
       public ArrayList<Human> children;
        public Human (String name, boolean sex, int age, ArrayList<Human> children ){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;

        }
        //Написать тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
