package org.dsa.trees;

import org.dsa.queues.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class Traversal {

    // Root -> left -> right
    // O(n) time, O(h) -> space h = n for skewed and log n for complete BT
    static void traverseDFSPreOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");

        traverseDFSPreOrder(node.left);
        traverseDFSPreOrder(node.right);
    }

    // left -> root -> right
    // O(n) time, O(h) -> space h = n for skewed and log n for complete BT
    static void traverseDFSInOrder(Node node) {
        if (node == null) {
            return;
        }
        traverseDFSInOrder(node.left);

        System.out.print(node.data + " ");

        traverseDFSInOrder(node.right);
    }

    // left -> right -> root
    // O(n) time, O(h) -> space h = n for skewed and log n for complete BT
    static void traverseDFSPostOrder(Node node) {
        if (node == null) {
            return;
        }
        traverseDFSPostOrder(node.left);
        traverseDFSPostOrder(node.right);

        System.out.print(node.data + " ");
    }


    static void levelOrderTraversalBFS(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
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

        traverseDFSPreOrder(firstNode);
        System.out.println();
        traverseDFSInOrder(firstNode);
        System.out.println();
        traverseDFSPostOrder(firstNode);
        System.out.println();
        levelOrderTraversalBFS(firstNode);
    }
}
