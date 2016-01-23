package com.javarush.test.level31.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 * Created by Dmitriy on 23.01.2016.
 */
public class Archiver {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter full archive path and name >> example: D:/temp/abc.zip");
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(reader.readLine()));
        System.out.println("Enter full FILE path and name >> example: D:/temp/a.txt");
        zipFileManager.createZip(Paths.get(reader.readLine()));


    }
}
