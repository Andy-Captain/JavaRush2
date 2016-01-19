package com.ua.test.thread.test.test2;

/**
 * Created by Dmitriy on 18.05.2015.
 */
class PCFixed {
  public static void main(String args[]) {
    Q q = new Q();
    new Producer(q);
    new Consumer(q);

    System.out.println("Press Control-C to stop.");
  }
}