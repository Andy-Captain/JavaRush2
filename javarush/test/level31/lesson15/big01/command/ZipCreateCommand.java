package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;
import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;

import java.nio.file.*;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Создание архива.");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Enter full path to file or directory example: D:/temp/a.txt");
            String filePath = ConsoleHelper.readString();
            Path pathToFile = Paths.get(filePath);
            zipFileManager.createZip(pathToFile);
            ConsoleHelper.writeMessage("Архив создан.");
        }catch (PathIsNotFoundException e)
        {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");

        }

    }
}
