package com.learn.scaryCoders.dataStrucutres.stack;

import com.learn.scaryCoders.dataStrucutres.DoublyLinkedList;

import java.util.Iterator;

public class Stack<T> {
    private final DoublyLinkedList<T> dll;

    public Stack() {
        dll = new DoublyLinkedList<>();
    }

    public boolean push(T data) {
        return dll.add(data);
    }

    public T pop() {
        return dll.removeAt(dll.size() - 1);
    }

    public T peek() {
        return dll.elementAtTail();
    }

    public T peekAt(int index){
        return dll.elementAt(index);
    }

    public boolean isEmpty() {
        return dll.isEmpty();
    }

    public int size() {
        return dll.size();
    }

    public String print() {
        Iterator<T> iterator = this.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next()+",");
        }
        return sb.toString();
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int length = dll.size();

            public boolean hasNext() {
                return length > 0;
            }

            public T next() {
                T data = peekAt(--length);
                return data;
            }
        };
    }

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(10);
        integerStack.push(20);
        integerStack.push(30);
        System.out.println(integerStack.print());
        System.out.println(integerStack.pop() + " " + integerStack.pop() + " " + integerStack.isEmpty());
    }
}
