package org.dsa.queues;

import java.util.LinkedList;
import java.util.Queue;

// sort queue recursively
public class Sorting {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(20);
        q.add(2);
        q.add(5);
        q.add(12);
        q.add(8);

        sort(q);

        for (int i : q) {
            System.out.println(i);
        }
    }

    public static void sort(Queue<Integer> q) {

        if (q.isEmpty()) {
            return;
        }

        int temp = q.poll();

        sort(q);

        sortAndInsert(q, temp, q.size());
    }

    public static void sortAndInsert(Queue<Integer> q, int val, int size) {

        if (q.isEmpty() || size == 0) {
            q.add(val);
        }
        else if (val <= q.peek()) {
            q.add(val);
            frontToEnd(q, size);
        }
        else {
            q.add(q.poll());
            sortAndInsert(q, val, size - 1);
        }
    }

    public static void frontToEnd(Queue<Integer> q, int size) {
        if (size <= 0) {
            return;
        }
        q.add(q.poll());

        frontToEnd(q, size - 1);
    }
}
