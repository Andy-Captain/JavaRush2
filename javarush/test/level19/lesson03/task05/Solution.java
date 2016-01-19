package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы.
Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
         static {
             countries.put("UA","Ukraine");
             countries.put("RU","Russia");
             countries.put("CA","Canada");

         }
    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String s = customer.getCountryName();
            String s1 = "";
            for (Map.Entry<String, String> stringStringEntry : countries.entrySet()) {
                String key = stringStringEntry.getKey();
                String value = stringStringEntry.getValue();
                 if (s.equals(value))
                 {s1 = key;}
            }
            return s1;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String fullname = contact.getName();
            String [] temp = fullname.split(" ");
           String name = temp[1];

            return name;
        }

        @Override
        public String getContactLastName() {
            String fullname = contact.getName().replaceAll(",","");
            String [] temp = fullname.split(" ");
            String name = temp[0];


            return name;
        }

        @Override
        public String getDialString() {
            String phoneNumber = "callto://"+contact.getPhoneNumber().replaceAll("[()-]", "");


            return phoneNumber;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }

    public static void main(String[] args) {

        DataAdapter dataAdapter = new DataAdapter(new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        }, new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        });


    }

}