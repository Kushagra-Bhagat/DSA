package org.dsa.linkedList;

public class SingleLinkedList {
    static class Node {
        Node next;
        int data;

        Node (int data) {
            this.data = data;
            next = null;
        }
    }

    static Node head;

    static void printList() {
        if (head == null) {
            System.out.println("Linked list is empty!");
            return;
        }
        System.out.println("Linked List: ");
        Node p = head;
        while (p != null) {
            if (p.next == null) {
                System.out.print(p.data);
                break;
            }
            System.out.print(p.data + "->");
            p = p.next;
        }
        System.out.println();
    }

    static void insertAtBeginning(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    static void insertAtEnding(int data) {
        Node node = new Node(data);
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = node;
    }

    static void insertAfterNode(Node list, int data) {
        Node node = new Node(data);
        node.next = list.next;
        list.next = node;
    }

    static void deleteAtBeginning() {
        if (head == null) {
            System.out.println("Linked list is empty!");
        }
        head = head.next;
    }

    static void deleteAtEnding() {
        if (head == null) {
            System.out.println("Linked list is empty!");
        }
        else if (head.next == null) {
            head = null;
        }
        else {
            Node p = head;
            while (p.next.next != null) {
                p = p.next;
            }
            p.next = null;
        }
    }

    static void deleteNode(int key) {
        if (head == null) {
            System.out.println("Linked list is empty!");
            return;
        }
        else if (head.data == key){
            head = head.next;
            return;
        }
        Node temp = head.next;
        Node prev = head;

        while (temp != null) {
            if (temp.data == key) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Key not found!");
        }
    }

    static void reverseList() {
        if (head == null) {
            System.out.println("Linked list is empty!");
        }
        Node prevNode = null;
        Node curr = head;
        Node nextNode = null;
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;
        }
        head = prevNode;
    }


    public static void main(String[] args) {
        insertAtBeginning(10);
        insertAtBeginning(20);
        insertAtEnding(30);
        insertAtEnding(40);
        insertAtBeginning(50);

//        deleteNode(10);

        printList();

        reverseList();

        printList();

    }
}
