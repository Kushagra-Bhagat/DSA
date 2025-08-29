package org.dsa.trees.bt;

import java.util.*;

public class BurnTree {
    public static void main(String[] args) {
        //
//                 20
//                /  \
//               8    22
//              / \     \
//             4  12    25
//               /  \
//              10  14

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);

        root.left.left = new Node(4);
        root.left.right = new Node(12);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        root.right.right = new Node(25);

        System.out.println("Time taken to burn tree from 12: " + burn(root, root.left.right));
    }

    public static int burn(Node root, Node node) {

        if (root == null || node == null) {
            return -1;
        }

        HashMap<Node, Node> parentNode = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node tempNode = q.poll();

                if (tempNode.left != null) {
                    q.offer(tempNode.left);
                    parentNode.put(tempNode.left, tempNode);
                }
                if (tempNode.right != null) {
                    q.offer(tempNode.right);
                    parentNode.put(tempNode.right, tempNode);
                }
            }
        }

        Set<Node> visited = new HashSet<>();
        visited.add(node);
        q.offer(node);
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node tempNode = q.poll();

                if (tempNode.left != null && !visited.contains(tempNode.left)) {
                    q.offer(tempNode.left);
                    visited.add(tempNode.left);
                }
                if (tempNode.right != null && !visited.contains(tempNode.right)) {
                    q.offer(tempNode.right);
                    visited.add(tempNode.right);
                }
                if (parentNode.containsKey(tempNode) && !visited.contains(parentNode.get(tempNode))) {
                    q.offer(parentNode.get(tempNode));
                    visited.add(parentNode.get(tempNode));
                }
            }
            time++;
        }

        // at time 0 node was burned but we are calculating as in time 1 it was done
        return time - 1;
    }
}
