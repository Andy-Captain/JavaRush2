package com.javarush.test.level38.lesson04.task02;

/* Непроверяемые исключения (unchecked exception)
Напиши реализацию метода methodThrowsClassCastException(). Он должен
всегда кидать непроверяемое исключение ClassCastException.

Напиши реализацию метода methodThrowsNullPointerException(). Он должен
всегда кидать непроверяемое исключение NullPointerException.

Кинуть исключение (throw) явно нельзя.
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() throws ClassCastException{
        Class<VeryComplexClass> veryComplexClassClass = VeryComplexClass.class;
        Object o = veryComplexClassClass;
        String s = (String) o;
    }

    public void methodThrowsNullPointerException() throws NullPointerException{
        String s = null;
        System.out.println(s.toLowerCase());

    }

}
