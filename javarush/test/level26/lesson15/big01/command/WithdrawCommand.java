package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

class WithdrawCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {


        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        while(true) {
            ConsoleHelper.writeMessage("Enter the summ");
            String summ = ConsoleHelper.readString();
            int enteredSumm;
             try {
                  enteredSumm = Integer.parseInt(summ);

             } catch (NumberFormatException e)
             {
                 ConsoleHelper.writeMessage("Incorrect data please Enter the summ");
                 continue;
             }
            if (!manipulator.isAmountAvailable(enteredSumm))
            {
                ConsoleHelper.writeMessage("Not enough money");
                continue;
            }

            if (enteredSumm <= 0)
            {
                ConsoleHelper.writeMessage("Incorrect data please Enter the summ");
                continue;
            }

            try {
                manipulator.withdrawAmount(enteredSumm);
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage("Incorrect data please Enter the summ");
                 continue;
            }


            break;


        }

    }
}
