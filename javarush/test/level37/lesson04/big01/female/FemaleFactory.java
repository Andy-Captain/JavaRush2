package com.javarush.test.level37.lesson04.big01.female;

import com.javarush.test.level37.lesson04.big01.Human;
import com.javarush.test.level37.lesson04.big01.male.KidBoy;
import com.javarush.test.level37.lesson04.big01.male.Man;
import com.javarush.test.level37.lesson04.big01.male.TeenBoy;

public class FemaleFactory {



    public Human getPerson(int age)
       {
           if (age < 0)
           {return null;}

           if (age <= KidGirl.MAX_AGE)
           {
               return new KidGirl();
           }
           else if (age > KidGirl.MAX_AGE && age <= TeenGirl.MAX_AGE)
           {
               return new TeenGirl();
           }else {
               return new Woman();

           }
       }
}
