package com.ua.test.thread.test.test2;

/**
 * Created by Dmitriy on 18.05.2015.
 */
class Q {
  int n;
  boolean valueSet = false;

  synchronized int get() {
    while(!valueSet)

      try {
        wait();

      } catch(InterruptedException e) {
        System.out.println("InterruptedException caught");
      }

      System.out.println("Получено: " + n);
      valueSet = false;
      notify();
      return n;
  }

  synchronized void put(int n) {
    while(valueSet)

      try {
        wait();
      } catch(InterruptedException e) {
        System.out.println("InterruptedException caught");
      }

      this.n = n;
      valueSet = true;
      System.out.println("1");
      System.out.println("Отправлено: " + n);
      notify();
  }
}