package org.dsa.trees.bt;

import java.util.LinkedList;
import java.util.Queue;

public class Deletion {

    static Node deleteNode(Node root, int val) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node target = null;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.data == val) {
                target = curr;
                break;
            }

            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

        if (target == null) {
            return root;
        }

        Node lastNode = null;
        Node lastParentNode = null;
        Queue<Node> childQueue = new LinkedList<>();
        Queue<Node> parentQueue = new LinkedList<>();
        childQueue.add(root);
        parentQueue.add(null);

        while (!childQueue.isEmpty()) {
            Node curr = childQueue.poll();
            lastNode = curr;
            lastParentNode = parentQueue.poll();

            if (curr.left != null) {
                childQueue.add(curr.left);
                parentQueue.add(curr);
            }

            if (curr.right != null) {
                childQueue.add(curr.right);
                parentQueue.add(curr);
            }
        }

        target.data = lastNode.data;

        if (lastParentNode != null) {
            if (lastParentNode.right != null) {
                lastParentNode.right = null;
            }
            else {
                lastParentNode.left = null;
            }
        }
        else {
            return null;
        }

        return root;
    }

    static void traverse (Node root) {

        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
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

        traverse(firstNode);
        System.out.println();
        deleteNode(firstNode, 2);

        traverse(firstNode);

    }
}
