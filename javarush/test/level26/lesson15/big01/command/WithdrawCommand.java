package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ResourceBundle;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException {

        ConsoleHelper.writeMessage("Enter currency code");
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        while(true) {
            ConsoleHelper.writeMessage(res.getString("before"));
            String summ = ConsoleHelper.readString();
            int enteredSumm;
             try {
                  enteredSumm = Integer.parseInt(summ);

             } catch (NumberFormatException e)
             {
                 ConsoleHelper.writeMessage(res.getString("specify.amount"));
                 continue;
             }
            if (!manipulator.isAmountAvailable(enteredSumm))
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }

            if (enteredSumm <= 0)
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));

                continue;
            }

            try {
                manipulator.withdrawAmount(enteredSumm);
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                 continue;
            }

            ConsoleHelper.writeMessage(String.format(("success.format"), enteredSumm, currencyCode));
            break;


        }

    }
}
