package com.ua.test.my.test;

/**
 * Created by Dmitriy on 08.05.2015.
 */
public abstract class OuterClassTest {
    private final static int s = 1000;
    private final int h = 2000;
    int d;

    void f(){
        System.out.println(s);
    }

     abstract void h();
     class Nested{
       int a;
      void size(){
          final int a2 = 1000;
          System.out.println(s);
         // System.out.println(h);
          //System.out.println(d);
          System.out.println(a);

          class JJJ{

              void JJ(){

                  a++;
                  System.out.println(a2);
              }

          }


      }

    }


}
 class DDD extends OuterClassTest{


     @Override
     void h() {

     }
 }