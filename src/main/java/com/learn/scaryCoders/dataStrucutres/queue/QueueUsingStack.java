package com.learn.scaryCoders.dataStrucutres.queue;

import com.learn.scaryCoders.dataStrucutres.stack.Stack;

import java.util.Iterator;

/**
 * https://www.geeksforgeeks.org/queue-using-stacks/
 *
 * @param <T>
 */
public class QueueUsingStack<T> {
    private final Stack<T> originalStack;
    private final Stack<T> duplicateStack;

    public QueueUsingStack() {
        originalStack = new Stack<>();
        duplicateStack = new Stack<>();
    }

    public boolean push(T data) {

        /**
         * reversing the insertion order in stack, here we are making push expensive by maintaining a duplicate stack, same way pop method can be made expensive
         * to implement another way of implementing the queue using stack
         */
        copy(originalStack, duplicateStack);
        originalStack.push(data);
        copy(duplicateStack, originalStack);
        return true;
    }

    public T pop() {
        T pop = originalStack.pop();
        return pop;
    }

    public T peek() {
        return originalStack.peek();
    }

    private Stack<T> copy(Stack<T> from, Stack<T> to) {
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
        return to;
    }

    public boolean isEmpty() {
        return originalStack.isEmpty();
    }

    public int length() {
        return originalStack.size();
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int length = originalStack.size();

            @Override
            public boolean hasNext() {
                return length > 0;
            }

            @Override
            public T next() {
                return originalStack.peekAt(--length);
            }
        };
    }

    public String print() {
        Iterator<T> iterator = this.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next()+",");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        QueueUsingStack<String> q=new QueueUsingStack<>();
        q.push("Ruksad");
        q.push("Siddiqui");
        System.out.println(q.print());
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.print());
    }
}
