package org.dsa.trees.bt;

import java.util.ArrayList;

public class RootToNode {
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

        ArrayList<Integer> res = new ArrayList<>();
        pathLength(root, res, 14);
        System.out.println("Length: " + res.size());
    }

    public static boolean pathLength(Node root, ArrayList<Integer> res, int val) {
        if (root == null) {
            return false;
        }

        res.add(root.data);

        if (root.data == val) {
            return true;
        }

        if (pathLength(root.left, res, val) || pathLength(root.right, res, val)) {
            return true;
        }

        res.remove(res.size() - 1);
        return false;
    }
}
