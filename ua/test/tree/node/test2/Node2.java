package com.ua.test.tree.node.test2;

import java.util.NoSuchElementException;

/**
 * Created by Dmitriy on 07.04.2015.
 */
public class Node2 {
        Integer data;
        Node2 left;
        Node2 right;
        Node2 root;

    public Node2(Node2 left, Integer data, Node2 right) {
        this.left = left;
        this.data = data;
        this.right = right;
    }


    public  String toString(Node2 root) {
        Node2  next = root;
        String s ="";
        if (next == null)
        {
            return "";
        }
       if (next != null)
        {
          s += root.data;
            root = root.right;
        }

        return s;
    }
}


 class TreeNode2
 {

     public static void main(String[] args) {

         Node2 root = new Node2(null,0,null);
         root.left = new Node2(null,1,null);
         root.right = new Node2(null,2,null);
         Node2 root3 = new Node2(null,3,null);
         Node2 root4 = new Node2(null,4,null);
         Node2 root5 = new Node2(null,5,null);


         System.out.println(root.toString(root));


     }



 }