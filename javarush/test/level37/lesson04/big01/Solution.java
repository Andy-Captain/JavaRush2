package com.javarush.test.level37.lesson04.big01;

import com.javarush.test.level37.lesson04.big01.female.FemaleFactory;
import com.javarush.test.level37.lesson04.big01.male.MaleFactory;

public class Solution {

    public static void main(String[] args) {

        MaleFactory maleFactory = new MaleFactory();
        System.out.println(maleFactory.getPerson(99));
        System.out.println(maleFactory.getPerson(4));
        System.out.println(maleFactory.getPerson(15));
        FemaleFactory femaleFactory = new FemaleFactory();
        System.out.println(femaleFactory.getPerson(99));
        System.out.println(femaleFactory.getPerson(4));
        System.out.println(femaleFactory.getPerson(15));

    }

}
