package org.dsa.trees.bt;

import java.util.LinkedList;
import java.util.Queue;

public class Width {

    static class Pair {
        Node node;
        int id;
        public Pair(Node node, int id) {
            this.node = node;
            this.id = id;
        }
    }

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

        System.out.println("Max width: " + width(root));
    }

    public static int width(Node root) {

        if (root == null) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int ans = 0;

        while (!q.isEmpty()) {
            int minId = q.peek().id;
            int size = q.size();
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Node node = q.peek().node;
                int currId = q.peek().id - minId;
                q.poll();
                if (i == 0) first = currId;
                if (i == size - 1) last = currId;

                if (node.left != null) {
                    q.offer(new Pair(node.left, currId * 2 + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right, currId * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}
