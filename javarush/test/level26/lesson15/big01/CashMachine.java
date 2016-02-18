package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) throws  InterruptOperationException {
        Locale.setDefault(Locale.ENGLISH);

       try {



           Operation op = null;
           CommandExecutor.execute(Operation.LOGIN);
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
