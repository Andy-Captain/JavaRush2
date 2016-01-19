package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {

        String fileNameInput;
        String fileNameoutput;

        if (args.length < 2)
        {
             return;

        }
        else
        {
            fileNameInput = args[0];
            fileNameoutput = args[1];
        }


        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileNameInput)));
        BufferedWriter outputStreamWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileNameoutput)));


       String data;
         while ((data= inputStreamReader.readLine()) != null)
         {
             byte[] bytes =  data.getBytes(Charset.forName("Windows-1251"));
             String dataUTF8 = new String(bytes,Charset.forName("UTF-8"));

             System.out.println(dataUTF8);

            outputStreamWriter.write(dataUTF8);


         }
         inputStreamReader.close();
        outputStreamWriter.close();







    }
}
