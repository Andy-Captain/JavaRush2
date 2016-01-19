package com.javarush.test.level22.lesson05.home01;

import java.util.Formatter;

public class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else
            if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
                System.out.println(getFormattedStringForSecondThread(t, e, string));
            } else {
                System.out.println(getFormattedStringForOtherThread(t, e, string));
            }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {

        Formatter fm = new Formatter();
        fm.format(string,e.getClass().getSimpleName(),e.getCause(),t.getName());
        String s1 = fm.toString();
        return s1;
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {


        Formatter fm = new Formatter();
        fm.format(string,e.getCause(),e.getClass().getSimpleName(),t.getName());

        String s1 = fm.toString();


        return s1;
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        Formatter fm = new Formatter();
        fm.format(string,t.getName(),e.getClass().getSimpleName(),e.getCause());
        String s1 = fm.toString();



        return s1;
    }
}

