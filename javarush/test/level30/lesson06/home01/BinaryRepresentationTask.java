package com.javarush.test.level30.lesson06.home01;


import java.util.concurrent.RecursiveTask;

/**
 * Created by Dmitriy on 11.01.2016.
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int binary;

    public BinaryRepresentationTask(int binary) {
        this.binary = binary;
    }

    @Override
    protected String compute() {

        int a = binary % 2;
        int b = binary / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork();
            return task.join() + result;
        }

        return result;
    }
}
