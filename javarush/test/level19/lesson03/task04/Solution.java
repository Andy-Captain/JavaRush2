package com.javarush.test.level19.lesson03.task04;


import java.io.IOException;
import java.util.*;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {

            String s = "";
            if (scanner.hasNextLine())
            {
                s = scanner.nextLine();
            }
            String [] data = s.split(" ");
            int day = Integer.parseInt(data[3]);
            int month = Integer.parseInt(data[4]);
            int year = Integer.parseInt(data[5]);

            Calendar calendar = new GregorianCalendar(year,month-1,day);

             Date date = calendar.getTime();

            Person person = new Person(data[1],data[2],data[0],date);
            return person;
        }

        @Override
        public void close() throws IOException {
           scanner.close();
        }
    }



}
