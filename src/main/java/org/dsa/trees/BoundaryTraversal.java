package org.dsa.trees;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class BoundaryTraversal {
    public static void main(String[] args) {
//
//                 20
//                /  \
//               8    22
//                / \     \
//               4  12    25
//                /  \
//               10  14

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);

        root.left.left = new Node(4);
        root.left.right = new Node(12);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        root.right.right = new Node(25);

        System.out.println("Boundary traversal: " + boundary(root));
    }

    public static ArrayList<Integer> boundary(Node root) {

        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(root.data);

        Node node = root.left;

        while (node != null) {
            if(!isLeaf(node)) {
                res.add(node.data);
            }
            if (node.left != null) {
                node = node.left;
            }
            else {
                node = node.right;
            }
        }

        inorder(root, res);

        Stack<Integer> st = new Stack<>();
        node = root.right;

        while (node != null) {
            if (!isLeaf(node)) {
                st.add(node.data);
            }
            if (node.right != null) {
                node = node.right;
            }
            else {
                node = node.left;
            }
        }

        while (!st.isEmpty()) {
            res.add(st.pop());
        }

        return res;
    }

    public static void inorder(Node root, ArrayList<Integer> res) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(root.data);
        }
        inorder(root.left, res);
        inorder(root.right, res);
    }

    public static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
}
