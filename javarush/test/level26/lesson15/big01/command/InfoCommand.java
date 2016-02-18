package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;

class InfoCommand implements Command{
    @Override
    public void execute() {
        Collection<CurrencyManipulator> allCurrencyManipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();

         if (allCurrencyManipulators.isEmpty() )
         {
             ConsoleHelper.writeMessage("No money available.");
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
               ConsoleHelper.writeMessage("No money available.");
           }
         }


    }
}
