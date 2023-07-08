package com.learn.scaryCoders.dataStrucutres;

import java.util.Iterator;
import java.util.Objects;

public class DoublyLinkedList<T> {
    private Node<T> head, tail;
    private int length;

    public DoublyLinkedList() {
    }

    public boolean add(T data) {
        if (Objects.isNull(data))
            return false;

        Node<T> node = new Node<>(data, null, null);
        if (head == null) {
            this.head = this.tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        length++;
        return true;
    }

    public boolean addAt(T data, int index) {
        if (Objects.isNull(data))
            return false;
        if (index > length && index < 0) {
            throw new IllegalArgumentException("index is out of bound");
        }

        Node tNode = new Node(data, null, null);
        if (head == tail || index == length - 1) {
            return add(data);
        }

        Node<T> temp = head;
        int count = 0;

        while (temp != null) {

            if (count == index) {
                if (temp.prev != null) {
                    tNode.prev = temp.prev;
                    tNode.next = temp;
                    temp.prev.next = tNode;
                    temp.prev = tNode;
                } else {
                    tNode.next = temp;
                    temp.prev = tNode;
                    head = tNode;
                }
                length++;
                return true;
            }
            count++;
            temp = temp.next;
        }
        return false;
    }


    public T remove(T data) {
        Node<T> temp = head;

        while (temp != null) {

            if (temp.data.equals(data)) {

                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                length--;
                temp.prev = null;
                temp.next = null;
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    public T removeAt(int index) {
        if (index > length - 1 && index < 0) {
            throw new IllegalArgumentException("Index is out of bounds");
        }

        Node<T> temp = head;
        int count = 0;

        while (temp != null) {
            if (count == index) {

                if (temp.prev != null && temp.next != null) {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                } else {
                    if (temp.prev == null) {
                        head = temp.next;
                        head.prev = null;
                    } else {
                        tail = temp.prev;
                        tail.next = null;
                    }
                }
                temp.next = null;
                temp.prev = null;
                length--;
                return temp.data;
            }
            count++;
            temp = temp.next;
        }
        return null;
    }

    public T elementAtTail(){
        if(tail==null)
            return null;
        return tail.data;
    }

    public T elementAtHead(){
        if(head==null)
            return null;
        return head.data;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    public String print(){
        StringBuilder sb=new StringBuilder();
        Iterator<T> iterator = this.iterator();
        while(iterator.hasNext()){
            T data= iterator.next();
            sb.append(data+" ,");
        }
        return sb.toString();
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> temp = head;
            private int len = length;

            @Override
            public boolean hasNext() {
                return len > 0;
            }

            @Override
            public T next() {
                T data = temp.data;
                temp = temp.next;
                len--;
                return data;
            }
        };
    }

    private class Node<T> {
        final T data;
        Node<T> next;
        Node<T> prev;

        Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String s[]){
        DoublyLinkedList<String> dll = new DoublyLinkedList<>();
        dll.add("Ruksad");
        dll.add("Siddiqui");
        System.out.println(dll.print());
        dll.removeAt(1);
        System.out.println(dll.print());
        dll.addAt("Samuel",1);
        dll.addAt("Derric",0);

        System.out.println(dll.print());
    }
}
