package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

public class CashMachine {
    public static void main(String[] args) throws  InterruptOperationException {
        Locale.setDefault(Locale.ENGLISH);
        ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.verifiedCards", Locale.ENGLISH);

       try {


           CommandExecutor.execute(Operation.LOGIN);
           Operation op = null;

           do {
               op = ConsoleHelper.askOperation();
               CommandExecutor.execute(op);

           } while (!op.equals(Operation.EXIT));


       }
       catch (InterruptOperationException e)
       {

           ConsoleHelper.writeMessage("By by....");
       }

    }
}
