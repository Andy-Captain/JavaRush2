package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {


    public static void main(String[] args) {
          testStrategy(new HashMapStorageStrategy(),10000);
          testStrategy(new OurHashMapStorageStrategy(),10000);




    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> rezSet = new HashSet<>();
        for (String string : strings) {
            rezSet.add(shortener.getId(string));
        }
        return rezSet;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys)
    {
         Set<String> rezSet = new HashSet<>();
        for (Long key : keys) {
            rezSet.add(shortener.getString(key));
        }
        return rezSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
       Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> rezSet = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++)
        {
           rezSet.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        long before = new Date().getTime();
        Set<Long> longSet = getIds(shortener, rezSet);
        long after = new Date().getTime();
        Helper.printMessage(String.valueOf(after-before));
        long beforeIds = new Date().getTime();
        Set<String> stringSet = getStrings(shortener, longSet);
        long afterIds = new Date().getTime();
        Helper.printMessage(String.valueOf(afterIds-beforeIds));

        if (rezSet.containsAll(stringSet))
        {
            Helper.printMessage("Тест пройден.");
        } else{

            Helper.printMessage("Тест не пройден.");

        }



    }

}
