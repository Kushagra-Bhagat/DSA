package org.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Insertion {

    static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            } else {
                queue.add(temp.right);
            }
        }
        return root;
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

        insert(firstNode, 6);
        Traversal.levelOrderTraversalBFS(firstNode);
    }
}
