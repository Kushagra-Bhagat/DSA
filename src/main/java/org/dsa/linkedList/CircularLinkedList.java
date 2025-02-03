package org.dsa.linkedList;

public class CircularLinkedList {
    static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.next = null;
            this.data = data;
        }
    }

    static Node head;

    static void printList() {
        if (head == null) {
            System.out.println("Linked list is empty!");
        }
        else if (head.next == head) {
            System.out.println(head.data);;
        }
        else {
            Node temp = head;
            while (temp.next != head) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
    }

    static void insertAtBeginning(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            head.next = head;
            return;
        }
        node.next = head;
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        head = node;
        temp.next = head;
    }

    static void insertAtEnd(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            head.next = head;
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = node;
        node.next = head;
    }

    static void deleteStart() {
        if (head == null) {
            System.out.println("Linked list is empty!");
        }
        else if (head.next == head) {
            head = null;
        }
        else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next = head;
        }
    }

    static void deleteEnd() {
        if (head == null) {
            System.out.println("Linked list is empty!");
        }
        else if (head.next == head) {
            head = null;
        }
        else {
            Node temp = head;
            if (temp.next.next != head) {
                temp = temp.next;
            }
            temp.next = head;
        }
    }

    public static void main(String[] args) {
        insertAtBeginning(5);
        insertAtBeginning(4);
        insertAtBeginning(3);
        insertAtBeginning(2);
        insertAtEnd(6);
        printList();

    }
}
