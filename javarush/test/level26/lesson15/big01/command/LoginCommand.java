package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {

    private ResourceBundle validCreditCards = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");
    @Override
    public void execute() throws InterruptOperationException {
        String num;
        String pn;
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {

            ConsoleHelper.writeMessage(res.getString("specify.data"));
            num = ConsoleHelper.readString();
            pn = ConsoleHelper.readString();


            if (validCreditCards.containsKey(num)) {
                if (validCreditCards.getString(num).equals(pn)) {
                    ConsoleHelper.writeMessage(res.getString("success.format"));
                    break;
                } else {
                    ConsoleHelper.writeMessage(res.getString("not.verified.format"));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                }


            } else {
                ConsoleHelper.writeMessage(res.getString("not.verified.format"));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }


        }


    }
}
