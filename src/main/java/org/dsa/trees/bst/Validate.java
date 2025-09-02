package org.dsa.trees.bst;

import org.dsa.trees.bt.Node;

public class Validate {
    public static void main(String[] args) {
        //
//                 20
//                /  \
//               8    22
//              / \   / \
//             4  12 21  25
//            / \ / \
//           1  5 10 14

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);

        root.left.left = new Node(4);
        root.left.right = new Node(12);

        root.left.left.left = new Node(1);
        root.left.left.right = new Node(5);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        root.right.left = new Node(21);
        root.right.right = new Node(25);

        System.out.println("Is BST: " + validation(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public static boolean validation(Node root, int low, int high) {
        if (root == null) {
            return true;
        }

        if (root.data < low || root.data > high) {
            return false;
        }

        boolean validateLeft = validation(root.left, low, root.data);
        boolean validateRight = validation(root.right, root.data, high);

        return validateLeft && validateRight;
    }
}
