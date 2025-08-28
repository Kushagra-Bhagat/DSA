package org.dsa.trees.bt;

public class MaxDepth {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.left = new Node(6);

        System.out.println("Maximum depth of tree is: " + height(root));
    }

    // TC -> O(n)
    // SC -> O(h)
    public static int height(Node root) {

        if (root == null) {
            return 0;
        }

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return 1 + Math.max(lHeight, rHeight);
    }
}
