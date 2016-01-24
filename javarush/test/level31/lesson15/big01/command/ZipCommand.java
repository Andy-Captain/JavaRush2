package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;

import java.nio.file.*;

public abstract class ZipCommand implements Command{


    public ZipFileManager getZipFileManager() throws Exception{
        ConsoleHelper.writeMessage("Enter full path to arhive example: D:/temp/abc.zip");
        String zipPath = ConsoleHelper.readString();
        Path pathToZip = Paths.get(zipPath);
       return new ZipFileManager(pathToZip);

    }
}
