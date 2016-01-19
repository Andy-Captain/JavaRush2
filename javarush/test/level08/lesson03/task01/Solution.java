package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import java.util.HashSet;
import java.util.Iterator;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        HashSet<String> hs = new HashSet<String>();
        hs.add("арбуз");
        hs.add("банан");
        hs.add("вишня");
        hs.add("груша");
        hs.add("дыня");
        hs.add("ежевика");
        hs.add("жень-шень");
        hs.add("земляника");
        hs.add("ирис");
        hs.add("картофель");

        Iterator<String> iterator = hs.iterator();

        while (iterator.hasNext())
        {
            String text = iterator.next();

            System.out.println(text);
        }



    }
}
