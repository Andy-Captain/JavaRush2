package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        String fistFileName = "";
        String secondFileName = "";

        if (args.length < 2)
        {
            return;
        }
        else {
          fistFileName = args[0];
          secondFileName = args[1];
        }
        BufferedReader reader = new BufferedReader(new FileReader(fistFileName));
         String data = "";
        BufferedWriter writer = new BufferedWriter(new FileWriter(secondFileName));
        while ((data = reader.readLine()) != null)
        {
           String[] temp = data.split(" ");
            for (String s : temp) {

                char [] chars = s.toCharArray();
                int len = chars.length;
                int count = 0;
                for (char aChar : chars) {


                    if (Character.isDigit(aChar)) {
                        count++;
                    }
                }

                      if (count < len && count > 0) {
                          writer.write(s + " ");
                      }




            }


        }
        reader.close();
        writer.close();



    }
}
