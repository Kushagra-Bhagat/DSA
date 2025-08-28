package org.dsa.trees.bt;

import java.util.*;

class Tuple {
    Node node;
    int row;
    int col;

    public Tuple(Node node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}


public class VerticalTraversal {

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

        System.out.println("Vertical traversal: " + vertical(root));
    }

    public static List<ArrayList<Integer>> vertical(Node root) {

        if (root == null) {
            return new ArrayList<>();
        }

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {

            Tuple tuple = q.poll();
            Node node = tuple.node;
            int x = tuple.col;
            int y = tuple.row;

            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }

            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }

            map.get(x).get(y).offer(node.data);

            if (node.left != null) {
                q.offer(new Tuple(node.left, y + 1, x - 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, y + 1, x + 1));
            }
        }

        List<ArrayList<Integer>> res = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                if (!nodes.isEmpty()) {
                    res.get(res.size() - 1).add(nodes.poll());
                }
            }
        }

        return res;
    }
}
