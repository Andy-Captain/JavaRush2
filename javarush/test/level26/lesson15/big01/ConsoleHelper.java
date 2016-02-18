package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {

        String word = null;
        try {
            word = reader.readLine();
            if (word.toLowerCase().equalsIgnoreCase(Operation.EXIT.toString().toLowerCase()))
                            throw new InterruptOperationException();
        } catch (IOException e) {

        }

        return word;
    }

    public static String askCurrencyCode() throws  InterruptOperationException {

        String codeValut = "";
        writeMessage("Enter the currency code(3 symbols): ");
        codeValut = readString();
        while (codeValut.length() != 3) {


            writeMessage("You've entered wrong code. Try again:");
            codeValut = readString();

        }
        codeValut = codeValut.toUpperCase();
        return codeValut;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws  InterruptOperationException {

        String[] arrayTwoDigital;
        writeMessage("Input denomination and count, please:");
        while (true) {

            String twoDigital = readString();

            arrayTwoDigital = twoDigital.split(" ");

            int k;
            int l;
            try {
                k = Integer.parseInt(arrayTwoDigital[0]);
                l = Integer.parseInt(arrayTwoDigital[1]);
                if (k <= 0 || l <= 0 || arrayTwoDigital.length > 2) {
                    writeMessage("Incorrect input! Retry input, please:");
                    continue;
                } else break;


            } catch (Exception e) {
                writeMessage("invalid.data");

            }


        }
        return arrayTwoDigital;
    }

    public static Operation askOperation() throws InterruptOperationException {

        writeMessage("Enter the operation: 1 -INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT; ");
        while (true) {
            String s = readString();
            int choise = Integer.parseInt(s);
            if (choise > 0 && choise < 5) {
                return Operation.getAllowableOperationByOrdinal(choise);
            } else {
                writeMessage("Incorrect input! Retry input, please:");
            }

        }

    }


}
