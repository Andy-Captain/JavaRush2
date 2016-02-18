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
        ConsoleHelper.writeMessage("Enter card number and pin code");
        while (true) {


            num = ConsoleHelper.readString();
            pn = ConsoleHelper.readString();


            if (validCreditCards.containsKey(num)) {
                if (validCreditCards.getString(num).equals(pn)) {
                    ConsoleHelper.writeMessage("Verification successful");
                    break;
                }
                else {
                    ConsoleHelper.writeMessage("Invalid pin number please try again...");
                }


            } else {
                ConsoleHelper.writeMessage("Invalid card number please try again...");
                continue;
            }


        }


    }
}
