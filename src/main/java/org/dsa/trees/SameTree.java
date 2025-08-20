package org.dsa.trees;

public class SameTree {

    public static void main(String[] args) {

        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        Node node1 = new Node(1);
        node1.left = new Node(2);
        node1.right = new Node(3);
        node1.left.left = new Node(4);
        node1.left.right = new Node(5);

        Node node2 = new Node(1);
        node2.left = new Node(2);
        node2.right = new Node(3);
        node2.left.left = new Node(4);
        node2.left.right = new Node(6);

        System.out.println("are they same trees: " + sameTree(node1, node2));
    }

    public static boolean sameTree(Node node1, Node node2) {

        if (node1 == null || node2 == null) {
            return node1 == node2;
        }

        return (node1.data == node2.data) && sameTree(node1.left, node2.left) && sameTree(node1.right, node2.right);
    }
}
