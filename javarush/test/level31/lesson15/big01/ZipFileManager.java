package com.javarush.test.level31.lesson15.big01;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Dmitriy on 23.01.2016.
 */
public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }


    public void createZip(Path source) throws IOException {


        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(zipEntry);

            try (InputStream inputStream = Files.newInputStream(source)) {
                int lenghtFile;
                while ((lenghtFile = inputStream.available()) > 0) {
                    byte[] buff = new byte[lenghtFile];
                    inputStream.read(buff, 0, lenghtFile);
                    zipOutputStream.write(buff);
                }
            }
            zipOutputStream.closeEntry();
        }

    }
}
