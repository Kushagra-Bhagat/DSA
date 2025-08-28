package org.dsa.trees.bt;

import java.util.*;

public class Zigzag {

    public static void main(String[] args) {
//                 1
//                / \
//               2   3
//              / \ / \
//             4  5 6  7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("zigzag traversal: " + traverse(root));
    }

    public static List<ArrayList<Integer>> traverse(Node root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int currLevel = 0;

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        while(!q.isEmpty()) {

            int len = q.size();
            res.add(new ArrayList<>());

            for (int i = 0; i < len; i++) {
                Node node = q.poll();
                res.get(currLevel).add(node.data);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            if (currLevel % 2 != 0) {
                Collections.reverse(res.get(currLevel));
            }
            currLevel++;
        }

        return res;
    }
}
