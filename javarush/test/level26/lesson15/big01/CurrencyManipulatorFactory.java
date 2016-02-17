package com.javarush.test.level26.lesson15.big01;


import java.util.HashMap;
import java.util.Map;


public abstract class CurrencyManipulatorFactory {

    public static Map<String,CurrencyManipulator> manipulatorMap = new HashMap<>();



    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        CurrencyManipulator currencyManipulator ;
        if (!manipulatorMap.containsKey(currencyCode))
        {    CurrencyManipulator cm = new CurrencyManipulator(currencyCode);
           manipulatorMap.put(currencyCode,cm);
            return cm;
        }
        else {

            return manipulatorMap.get(currencyCode);
        }

    }
}
