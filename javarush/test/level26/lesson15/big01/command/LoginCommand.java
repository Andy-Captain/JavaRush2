package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

public class LoginCommand implements Command {

    private String cardNumber = "123456789012";
    private String pin = "1234";

    @Override
    public void execute() throws InterruptOperationException {
        String num;
        String pn;
        ConsoleHelper.writeMessage("Enter card number and pin code");
        while (true) {


            num = ConsoleHelper.readString();
            pn = ConsoleHelper.readString();


            if (cardNumber.equals(num)) {
                if (pin.equals(pn)) {
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
