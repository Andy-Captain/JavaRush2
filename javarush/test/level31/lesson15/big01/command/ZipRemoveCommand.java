package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitriy on 23.01.2016.
 */
public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Удаление файла.");

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Введите имя файла для удаления:");
        Path destinationPath = Paths.get(ConsoleHelper.readString());
        zipFileManager.removeFile(destinationPath);

        ConsoleHelper.writeMessage("Удаление из архива завершено.");

    }
}
