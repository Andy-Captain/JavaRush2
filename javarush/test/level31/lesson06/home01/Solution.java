package com.javarush.test.level31.lesson06.home01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String filename = args[0];
        String zipPath = args[1];
//        String filename = "D:/temp/zzz.txt";       // sourse file
//        String zipPath = "D:/temp/temp.zip";     // sourse zip

        String shortFileName = new File(filename).getName();  //zzz.txt

        Map<String, byte[]> zipEntrysHashMap = new HashMap<>();           //   hold data files


        FileInputStream fileInputStream = new FileInputStream(zipPath);   //read source file
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
        ZipEntry tmpZip;
        while ((tmpZip = zipInputStream.getNextEntry()) != null) {
            if(tmpZip.isDirectory())
            {
              zipEntrysHashMap.put(tmpZip.getName(),null);
            } else {
                byte[] arr = new byte[1024];   // hold data
                int read = zipInputStream.read(arr, 0, arr.length);
                zipEntrysHashMap.put(tmpZip.getName(), arr);
           }
        }
        zipInputStream.close();
        fileInputStream = new FileInputStream(filename);

        if (!zipEntrysHashMap.containsKey(shortFileName)) {
            int inputLength = fileInputStream.available();
            byte[] buff = new byte[inputLength];
            int count = fileInputStream.read(buff, 0, inputLength);
            zipEntrysHashMap.put(shortFileName, buff);    //add source file
        }
        else{

            byte[] bytes = zipEntrysHashMap.get(shortFileName);
            zipEntrysHashMap.remove(shortFileName);
            zipEntrysHashMap.put("new/"+shortFileName,bytes);
        }
        fileInputStream.close();

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipPath));

        for (Map.Entry<String, byte[]> entry : zipEntrysHashMap.entrySet()) {

            String name = entry.getKey();
            byte[] arr = new byte[0];
            if (entry.getValue()!=null) {
                 arr = entry.getValue();
            }
            zipOutputStream.putNextEntry(new ZipEntry(name));
            if (entry.getValue()!=null) {
            zipOutputStream.write(arr);  }


        }
        zipOutputStream.close();


    }
}
