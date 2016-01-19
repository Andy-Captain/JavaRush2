package com.ua.test.Ttree.node.test;

/**
 * Created by Dmitriy on 07.04.2015.
 */
public class TestTree {


    public static void main(String[] args) {
        Tree node = new Tree();
        node.insert(10);
        node.insert(1);
        node.insert(2);
        node.insert(3);
        node.insert(4);
        node.insert(5);
        //node.find(3);
        System.out.println(node.find(3));

        //System.out.println(node.toString());


    }
}
