package org.dsa.linkedList;

public class DoublyLinkedList {
    static class Node {
        Node prev;
        Node next;
        int data;
        Node (int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    static Node head;

    static void printList() {
        if (head == null) {
            System.out.println("Linked list is empty!");
        }
        else {
            Node temp = head;
            while (temp.next != null) {
                System.out.print(temp.data + " <-> ");
                temp = temp.next;
            }
            System.out.print(temp.data);
            System.out.println();
        }
    }

    static void insertInBeginning(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    static void insertAtLast(int data) {
        if (head == null) {
            insertInBeginning(data);
            return;
        }
        Node node = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }

    static void deleteFirst() {
        if (head == null) {
            System.out.println("Linked list is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head.next;
        head.next = null;
        head = temp;
        head.prev = null;
    }

    static void deleteLast() {
        if (head == null) {
            System.out.println("Linked list is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next.prev = null;
        temp.next = null;
    }

    public static void main(String[] args) {
        insertInBeginning(1);
        insertInBeginning(2);
        insertInBeginning(3);
        insertInBeginning(4);
        insertAtLast(0);
        printList();
        deleteFirst();
        printList();
        deleteFirst();
        printList();
        deleteLast();
        printList();
        deleteLast();
        printList();
        deleteLast();
        printList();
        deleteLast();
        printList();
    }
}
