package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
public class Solution {

    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
        public A( ) {   }


    }

    public  class B extends A implements Serializable {
        static final long serialVersionUID = 1L;
        public B(String name) {
            super(name);
            this.name += name;
        }
        private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {

                    name = (String)s.readObject();
                }
                private void writeObject(ObjectOutputStream s) throws IOException {

                    s.writeObject(name);
                }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        B b1 = new Solution().new B("#1");
        System.out.println(b1.name);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\1.tmp"));
        oos.writeObject(b1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\1.tmp"));
        B b2 =  new Solution().new B("#2");
        System.out.println(b2.name);
           b2=     (B) ois.readObject();
        ois.close();
        System.out.println(b2.name);






    }

}
