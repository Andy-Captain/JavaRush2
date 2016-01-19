package com.javarush.test.level25.lesson02.task02;


import java.util.LinkedList;
import java.util.List;


/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected  List<Wheel> wheels;

        public Car() {
            //init wheels here
            wheels = new LinkedList<>();

            String [] value = loadWheelNamesFromDB();

            for (String s : value) {
                if (s.equals("FRONT_LEFT"))
                {
                    wheels.add(Wheel.FRONT_LEFT);
                }
                if (s.equals("FRONT_RIGHT"))
                {
                    wheels.add(Wheel.FRONT_RIGHT);
                }
                if (s.equals("BACK_LEFT"))
                {
                    wheels.add(Wheel.BACK_LEFT);
                }
                if (s.equals("BACK_RIGHT"))
                {
                    wheels.add(Wheel.BACK_RIGHT);
                }

            }

        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }


}
