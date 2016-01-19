package com.ua.test.thread.test.test2;

/**
 * Created by Dmitriy on 18.05.2015.
 */
class Consumer implements Runnable {
  Q q;

  Consumer(Q q) {
    this.q = q;
    new Thread(this, "Consumer").start();
  }

  public void run() {
      int i = 0;
    while(i < 10000) {
      q.get();
    }
  }
}
