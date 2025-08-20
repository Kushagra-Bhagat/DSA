package org.dsa.trees;

import static org.dsa.trees.MaxDepth.height;

// |height of left subtree - height of right subtree| <= 1
public class CheckBalancedTree {

    public static void main(String[] args) {
        //      4
        //    /   \
        //   2     6
        //  / \   / \
        // 1   3 5   7
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        System.out.println("Is the tree balanced: " + checkOpt(root));


        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        Node node = new Node(1);
        node.right = new Node(2);
        node.right.right = new Node(3);
        node.right.right.right = new Node(4);
        System.out.println("Is the tree balanced: " + checkOpt(node));
    }

    // naive solution
    // TC -> O(n^2)
    public static boolean check(Node root) {

        if(root == null) {
            return true;
        }

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        if (Math.abs(lHeight - rHeight) > 1) {
            return false;
        }

        boolean left = check(root.left);
        boolean right = check(root.right);

        if(!left || !right) {
            return false;
        }

        return true;
    }


    // Optimized code
    public static boolean checkOpt(Node root) {
        if (heightForCheck(root) == -1) {
            return false;
        }
        return true;
    }

    public static int heightForCheck(Node root) {

        if (root == null) {
            return 0;
        }

        int lh = heightForCheck(root.left);
        int rh = heightForCheck(root.right);

        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) {
            return -1;
        }

        return 1 + Math.max(lh, rh);
    }
}
