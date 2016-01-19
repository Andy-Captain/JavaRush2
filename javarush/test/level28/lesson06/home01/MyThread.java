package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Dmitriy on 08.12.2015.
 */
public class MyThread extends Thread{

 public static AtomicInteger priority = new AtomicInteger(1);

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        setPriority();
    }

    public MyThread()
    {
        super();
        setPriority();
    }

    public MyThread(Runnable target)
    {
        super(target);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        setPriority();
    }

    public MyThread(String name)
    {
        super(name);
        setPriority();
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        setPriority();
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
     setPriority();
    }

    private  void setPriority()
    {
        setPriority(priority.get());

        if (priority.get() == 10) priority.set(0);
                priority.incrementAndGet();
    }

}
