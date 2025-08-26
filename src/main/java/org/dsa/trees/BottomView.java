package org.dsa.trees;

import java.util.*;

public class BottomView {

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

        System.out.println("Bottom view: " + bottom(root));

    }

    // TC -> O(n log n) because of tree map
    // SC -> O(n)
    public static List<Integer> bottom(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0, root));

        while (!q.isEmpty()) {

            Pair pair = q.poll();
            Node node = pair.node;
            int col = pair.col;

            map.put(col, node.data);

            if (node.left != null) {
                q.offer(new Pair(col - 1, node.left));
            }

            if (node.right != null) {
                q.offer(new Pair(col + 1, node.right));
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int val : map.values()) {
            res.add(val);
        }

        return res;
    }
}
