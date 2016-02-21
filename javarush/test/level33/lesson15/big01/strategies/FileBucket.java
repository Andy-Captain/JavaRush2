package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket implements Serializable {

    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile("tmp", null);

        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        return path.toFile().length();
    }

    public void putEntry(Entry entry) {
        try (java.io.ObjectOutputStream s = new ObjectOutputStream(Files.newOutputStream(path))) {
            s.writeObject(entry);

        } catch (IOException e) {
            ExceptionHandler.log(e);
        }

    }

    public Entry getEntry() {
        Entry entry = null;
        if (path.toFile().length() > 0) {
            try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(path))) {
                Object object = inputStream.readObject();
                 entry = (Entry) object;
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
        return entry;
    }

    public void remove() {

        try {
            Files.delete(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }

    }

}
