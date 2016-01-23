package com.javarush.test.level31.lesson15.big01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dmitriy on 23.01.2016.
 */
public class Archiver {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter full archive path and name >> example: D:\\temp\\abc.zip");
        String zipName = reader.readLine();
        Path pathToZip = Paths.get(zipName);
         ZipFileManager zipFileManager = new ZipFileManager(pathToZip);
        System.out.println("Enter full FILE path and name >> example: D:\\temp\\a.txt");
        String filename = reader.readLine();
        Path pathToFile = Paths.get(filename);
        zipFileManager.createZip(pathToFile);


       reader.close();
    }
}
