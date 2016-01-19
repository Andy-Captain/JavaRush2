package com.ua.test.my.test;

/**
 * Created by Dmitriy on 09.04.2015.
 */
public class App {

    public static void main(String[] args) {
        Node refA = new Node(1, new Node(2,new Node(3, new Node(4,null))));
        //System.out.println(refA.next.value);
        refA.next.next.next = refA.next.next;
//        System.out.println(refA.next.next.next.value);
//        System.out.println(refA.next.next.next.next.value);
//        System.out.println(refA.next.next.value);
        Node refB = refA.next.next;
        System.out.println(refB.value);

    }
}

class Node{
    int value;
    Node next;

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}