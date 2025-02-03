package org.dsa.queues;

public class Queues {
    final static int MAX_SIZE = 8;
    static int[] queue = new int[MAX_SIZE];

    static int front = 0;
    static int size = 0;

    static void enqueue(int n) {
        if (size == MAX_SIZE) {
            System.out.println("Queue is full!");
        }
        queue[front + size] = n;
        size++;
    }

    static void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty!");
        }
        else {
            System.out.println(queue[front]);
            for (int i = 1; i < size; i++) {
                queue[i - 1] = queue[i];
            }
            size--;
        }
    }

    static void peek() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println(queue[front]);
    }

    static void printQueue() {
        if (size == 0) {
            System.out.println("Queue is empty!");
        }
        else {
            for (int i = front; i < size - 1; i++) {
                System.out.print(queue[i] + "<-");
            }
            System.out.print(queue[size - 1]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        dequeue();
        dequeue();
        enqueue(1);
        enqueue(2);
        peek();
        printQueue();
        enqueue(3);
        printQueue();
        dequeue();
        dequeue();
        dequeue();
        dequeue();
        dequeue();
        dequeue();
    }
}
