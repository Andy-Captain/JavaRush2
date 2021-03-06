package com.ua.test.Ttree.node.test;

/**
 * Created by Dmitriy on 07.04.2015.
 */
public class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }


    public void insert(int data) {
        root = insert(root, data, null);
    }

    private Node insert(Node current, int data, Node parent) {
        if (current == null) {
            current = new Node();
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

    public Node find(int data) {
        return find(root, data);
    }

    private Node find(Node current, int data) {
        if (current == null)
            return null;
        if (current.getData() == data)
            return current;
        return find(
                data < current.getData() ? current.getLeft()
                        : current.getRight(), data);
    }


    public Node findMin(Node right) {
        Node min = root;
        if (min == null) return null;
        while (min.getLeft() != null) {
            min = min.getLeft();
        }
        return min;
    }



    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node startNode, int data) {
        Node element = find(startNode, data);
        if (element == null) return startNode;
        boolean hasParent = element.getParent() != null;
        boolean isLeft = hasParent && element.getData() < element.getParent().getData();
        if (element.getLeft() == null && element.getRight() == null) {
            if (hasParent) {
                if (isLeft) {
                    element.getParent().setLeft(null);
                } else {
                    element.getParent().setRight(null);
                }
            }
        } else if (element.getLeft() != null && element.getRight() == null) {
            if (hasParent) {
                if (isLeft) {
                    element.getParent().setLeft(element.getLeft());
                } else {
                    element.getParent().setRight(element.getLeft());
                }
            } else {
                startNode = element.getLeft();
            }
        } else if (element.getLeft() == null && element.getRight() != null) {
            if (hasParent) {
                if (isLeft) {
                    element.getParent().setLeft(element.getRight());
                } else {
                    element.getParent().setRight(element.getRight());
                }
            } else {
                startNode = element.getRight();
            }
        } else {
            Node rightMin = findMin(element.getRight());
            element.setData(rightMin.getData());
            return delete(rightMin, rightMin.getData());
        }
        element = null;
        return startNode;
    }

    @Override
    public String toString() {
        if (root == null)
        {
            return "";
        }
         else
        {
            String left = (root.getLeft() == null ? "PUSTO" : root.getLeft().getData() + "");
            String right = (root.getRight() == null ? "PUSTO" : root.getRight().getData() + "");
           String s =
                   "ROOT = "+ root.getData()  + " Left = "+ left + " Right = " + right;

           return s;
        }

    }

    //    public void traverseTree(TraverseType traverseType) {
//        traverseTree(root, traverseType);
//        System.out.println();
//    }
//
//    private void traverseTree(Node current, TraverseType traverseType) {
//        if (current == null)
//            return;
//        switch (traverseType) {
//        case INORDER:
//            traverseTree(current.getLeft(), traverseType);
//            processNode(current);
//            traverseTree(current.getRight(), traverseType);
//            break;
//        case PREORDER:
//            processNode(current);
//            traverseTree(current.getLeft(), traverseType);
//            traverseTree(current.getRight(), traverseType);
//            break;
//        case POSTORDER:
//            traverseTree(current.getLeft(), traverseType);
//            traverseTree(current.getRight(), traverseType);
//            processNode(current);
//            break;
//        }
//    }

}