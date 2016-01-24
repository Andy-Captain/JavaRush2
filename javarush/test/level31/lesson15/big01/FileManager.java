package com.javarush.test.level31.lesson15.big01;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy on 24.01.2016.
 */
public class FileManager {
    private Path rootPath;
    private List<Path> fileList = new ArrayList<>();

    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        collectFileList(rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

    private void collectFileList(Path path) throws IOException{

        if (Files.isRegularFile(path)){
            Path relativize = rootPath.relativize(path);
            fileList.add(relativize);
        }
        if (Files.isDirectory(path))
        {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            for (Path path1 : directoryStream) {
                collectFileList(path1);
            }
            directoryStream.close();
        }
    }
}
