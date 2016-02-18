package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;



class DepositCommand implements Command {
    @Override
    public void execute() throws  InterruptOperationException {
        String code = ConsoleHelper.askCurrencyCode();
        String[] nominalCount = ConsoleHelper.getValidTwoDigits(code);
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        manipulator.addAmount(Integer.parseInt(nominalCount[0]), Integer.parseInt(nominalCount[1]));
    }
}
