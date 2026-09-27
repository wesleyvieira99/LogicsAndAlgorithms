package org.example;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // --- Helper Array Math ---
    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return (2 * i) + 1; }
    private int rightChild(int i) { return (2 * i) + 2; }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // --- Core Operations ---
    public void insert(int val) {
        if (size == capacity) throw new IllegalStateException("Heap is full");

        heap[size] = val; // Insert at the end
        size++;
        heapifyUp(size - 1); // Bubble up to maintain property
    }

    public int extractMin() {
        if (size == 0) throw new IllegalStateException("Heap is empty");

        int min = heap[0]; // The root is the min
        heap[0] = heap[size - 1]; // Move last element to root
        size--;
        heapifyDown(0); // Sink down to maintain property

        return min;
    }

    // --- The Magic Methods ---
    private void heapifyUp(int index) {
        // While not root AND parent is greater than current
        while (index > 0 && heap[parent(index)] > heap[index]) {
            swap(parent(index), index);
            index = parent(index); // Move pointer up
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        // Check left child
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        // Check right child
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        // If the smallest is not the current node, swap and recurse
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }
}
