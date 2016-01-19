package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {




        if(args.length < 3) return;

        String keyWorld = "qwerty";
        String key = args[0];

        FileInputStream fis = new FileInputStream(args[1]);
        FileOutputStream fos = new FileOutputStream(args[2]);

        if (key.equals("-e"))
        {

            while (fis.available() > 0)
            {   byte [] temp = new byte[fis.available()];
               int n = fis.read(temp);

                fos.write(enDeCrypt(temp,keyWorld));

            }

        }
        else if (key.equals("-d"))
        {
           while (fis.available() > 0)
            {    byte [] temp = new byte[fis.available()];
                int n = fis.read(temp);

                fos.write(enDeCrypt(temp,keyWorld));
            }
        }
        fis.close();
        fos.close();

    }
    public static byte[] enDeCrypt(byte[] text, String keyWord)
       {
           byte[] result = new byte[text.length];
           byte[] keyarr = keyWord.getBytes();

           for(int i = 0; i< text.length; i++)
           {
               result[i] = (byte) (text[i] ^ keyarr[i % keyarr.length]);
           }
           return result;
       }

}
