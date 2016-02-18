package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {

    private ResourceBundle validCreditCards = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.verifiedCards");

    @Override
    public void execute() throws InterruptOperationException {
        String num;
        String pn;
        ConsoleHelper.writeMessage(("before"));
        while (true) {

            ConsoleHelper.writeMessage(("specify.data"));
            num = ConsoleHelper.readString();
            pn = ConsoleHelper.readString();


            if (validCreditCards.containsKey(num)) {
                if (validCreditCards.getString(num).equals(pn)) {
                    ConsoleHelper.writeMessage(("success.format"));
                    break;
                } else {
                    ConsoleHelper.writeMessage(("not.verified.format"));
                    ConsoleHelper.writeMessage(("try.again.or.exit"));
                }


            } else {
                ConsoleHelper.writeMessage(("not.verified.format"));
                ConsoleHelper.writeMessage(("try.again.or.exit"));
                continue;
            }


        }


    }
}
