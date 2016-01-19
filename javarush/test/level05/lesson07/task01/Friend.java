package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    private String filename = null;
    public void initialize(String name){
        this.filename = name;
           }

    public void initialize(String name, String age){

        this.filename = name + age;
    }
    public void initialize(String name, String age, String pol){

            this.filename = name + age + pol;
        }
}
