package com.javarush.test.level31.lesson08.home01;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* Null Object Pattern
Почитайте на вики про паттерн "Null Object"
Используйте Files,
чтобы в конструкторе класса Solution правильно инициализировать поле fileData объектом ConcreteFileData.
Если возникли какие-то проблемы со чтением файла по пути pathToFile, то инициализируйте поле объектом NullFileData.
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {


        try {
            Path path = Paths.get(pathToFile);
            boolean a = Files.isHidden(path);
            boolean b = Files.isExecutable(path);
            boolean c = Files.isDirectory(path);
            boolean d = Files.isWritable(path);
            fileData = new ConcreteFileData(a, b, c, d);

        } catch (Exception e) {
            fileData = new NullFileData(e);
        }


    }


    public FileData getFileData() {
        return fileData;
    }
}
