package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть,
потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на
сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        String newFileName = "";

        TreeMap<Integer,String> integerStringTreeMap = new TreeMap<>();
        while (true)
        {
            fileName = reader.readLine();
            if (fileName.equals("end"))
            {
                break;
            } else {


                int partName = Integer.parseInt(fileName.substring(fileName.length() - 1));
                integerStringTreeMap.put(partName, fileName);
            }
        }
        reader.close();
        String tempString = integerStringTreeMap.get(1);
        tempString = tempString.replace("."," ");
        String [] tempArray = tempString.split(" ");
        newFileName = tempArray[0] + "." + tempArray[1];

        File file = new File(newFileName);



        if (!file.exists())
        {
            file.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream(file,true);

        for (Integer integer : integerStringTreeMap.keySet()) {

            String filenameForWrite = integerStringTreeMap.get(integer);
            FileInputStream fileInputStream = new FileInputStream(filenameForWrite);
            byte [] dataBytes = new byte[fileInputStream.available()];
            while (fileInputStream.available() > 0)
            {

                int dataFile = fileInputStream.read(dataBytes);
                fos.write(dataBytes,0,dataFile);

            }
            fileInputStream.close();


        }
        fos.close();

    }
}
