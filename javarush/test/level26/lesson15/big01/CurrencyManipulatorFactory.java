package com.javarush.test.level26.lesson15.big01;



import java.util.HashMap;



/**
 * Created by Dmitriy on 24.06.2015.
 */
public final class CurrencyManipulatorFactory {

    static HashMap<String,CurrencyManipulator> manipulatorMap = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

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
