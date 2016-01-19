package com.javarush.test.level25.lesson05.home01;

public class LoggingStateThread extends Thread{
    Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
        setDaemon(true);
    }

    @Override
    public void run() {
        State curState = this.target.getState();
        System.out.println(curState);
        while (curState  != State.TERMINATED) {

            if (curState != this.target.getState())
            {
                curState = this.target.getState();
                System.out.println(curState);
            }


        }

    }
}
