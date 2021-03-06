package com.javarush.test.level22.lesson13.task03;




/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

    public static boolean checkTelNumber(String telNumber) {
        boolean is = false;
        // проверка на null
        if (telNumber == null) {
            return false;
        }

        if (!telNumber.matches("[\\d, \\+,\\(,\\),-]+[\\d]$")) {
            System.out.println(1);
            return false;
        }


        if (telNumber.matches("^\\+.*")) {
            String tmp = telNumber.replaceAll("\\D", "");
            //System.out.println(tmp);
            if (tmp.length() != 12) {
                System.out.println(2);

                return false;
            }
        } else if (telNumber.matches("^(\\(|\\d).*")) {
            String tmp = telNumber.replaceAll("\\D", "");
            if (tmp.length() != 10) {
                System.out.println(3);

                return false;
            }
        }

        else if (!telNumber.matches("^\\-.*")) {
            System.out.println(4);

            return false;
        }


        if (telNumber.matches("\\+?\\d*(\\(\\d{3}\\))?\\d*-?\\d+-?\\d*")) {

            is = true;
        }


        return is;
    }




}