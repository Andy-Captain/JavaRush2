package com.ua.test.my.test;

/**
 * Created by Dmitriy on 12.05.2015.
 */
public class MyTestApp1 {
    public static void main(String[] args) {

        A1 ref = new B1();

        System.out.println(ref.equals(new B1()));
    }

}

class A1{

    @Override
    public boolean equals(Object obj) {
        System.out.println("A1 : ");
        return false;
    }
}
class B1 extends A1{


        public boolean equals(B1 obj) {
            System.out.println("B1 : ");
            return false;
        }

}