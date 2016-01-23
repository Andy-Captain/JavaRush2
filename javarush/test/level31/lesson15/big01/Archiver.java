package com.javarush.test.level31.lesson15.big01;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by Dmitriy on 23.01.2016.
 */
public class Archiver {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter full archive path and name >> example: D:/temp/abc.zip");
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(ConsoleHelper.readString()));
        System.out.println("Enter full FILE path and name >> example: D:/temp/a.txt");
        zipFileManager.createZip(Paths.get(ConsoleHelper.readString()));


    }
}
