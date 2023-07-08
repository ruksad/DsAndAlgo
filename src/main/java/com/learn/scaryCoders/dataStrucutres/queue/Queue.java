package com.learn.scaryCoders.dataStrucutres.queue;

import com.learn.scaryCoders.dataStrucutres.DoublyLinkedList;

import java.util.Iterator;

public class Queue<T> {
    private final DoublyLinkedList<T> dll;
    public Queue(){
        dll=new DoublyLinkedList<T>();
    }

    public boolean enqueue(T data){
        return dll.add(data);
    }

    public T dequeue(){
        return dll.removeAt(0);
    }

    public T peek(){
        return dll.elementAtHead();
    }

    /**
     * Returns and removes the head of the queue. Returns null if the queue is empty.
     * @return
     */
    public T poll(){
        T remove = dll.removeAt(0);
        return remove;
    }

    public boolean isEmpty(){
        return dll.isEmpty();
    }

    public int size(){
        return dll.size();
    }

    public String print(){
        Iterator<T> iterator = dll.iterator();
        StringBuilder sb=new StringBuilder();

        while (iterator.hasNext()){
            sb.append(iterator.next()+" ,");
        }
        return sb.toString();
    }
    public static void main(String s[]){
        Queue<String> queue = new Queue<>();
        System.out.println(queue.peek());
        queue.enqueue("Ruksad");
        queue.enqueue("Siddiqui");
        System.out.println(queue.print());
        System.out.println(queue.dequeue());
        System.out.println(queue.print());
    }
}
