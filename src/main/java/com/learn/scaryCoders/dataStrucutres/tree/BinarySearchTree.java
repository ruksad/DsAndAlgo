package com.learn.scaryCoders.dataStrucutres.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Left of the root is smaller than the root and right of the root is greater
 *
 * Let us create following BST
 *                 50
 *              /     \
 *             30      70
 *            /  \    /  \
 *          20   40  60   80
 *
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
                if (temp.left == null) {
                    temp.left = new Node(data, null, null);
                    return temp.left;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = new Node(data, null, null);
                    return temp.right;
                }
                temp = temp.right;
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

    private int findMin() {
        Node temp = root;
        while (root!=null && temp.left != null) {
            temp = temp.left;
        }
        return temp.data;
    }

    private int findMaximum(){
        Node temp= root;
        while(temp.right!=null){
            temp=temp.right;
        }
        return temp.data;
    }

    private void preOrderTraversal(Node root, LinkedList<Integer> list) {
        if (root != null) {
            list.add(root.data);
            preOrderTraversal(root.left, list);
            preOrderTraversal(root.right, list);
        }
    }

    private void inOrderTraversal(Node root, LinkedList<Integer> list) {
        if (root != null) {
            inOrderTraversal(root.left, list);
            list.add(root.data);
            inOrderTraversal(root.right, list);
        }
    }

    private void postOrderTraversal(Node root, LinkedList<Integer> list) {
        if (root != null) {
            postOrderTraversal(root.left, list);
            postOrderTraversal(root.right, list);
            list.add(root.data);
        }
    }

    private int height(Node node) {
        if (node == null)
            return 0;
        else {
            int lDepth = height(node.left);
            int rDepth = height(node.right);

            if (lDepth > rDepth)
                return lDepth + 1;
            else
                return rDepth + 1;
        }
    }

    private void fetchNodesAtGivenLevel(Node node, int level, List<Integer> ints){
        if(root==null)
            return ;
        else if(level==1){
            ints.add(node.data);
        }else if(level >1) {
            fetchNodesAtGivenLevel(node.left,level-1,ints);
            fetchNodesAtGivenLevel(node.right,level-1,ints);
        }
    }

    private List<Integer> fetchLevelOrder(Node node){
        if(node==null)
            return Collections.EMPTY_LIST;
        List<Integer> list= new ArrayList<>();
        int height=height(node);
        for(int i=1;i<=height;i++){
            fetchNodesAtGivenLevel(node,i,list);
        }
        return  list;
    }

    private void printAllLeafNodes(Node node,List<Integer> ints){
        if(node==null)
            return ;

        if(node.left==null && node.right==null){
            ints.add(node.data);
        }

        if(node.left!=null){
            printAllLeafNodes(node.left,ints);
        }
        if(node.right!=null){
            printAllLeafNodes(node.right,ints);
        }
    }

    private void printAllNonLeafNode(Node node,List<Integer> ints){
        if(root==null || (node.left==null && node.right==null))
            return ;

        ints.add(node.data);
        printAllNonLeafNode(node.left,ints);
        printAllNonLeafNode(node.right,ints);
    }


    // Function that returns the node with minimum
    // key value found in that tree
    static Node minValueNode(Node node)
    {
        Node current = node;

        // Loop down to find the leftmost leaf
        while (current != null && current.left != null)
            current = current.left;

        return current;
    }

    // Function that deletes the key and
    // returns the new root
    static Node deleteNode(Node root, int key)
    {
        // base Case
        if (root == null)
            return root;

        // If the key to be deleted is
        // smaller than the root's key,
        // then it lies in left subtree
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        }

        // If the key to be deleted is
        // greater than the root's key,
        // then it lies in right subtree
        else if (key > root.data) {

            root.right = deleteNode(root.right, key);
        }

        // If key is same as root's key,
        // then this is the node
        // to be deleted
        else {

            // Node with only one child
            // or no child
            if (root.left == null) {
                Node temp = root.right;
                return temp;
            }
            else if (root.right == null) {
                Node temp = root.left;
                return temp;
            }

            // Node with two children:
            // Get the inorder successor(smallest
            // in the right subtree)
            Node temp = minValueNode(root.right);

            // Copy the inorder successor's
            // content to this node
            root.data = temp.data;

            // Delete the inorder successor
            root.right = deleteNode(root.right, temp.data);
        }
        return root;
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        System.out.println(bst.findMin());
        LinkedList<Integer> inOrder = new LinkedList<>();
        bst.inOrderTraversal(bst.root, inOrder);
        System.out.println("Inorder= " + inOrder);

        LinkedList<Integer> preOrder = new LinkedList<>();
        bst.preOrderTraversal(bst.root, preOrder);
        System.out.println("Preorder= " + preOrder);

        LinkedList<Integer> postOrder = new LinkedList<>();
        bst.postOrderTraversal(bst.root, postOrder);
        System.out.println("PostOrder= " + postOrder);

        System.out.println("BST height= " + bst.height(bst.root));
        List<Integer> ints = new ArrayList<>();
        bst.fetchNodesAtGivenLevel(bst.root,3,ints);
        System.out.println("Print nodes at level"+ ints);

        List<Integer> integers = bst.fetchLevelOrder(bst.root);
        System.out.println("Print nodes level order= "+ integers);

        List<Integer> leafNode=new ArrayList<>();
        bst.printAllLeafNodes(bst.root,leafNode);
        System.out.println("Print nodes at leaf level="+ leafNode);

        List<Integer> nonLeafNode=new ArrayList<>();
        bst.printAllNonLeafNode(bst.root,nonLeafNode);
        System.out.println("Print nodes at non leaf level="+ nonLeafNode);

        Node node = deleteNode(bst.root, 70);

        LinkedList<Integer> inOrder1 = new LinkedList<>();
        bst.inOrderTraversal(bst.root, inOrder1);
        System.out.println("Inorder= " + inOrder1);

    }
}
