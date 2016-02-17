package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
   private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString()  {

        String word = null;
        try {
            word = reader.readLine();
        } catch (IOException e) {

        }

        return word;
    }
    public static String askCurrencyCode() throws IOException {

        String codeValut = "";
        writeMessage("Enter the currency code(3 symbols): ");
        codeValut = readString();
        while (codeValut.length() != 3)
        {


            writeMessage("You've entered wrong code. Try again:");
            codeValut = readString();

        }
         codeValut = codeValut.toUpperCase();
        return codeValut;
    }

    public static  String[] getValidTwoDigits(String currencyCode) throws IOException {

         String [] arrayTwoDigital;
        writeMessage("Input denomination and count, please:");
        while (true) {

            String twoDigital = readString();

            arrayTwoDigital = twoDigital.split(" ");

            int k;
            int l;
            try
            {
                k = Integer.parseInt(arrayTwoDigital[0]);
                l = Integer.parseInt(arrayTwoDigital[1]);
                if (k <= 0 || l <= 0 || arrayTwoDigital.length > 2)
                {
                    writeMessage("Incorrect input! Retry input, please:");
                    continue;
                }
                else break;



            }
            catch (Exception e)
            {
                writeMessage("invalid.data");

            }


        }
        return arrayTwoDigital;
    }

}
