package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
   private String filename = null;
    public void initialize(String name){
        this.filename = name;
    }

    public void initialize(String name, String height){
        this.filename = name + height;
    }
    public void initialize(String name, String height, String color){
            this.filename = name + height + color;
        }
}
