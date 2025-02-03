package org.dsa.dequeue;

public class DequeueAll {
    static class DQueNode {
        int val;
        DQueNode next;
        DQueNode prev;
    }

    static class Dequeue {
        DQueNode head;
        DQueNode tail;
        public Dequeue() {
            head = tail = null;
        }

        boolean isEmpty() {
            return head == null;
        }

        int size() {
            if (!isEmpty()) {
                DQueNode temp = head;
                int len = 0;
                while (temp != null) {
                    len++;
                    temp = temp.next;
                }
                return len;
            }
            return 0;
        }

        void insertFirst(int num) {
            DQueNode node = new DQueNode();
            node.val = num;
            if (head == null) {
                head = tail = node;
                node.next = node.prev = null;
            }
            else {
                node.prev = null;
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        void insertLast(int num) {
            DQueNode node = new DQueNode();
            node.val = num;
            if (head == null) {
                head = tail = node;
                node.next = node.prev = null;
            }
            else {
                node.next = null;
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
        }

        void removeFirst() {
            if (size() == 0) {
                System.out.println("Dequeue is empty!");
                return;
            }
            if (head == tail) {
                head = tail = null;
                return;
            }
            head = head.next;
            head.prev = null;
        }

        void removeLast() {
            if (size() == 0) {
                System.out.println("Dequeue is empty!");
                return;
            }
            if (head == tail) {
                head = tail = null;
                return;
            }
            tail = tail.prev;
            tail.next = null;
        }
    }

    static class Stack {
        Dequeue dq = new Dequeue();

        void push(int num) {
            dq.insertFirst(num);
        }

        void pop() {
            dq.removeFirst();
        }
    }

    static  class Queue {
        Dequeue dq = new Dequeue();

        void enqueue(int num) {
            dq.insertFirst(num);
        }

        void dequeue() {
            dq.removeLast();        }
    }
}
