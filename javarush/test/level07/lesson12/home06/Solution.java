package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human grand1 = new Human();
        Human grand2 = new Human();
        Human grandm1 = new Human();
        Human grandm2 = new Human();
        Human father = new Human();
        Human mother = new Human();
        Human son1 = new Human();
        Human son2 = new Human();
        Human dot = new Human();

        grand1.Human("Kolja", true, 55);
        grand2.Human("Vasja", true, 58);
        grandm1.Human("Inna", false, 50);
        grandm2.Human("Olga", false, 51);
        father.Human("Ivan", true, 29, grand1,grandm1);
        mother.Human("Alla", false, 28, grand2,grandm2);
        son1.Human("Sergey", true, 5, father, mother);
        son2.Human("Ivan", true, 2, father, mother);
        dot.Human("Ira", false, 7, father, mother);

        System.out.println(grand1);
        System.out.println(grand2);
        System.out.println(grandm1);
        System.out.println(grandm2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(dot);

    }

    public static class Human
    {
                 String name;
                 boolean sex;
                 int age;
                 Human father;
                 Human mother;


        //Написать тут ваш код

        public void Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
        public void Human(String name, boolean sex, int age){
                    this.name = name;
                    this.sex = sex;
                    this.age = age;


                }


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
