package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз,
и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNames;
               while (true)
               {
                   fileNames = reader.readLine();
                   if (fileNames.equals("exit")){

                       break;}
                   if (!fileNames.isEmpty()){
                       ReadThread thread = new ReadThread(fileNames);
                           thread.start();
                       try {
                           thread.join();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   } }
        reader.close();



    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {

               this.fileName = fileName;

        }

        public String getFileName() {
            return fileName;
        }

        @Override
        public void run() {


                    try {


                        FileInputStream fis = new FileInputStream(this.getFileName());
                        int max = Integer.MIN_VALUE;
                        Map<Integer, Integer> integerIntegerTreeMap = new HashMap<>();

                        while (fis.available() > 0) {
                            int fileByte = fis.read();
                            if (integerIntegerTreeMap.containsKey(fileByte)) {
                                integerIntegerTreeMap.put(fileByte, integerIntegerTreeMap.get(fileByte) + 1);
                            } else {
                                integerIntegerTreeMap.put(fileByte, 1);
                            }

                        }
                        for (Map.Entry<Integer, Integer> entry : integerIntegerTreeMap.entrySet()) {
                            int value = entry.getValue();
                            if (max < value) {
                                max = value;
                            }
                        }
                        for (Map.Entry<Integer, Integer> entry : integerIntegerTreeMap.entrySet()) {
                            int value = entry.getValue();
                            if (max == value) {
                                int data = entry.getKey();
                                resultMap.put(this.getFileName(), data);
                            }
                        }


                        fis.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

        }


    }
}
