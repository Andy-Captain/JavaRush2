package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;

class InfoCommand implements Command{

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");
    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));
        Collection<CurrencyManipulator> allCurrencyManipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();

         if (allCurrencyManipulators.isEmpty() )
         {
             ConsoleHelper.writeMessage(res.getString("no.money"));
         }
        else{
             int count = 0;
             for (CurrencyManipulator manipulator : allCurrencyManipulators)
              {
                 if (manipulator.hasMoney()) {
                     count++;
                     ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " +manipulator.getTotalAmount());
                 }

             }
           if (count == 0)
           {
               ConsoleHelper.writeMessage(res.getString("no.money"));
           }
         }


    }
}
