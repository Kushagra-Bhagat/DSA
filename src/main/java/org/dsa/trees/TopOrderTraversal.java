package org.dsa.trees;

import java.util.*;

import static org.dsa.trees.VerticalTraversal.vertical;

class Pair {
    Node node;
    int col;

    public Pair(int col, Node node) {
       this.col = col;
       this.node = node;
    }
}


// when doing this question don't go for vertical
// instead if u have value for row and col,  don't move ahead
public class TopOrderTraversal {

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

        List<ArrayList<Integer>> arr = vertical(root);
        ArrayList<Integer> res = new ArrayList<>();

        for (ArrayList<Integer> lvl : arr) {
            res.add(lvl.get(0));
        }

        System.out.println("Top order is: " + res);

        System.out.println("own function: " + top(root));
    }

    public static List<Integer> top(Node root) {
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

            if (!map.containsKey(col)) {
                map.put(col, node.data);
            }

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
