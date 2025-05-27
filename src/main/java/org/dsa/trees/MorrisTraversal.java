package org.dsa.trees;

public class MorrisTraversal {

    static void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }

        Node curr = root;

        while (curr != null) {

            if (curr.left == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            else {
                Node prev = curr.left;

                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                else {
                    prev.right = null;
                    System.out.print(curr.data + " ");
                    curr = curr.right;
                }
            }
        }
    }

    static void traversePreOrder(Node root) {

        if (root == null) {
            return;
        }

        Node curr = root;

        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
            }

            else {
                Node prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    System.out.print(curr.data + " ");
                    prev.right = curr;
                    curr = curr.left;
                }
                else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);
        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        secondNode.left = fourthNode;
        thirdNode.right = fifthNode;

        traverseInOrder(firstNode);
        System.out.println();
        traversePreOrder(firstNode);
    }
}
