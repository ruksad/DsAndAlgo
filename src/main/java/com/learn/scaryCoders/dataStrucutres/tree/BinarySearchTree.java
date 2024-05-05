package com.learn.scaryCoders.dataStrucutres.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Left of the root is smaller than the root and right of the root is greater
 * <p>
 * Let us create following BST
 * 50
 * /     \
 * 30      70
 * /  \    /  \
 * 20   40  60   80
 */
public class BinarySearchTree {

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

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data, null, null);
            return;
        }
        Node tree = root;

        while (true) {
            if (data < tree.data) {
                if (tree.left == null) {
                    tree.left = new Node(data, null, null);
                    return;
                }
                tree = tree.left;
            } else {
                if (tree.right == null) {
                    tree.right = new Node(data, null, null);
                    return;
                }
                tree = tree.right;
            }
        }
    }

    public Node lookup(Node root, int data) {
        if (root == null)
            return null;

        if (root.data == data)
            return root;


        if (data < root.data)
            return lookup(root.left, data);
        else
            return lookup(root.right, data);

    }


    private int findMin(Node temp) {
        while (root != null && temp.left != null) {
            temp = temp.left;
        }
        return temp.data;
    }

    private int findMaximum(Node temp) {
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp.data;
    }

    private void preOrderTraversal(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.data);
            preOrderTraversal(root.left, list);
            preOrderTraversal(root.right, list);
        }
    }

    private void inOrderTraversal(Node root, List<Integer> list) {
        if (root != null) {
            inOrderTraversal(root.left, list);
            list.add(root.data);
            inOrderTraversal(root.right, list);
        }
    }

    private void postOrderTraversal(Node root, List<Integer> list) {
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

    private void fetchNodesAtGivenLevel(Node node, int level, List<Integer> ints) {
        if (root == null)
            return;
        else if (level == 1) {
            ints.add(node.data);
        } else if (level > 1) {
            fetchNodesAtGivenLevel(node.left, level - 1, ints);
            fetchNodesAtGivenLevel(node.right, level - 1, ints);
        }
    }

    private List<Integer> fetchLevelOrder(Node node) {
        if (node == null)
            return Collections.EMPTY_LIST;
        List<Integer> list = new ArrayList<>();
        int height = height(node);
        for (int i = 1; i <= height; i++) {
            fetchNodesAtGivenLevel(node, i, list);
        }
        return list;
    }

    private void printAllLeafNodes(Node node, List<Integer> ints) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            ints.add(node.data);
        }

        if (node.left != null) {
            printAllLeafNodes(node.left, ints);
        }
        if (node.right != null) {
            printAllLeafNodes(node.right, ints);
        }
    }

    private void printAllNonLeafNode(Node node, List<Integer> ints) {
        if (root == null || (node.left == null && node.right == null))
            return;

        ints.add(node.data);
        printAllNonLeafNode(node.left, ints);
        printAllNonLeafNode(node.right, ints);
    }


    // Function that returns the node with minimum
    // key value found in that tree
    static Node minValueNode(Node node) {
        Node current = node;

        // Loop down to find the leftmost leaf
        while (current != null && current.left != null)
            current = current.left;

        return current;
    }

    public void deleteNodeNonRecursive(int value) {
        if (root == null) {
            return;
        }

        Node currentNode = root;
        Node parentNode = null;

        while (currentNode != null) {
            if (value < currentNode.data) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else if (value > currentNode.data) {
                parentNode = currentNode;
                currentNode = currentNode.right;
            } else {
                // We have a match, get to work!

                // Option 1: No right child
                if (currentNode.right == null) {
                    if (parentNode == null) {
                        root = currentNode.left;
                    } else {
                        if (currentNode.data < parentNode.data) {
                            parentNode.left = currentNode.left;
                        } else {
                            parentNode.right = currentNode.left;
                        }
                    }
                }
                // Option 2: Right child which doesn't have a left child
                else if (currentNode.right.left == null) {
                    currentNode.right.left = currentNode.left;
                    if (parentNode == null) {
                        root = currentNode.right;
                    } else {
                        if (currentNode.data < parentNode.data) {
                            parentNode.left = currentNode.right;
                        } else {
                            parentNode.right = currentNode.right;
                        }
                    }
                }
                // Option 3: Right child that has a left child
                else {
                    Node leftmost = currentNode.right.left;
                    Node leftmostParent = currentNode.right;

                    while (leftmost.left != null) {
                        leftmostParent = leftmost;
                        leftmost = leftmost.left;
                    }

                    leftmostParent.left = leftmost.right;
                    leftmost.left = currentNode.left;
                    leftmost.right = currentNode.right;

                    if (parentNode == null) {
                        root = leftmost;
                    } else {
                        if (currentNode.data < parentNode.data) {
                            parentNode.left = leftmost;
                        } else {
                            parentNode.right = leftmost;
                        }
                    }
                }
                return;
            }
        }
    }

    // Function that deletes the key and
    // returns the new root
    static Node deleteNodeRecursive(Node root, int key) {
        // base Case
        if (root == null)
            return root;

        // If the key to be deleted is
        // smaller than the root's key,
        // then it lies in left subtree
        if (key < root.data) {
            root.left = deleteNodeRecursive(root.left, key);
        }

        // If the key to be deleted is
        // greater than the root's key,
        // then it lies in right subtree
        else if (key > root.data) {

            root.right = deleteNodeRecursive(root.right, key);
        }

        // If key is same as root's key,
        // then this is the node
        // to be deleted
        else {

            // Node with only one child
            // or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children:
            // Get the inorder successor(smallest
            // in the right subtree)
            Node temp = minValueNode(root.right);

            // Copy the inorder successor's
            // content to this node
            root.data = temp.data;

            // Delete the inorder successor
            root.right = deleteNodeRecursive(root.right, temp.data);
        }
        return root;
    }

    public boolean isBst(Node root) {
        if (root == null)
            return true;

        if (root.left != null && root.data < findMaximum(root.left))
            return false;

        if (root.right != null && root.data > findMin(root.right))
            return false;

        return isBst(root.right) && isBst(root.left);
    }

    public boolean remove(int value) {

        if (this.root == null) {
            return false;
        }
        Node currentNode = root;
        Node parentNode = null;

        while (currentNode != null) {

            if (value < currentNode.data) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else if (value > currentNode.data) {
                parentNode = currentNode;
                currentNode = currentNode.right;
            } else {

                if (currentNode.right == null) {

                    if (parentNode == null) {
                        root = currentNode.left;
                    } else {
                        if (currentNode.data < parentNode.data) {
                            parentNode.left = currentNode.left;
                        } else {
                            parentNode.right = currentNode.left;
                        }
                    }
                    return true;

                } else if (currentNode.right.left == null) {
                    currentNode.right.left = currentNode.left;
                    if (parentNode == null) {
                        root = currentNode.right;
                    } else {
                        if (currentNode.data < parentNode.data) {
                            parentNode.left = currentNode.right;
                        } else {
                            parentNode.right = currentNode.right;
                        }
                    }
                    return true;

                } else {

                    Node leftMostParent = currentNode.right;
                    Node leftMost = currentNode.right.left;

                    while (leftMost.left != null) {
                        leftMostParent = leftMostParent.left;
                        leftMost = leftMost.left;
                    }

                    leftMostParent.left = leftMost.right;

                    leftMost.right = currentNode.right;
                    leftMost.left = currentNode.left;

                    if (parentNode == null) {
                        root = leftMost;
                    } else {
                        if (currentNode.data < parentNode.data) {
                            parentNode.left = leftMost;
                        } else {
                            parentNode.right = leftMost;
                        }
                    }
                    return true;

                }

            }

        }
        return false;
    }

    /*public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        System.out.println(bst.findMin(bst.root));
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
        bst.fetchNodesAtGivenLevel(bst.root, 3, ints);
        System.out.println("Print nodes at level" + ints);

        List<Integer> integers = bst.fetchLevelOrder(bst.root);
        System.out.println("Print nodes level order= " + integers);

        List<Integer> leafNode = new ArrayList<>();
        bst.printAllLeafNodes(bst.root, leafNode);
        System.out.println("Print nodes at leaf level=" + leafNode);

        List<Integer> nonLeafNode = new ArrayList<>();
        bst.printAllNonLeafNode(bst.root, nonLeafNode);
        System.out.println("Print nodes at non leaf level=" + nonLeafNode);

        //Node node = deleteNode(bst.root, 70);

        LinkedList<Integer> inOrder1 = new LinkedList<>();
        bst.inOrderTraversal(bst.root, inOrder1);
        System.out.println("Inorder= " + inOrder1);

        Node lookup = bst.lookup(bst.root, 2000);
        System.out.println("find in root " + ((lookup == null) ? null : lookup.data));

        bst.deleteNodeNonRecursive(40);
        System.out.println(bst);

    }*/

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);

        bst.insert(70);
        bst.insert(75);
        bst.insert(74);
        bst.insert(80);
        bst.insert(71);
        bst.insert(72);
        bst.insert(82);

        bst.insert(67);
        bst.insert(63);
        bst.insert(69);
        bst.insert(68);
        bst.insert(61);
        bst.insert(64);

        bst.remove(70);
        List<Integer> data = new ArrayList<>();
        bst.inOrderTraversal(bst.root,data);
        System.out.println("Is BST: "+bst.isBst(bst.root));


    }
}
