package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

class ExitCommand implements Command{
    @Override
    public void execute() throws  InterruptOperationException {

        ConsoleHelper.writeMessage("You really want to exit Yes/No ?");
        String code = ConsoleHelper.readString();
        if (code.toLowerCase().equals("Y".toLowerCase()))
        {
            ConsoleHelper.writeMessage("By by....");

        }

    }
}
