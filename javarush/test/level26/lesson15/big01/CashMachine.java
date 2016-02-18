package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;

import java.io.IOException;
import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);



        Operation op = null;
        do{
            op = ConsoleHelper.askOperation();
            CommandExecutor.execute(op);

        }   while (!op.equals(Operation.EXIT));

    }
}
