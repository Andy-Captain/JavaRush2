package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitriy on 24.06.2015.
 */
public class CurrencyManipulator {
    String currencyCode;
    Map<Integer, Integer> denominations = new HashMap<>();;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }



    public void addAmount(int denomination, int count)
    {

    if(denominations.containsKey(denomination)) {
        denominations.put(denomination, denominations.get(denomination) + count);
    }
    else {
        denominations.put(denomination, count);
    }
    }
}