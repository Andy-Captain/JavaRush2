package com.javarush.test.level32.lesson04.home01;

import java.io.*;

/* Читаем из потока
Реализуйте логику метода getAllDataFromInputStream.
Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("D:\\temp\\zzz.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) {
        if (is == null) {
            return new StringWriter();
        }
        InputStreamReader reader = new InputStreamReader(is);
        StringWriter sw = new StringWriter();

        int data = 0;
        try {
            data = reader.read();

            char content;

            while (data != -1) {

                content = (char) data;
                sw.append(content);


                data = reader.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return sw;
    }
}
