package org.dsa.trees.bt;

import java.util.*;

public class KDistance {
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

        int k = 2;
        System.out.println("Node with " + k + " distance from 8: " + distance(root, root.left, k));
    }

    public static List<Integer> distance(Node root, Node node, int k) {

        if (root == null || node == null) {
            return new ArrayList<>();
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

        while (k > 0) {

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
            k--;
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res.add(q.poll().data);
        }

        return res;
    }
}
