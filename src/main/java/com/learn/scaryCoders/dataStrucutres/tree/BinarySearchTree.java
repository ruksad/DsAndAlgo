package com.learn.scaryCoders.dataStrucutres.tree;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Left of the root is smaller than the root and right of the root is greater
 */
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
            if (data < temp.data) {
                if(temp.left==null){
                    temp.left= new Node(data,null,null);
                    return temp.left;
                }
                temp=temp.left;
            }else{
                if(temp.right==null){
                    temp.right= new Node(data,null,null);
                    return temp.right;
                }
                temp=temp.right;
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

    private int findMin(){
        Node temp= root;
        while(temp.left!=null){
            temp=temp.left;
        }
        return temp.data;
    }

    private void inOrderTraversal(Node root, LinkedList<Integer> list){
        if(root !=null){
            inOrderTraversal(root.left,list);
            list.add(root.data);
            inOrderTraversal(root.right,list);
        }
    }

    private void preOrderTraversal(Node root, LinkedList<Integer> list){
        if(root!=null){
            list.add(root.data);
            preOrderTraversal(root.left,list);
            preOrderTraversal(root.right,list);
        }
    }

    private void postOrderTraversal(Node root, LinkedList<Integer> list){
        if(root!=null){
            postOrderTraversal(root.left, list);
            postOrderTraversal(root.right,list);
            list.add(root.data);
        }
    }
    public static void main(String[] args) {

        BinarySearchTree bst= new BinarySearchTree();
        bst.insert(40);
        bst.insert(50);
        bst.insert(20);
        bst.insert(30);
        bst.insert(25);
        bst.insert(45);
        bst.insert(46);
        System.out.println(bst.findMin());
        LinkedList<Integer> inOrder = new LinkedList<>();
        bst.inOrderTraversal(bst.root, inOrder);
        System.out.println("Inorder= "+inOrder);

        LinkedList<Integer> preOrder = new LinkedList<>();
        bst.preOrderTraversal(bst.root, preOrder);
        System.out.println("Preorder= "+preOrder);

        LinkedList<Integer> postOrder = new LinkedList<>();
        bst.postOrderTraversal(bst.root, postOrder);
        System.out.println("PostOrder= "+postOrder);
    }
}
