package org.example;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        /*
         * Queue is an INTERFACE in Java.
         *
         * We cannot normally instantiate Queue directly:
         *
         * Queue<String> queue = new Queue<>(); // WRONG
         *
         * Instead, we use a class that implements Queue.
         *
         * ArrayDeque is usually a very good implementation
         * for a normal FIFO queue.
         */

        Queue<String> names = new ArrayDeque<>();

        // --------------------------------------------------
        // 1. ADDING ELEMENTS
        // --------------------------------------------------

        /*
         * offer() adds an element to the END of the queue.
         *
         * Queue:
         *
         * FRONT                  END
         * Wesley
         */

        names.offer("Wesley");
        names.offer("Vinicius");
        names.offer("Terezinha");

        System.out.println(names);

        String firstPerson = names.peek();
        System.out.println("Primeira pessoa da fila é: " + firstPerson);

        String removedPerson = names.poll();

        System.out.println("Removed: " + removedPerson);

        System.out.println(names);

        boolean empty = names.isEmpty();

        System.out.println("Is queue empty? " + empty);
    }
}
