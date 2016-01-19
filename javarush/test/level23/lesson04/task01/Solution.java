package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution [] rez = new Solution[2];

        rez[0]= new Solution();
        rez[0].innerClasses[0] = rez[0].new InnerClass();
        rez[0].innerClasses[1] = rez[0].new InnerClass();

        rez[1]= new Solution();
        rez[1].innerClasses[0] = rez[1].new InnerClass();
        rez[1].innerClasses[1] = rez[1].new InnerClass();



        return rez;
    }
}
