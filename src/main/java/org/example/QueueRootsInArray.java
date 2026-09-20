package org.example;

public class QueueRootsInArray {

    // Array that stores the queue elements - Array of ints
    private int[] queue;

    // Points to the first element in the queue
    private int front;

    // Points to the position where the next element will be inserted
    private int rear;

    // Number of elements currently inside the queue
    private int size;

    public QueueRootsInArray(int capacity) {

        // Create the array with a fixed capacity - setting the capacity and length of the queue
        queue = new int[capacity];

        // Queue starts empty
        front = 0;
        rear = 0;
        size = 0;
    }

    // Add an element to the END of the queue
    public void enqueue(int value) {

        // Check if the queue is full
        if (size == queue.length) {
            System.out.println("Queue is full!");
            return;
        }

        /*
         * Insert the value at the rear position.
         */
        queue[rear] = value;

        /*
         * Move rear to the next position.
         *
         * % queue.length makes the array circular.
         *
         * Example:
         *
         * array length = 5
         *
         * rear = 4
         *
         * (4 + 1) % 5 = 0
         *
         * So instead of leaving the array,
         * we go back to position 0.
         */
        rear = (rear + 1) % queue.length;

        size++;
    }

    // Remove the FIRST element from the queue
    public int dequeue() {

        // Queue has no elements
        if (size == 0) {
            throw new RuntimeException("Queue is empty!");
        }

        /*
         * Get the element at the front.
         */
        int value = queue[front];

        /*
         * Move front forward.
         */
        front = (front + 1) % queue.length;

        size--;

        return value;
    }

    // Look at the first element WITHOUT removing it
    public int peek() {

        if (size == 0) {
            throw new RuntimeException("Queue is empty!");
        }

        return queue[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Number of elements in the queue
    public int size() {
        return size;
    }

    public static void main(String[] args) {

        QueueRootsInArray queue = new QueueRootsInArray(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        /*
         * Logical queue:
         *
         * FRONT
         *   ↓
         * [10] [20] [30]
         *             ↑
         *            REAR
         */

        System.out.println(queue.peek());
        // 10

        System.out.println(queue.dequeue());
        // removes 10

        /*
         * Queue now:
         *
         * [20] [30]
         */

        System.out.println(queue.dequeue());
        // removes 20

        System.out.println(queue.peek());
        // 30

        queue.enqueue(40);
        queue.enqueue(50);

        /*
         * Logical order:
         *
         * 30 -> 40 -> 50
         */

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }

        /*
         * Output:
         *
         * 30
         * 40
         * 50
         */
    }
}