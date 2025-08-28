package org.dsa.trees.bt;

public class Symmetric {
    public static void main(String[] args) {
        // Build a sample symmetric binary tree:
        //         1
        //        /  \
        //       2    2
        //      / \  / \
        //     3  4 4  3
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(2);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.left = new Node(4);
        root.right.right = new Node(3);

        if (root == null) {
            System.out.println("Null root");
            return;
        }
        System.out.println("Symmetric: " + isSymmetric(root.left, root.right));

    }

    public static boolean isSymmetric(Node leftNode, Node rightNode) {
        if (leftNode == null || rightNode == null) {
            return leftNode == rightNode;
        }

        if (leftNode.data != rightNode.data) {
            return false;
        }

        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }
}
