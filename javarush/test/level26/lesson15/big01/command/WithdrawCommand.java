package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

class WithdrawCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {

        ConsoleHelper.writeMessage("Enter currency code");
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        while(true) {
            ConsoleHelper.writeMessage(("before"));
            String summ = ConsoleHelper.readString();
            int enteredSumm;
             try {
                  enteredSumm = Integer.parseInt(summ);

             } catch (NumberFormatException e)
             {
                 ConsoleHelper.writeMessage(("specify.amount"));
                 continue;
             }
            if (!manipulator.isAmountAvailable(enteredSumm))
            {
                ConsoleHelper.writeMessage(("not.enough.money"));
                continue;
            }

            if (enteredSumm <= 0)
            {
                ConsoleHelper.writeMessage(("specify.not.empty.amount"));

                continue;
            }

            try {
                manipulator.withdrawAmount(enteredSumm);
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(("exact.amount.not.available"));
                 continue;
            }

            ConsoleHelper.writeMessage(String.format(("success.format"), enteredSumm, currencyCode));
            break;


        }

    }
}
