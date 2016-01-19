package com.ua.test;

import com.ua.test.tree.node.test2.Node2;

import java.util.NoSuchElementException;

/**
 * Created by Dmitriy on 06.04.2015.
 */

 class TestTreeNode3{
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(5);
        tree.insert(8);
        tree.insert(10);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);
        tree.insert(45);
        System.out.println(tree.show2());


    }

}

 class Node3 {
         int data;
         Node3 left;
         Node3 right;
         Node3 parent;

        public int getData() {
            return this.data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node3 getLeft() {
            return this.left;
        }

        public void setLeft(Node3 left) {
            this.left = left;
        }

        public Node3 getRight() {
            return this.right;
        }

        public void setRight(Node3 right) {
            this.right = right;
        }

        public Node3 getParent() {
            return this.parent;
        }

        public void setParent(Node3 parent) {
            this.parent = parent;
        }






}
 class Tree {
    private Node3 root;

    public Tree() {
        this.root = null;
    }

     public void insert(int data) {
         root = insert(root, data, null);
     }

     private Node3 insert(Node3 current, int data, Node3 parent) {
         if (current == null) {
             current = new Node3();
             current.setData(data);
             current.setLeft(null);
             current.setRight(null);
             current.setParent(parent);
         } else if (data < current.getData()) {
             current.setLeft(insert(current.getLeft(), data, current));
         } else {
             current.setRight(insert(current.getRight(), data, current));
         }
         return current;
     }
     public String show2()
     {
        String s = show(root);
         return s;
     }

     private String show(Node3 root)
     {    Node3 tmp = root;
         String s = "";

            while (tmp != null)
         {
             s+= " "+tmp.data  ;
              tmp = tmp.right;
         }

         return s;

     }


}
class TreeIterator{
  private Node3 next;

  public TreeIterator(Node3 root){
     next = root;
     if(next == null)
       return;
     while (next.left != null)
       next = next.left;
  }

  public boolean hasNext(){
     return next != null;
  }

  public Node3 next(){
     if(!hasNext()) throw new NoSuchElementException();



     Node3 r = next;
     // if you can walk right, walk right, then fully left.
     // otherwise, walk up until you come from left.
     if(next.right != null){
       next = next.right;
       while (next.left != null)
         next = next.left;
       return r;
     }else while(true){
       if(next.parent == null){
         next = null;
         return r;
       }
       if(next.parent.left == next){
         next = next.parent;
         return r;
       }
       next = next.parent;
     }
   }
 }