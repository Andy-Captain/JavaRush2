package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.Helper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileBucket implements Serializable {

    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(Paths.get("D:/temp"), Helper.generateRandomString(),".tmp");

        } catch (IOException e) {

        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        return path.toFile().length();
    }

    public void putEntry(Entry entry) {
        try (java.io.ObjectOutputStream s = new ObjectOutputStream(Files.newOutputStream(path))) {
            s.defaultWriteObject();
            Entry e = entry;
            while (e!=null) {
                s.writeObject(e);
                e = e.next;
            }
        }
        catch (IOException e) {}

    }

    public Entry getEntry() {
        if (getFileSize() == 0) return null;
        try (java.io.ObjectInputStream s = new ObjectInputStream(Files.newInputStream(path)))
        {
            s.defaultReadObject();
            Entry result = (Entry) s.readObject();
            Entry last = result;
            Entry temp;
            while ((temp = (Entry)s.readObject()) != null) {
                last.next = temp;
                last = temp;
            }
            return result;
        }
        catch (IOException | ClassNotFoundException e) {}
        return null;
    }

    public void remove() {

        try {
            Files.delete(path);
        } catch (IOException e) {

        }

    }

}
