package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Dmitriy on 11.01.2016.
 */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {


        for (int i = 1; i < 10; i++) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            System.out.format("Элемент 'ShareItem-%d' добавлен", i);
            System.out.println();
            queue.offer(new ShareItem("ShareItem-" + i, i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {

            }
            if (queue.hasWaitingConsumer()) {
                System.out.println("Consumer в ожидании!");
            }
        }


    }
}