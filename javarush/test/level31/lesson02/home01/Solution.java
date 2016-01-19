package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        //
       // String resultFileAbsolutePath = "C:/test/Delite.txt";
        //String path = "c:/test/";
        //

        String newFileName = "allFilesContent.txt";
        File folder = new File(path);
        List<File> listFiles = new ArrayList<>();

        getAllFolders(folder, listFiles);

        List<File> listNewFiles = new ArrayList<>();
        for (File file : listFiles) {
            if (file.length() > 50) {
                file.delete();

            } else {
                listNewFiles.add(file);
            }

        }

        Collections.sort(listNewFiles, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });


        Path source = Paths.get(resultFileAbsolutePath);
        Path newResPath = Files.move(source, source.resolveSibling(newFileName));

        writeToFile(listNewFiles, newResPath.toFile());

    }

    private static void writeToFile(List<File> listFiles, File to) {
        BufferedReader reader = null;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(to));
            for (File listFile : listFiles) {
                if (listFile.exists())
                    reader = new BufferedReader(new FileReader(listFile));
                while (reader.ready()) {
                    writer.write(reader.readLine());
                    writer.newLine();
                }


            }
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void getAllFolders(File folder, List<File> list) {


        for (File entry : folder.listFiles()) {
            if (entry.isDirectory()) {
                if (entry.length() == 0) {
                    entry.delete();

                } else {
                    getAllFolders(entry, list);
                }
            } else {
                list.add(entry);
            }
        }

    }


}
