package com.learn.scaryCoders.dataStrucutres.tree;

import com.learn.scaryCoders.dataStrucutres.DoublyLinkedList;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public Node insert(int data) {
        if (root == null) {
            root = new Node(data, null, null);
            return root;
        }
        Node temp = root;
        while (true) {
            if (data > temp.data) {
                temp=temp.left;
                if(temp.left==null){
                    temp.left= new Node(data,null,null);
                }
            }else{

            }
        }
    }

    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
