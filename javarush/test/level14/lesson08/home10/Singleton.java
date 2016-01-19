package com.javarush.test.level14.lesson08.home10;

/**
 * Created by Dmitriy on 30.10.2014.
 */
public class Singleton
{
    private static Singleton instance ;

       private Singleton()
        {
        }

        public static  Singleton getInstance()
        {
              if (instance == null)
              {
                  instance = new Singleton();
              }

            return instance;
        }
}
