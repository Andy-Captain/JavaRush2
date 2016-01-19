package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dmitriy on 24.06.2015.
 */
public class ConsoleHelper {
    static BufferedReader reader;
    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException {
         reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();

        return word;
    }
    public static String askCurrencyCode() throws IOException {

        String codeValut = "";

        while (true)
        {
            codeValut = readString();
            if (codeValut.length() == 3)
                break;
            else
                writeMessage("invalid.data");

        }
         codeValut = codeValut.toUpperCase();
        return codeValut;
    }

    public static  String[] getValidTwoDigits(String currencyCode) throws IOException {

         String [] arrayTwoDigital;

        while (true) {

            String twoDigital = readString();

            arrayTwoDigital = twoDigital.split(" ");

            int k;
            int l;
            try
            {
                k = Integer.parseInt(arrayTwoDigital[0]);
                l = Integer.parseInt(arrayTwoDigital[1]);
            }
            catch (Exception e)
            {
                writeMessage("invalid.data");
                continue;
            }
            if (k <= 0 || l <= 0 || arrayTwoDigital.length > 2)
            {
                writeMessage("invalid.data");
                continue;
            }
            break;

        }
        return arrayTwoDigital;
    }

}
