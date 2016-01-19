package com.ua.test.my.test;

/**
 * Created by Dmitriy on 08.05.2015.
 */
public class MytestApp0 {
    public static void main(String[] args) {

       C ref = new C();
        ref.f();

    }
}


class A{

    public void f(){
        System.out.println("A : f()");
    }
    public void g(){
        System.out.println("A : g()");
    }
    public void h(){
        System.out.println("A : h()");
    }


}
class B extends A{

    public void f(){
            System.out.println("B : f()");
        }
    public void g(){
            System.out.println("B : g()");
        }

}
class C extends B
{

    public void h(){
            System.out.println("C : h()");
        }

}