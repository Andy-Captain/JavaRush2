package com.javarush.test.level20.lesson10.home02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable{
    private static final long serialVersionUID = 123456789L;
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException {

           Object a1 = objectStream.readObject();
        if (a1 instanceof B)
        {
          B b = (B)a1;
            return b;
        }

        return (A)a1;
    }

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }
}
