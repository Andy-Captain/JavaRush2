package com.javarush.test.level26.lesson15.big01;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by Dmitriy on 24.06.2015.
 */
public class CashMachine {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);
        String code = ConsoleHelper.askCurrencyCode();

        String[] nominalCount = ConsoleHelper.getValidTwoDigits(code);
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        manipulator.addAmount(Integer.parseInt(nominalCount[0]), Integer.parseInt(nominalCount[1]));
    }
}
