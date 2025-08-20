package org.dsa.trees;

public class MaxPathSum {

    public static void main(String[] args) {

        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(-15);
        root.right.right = new Node(-9);

        int[] max = new int[1];
        sum(root, max);
        System.out.println("Max path sum: " + max[0]);
    }

    public static int sum(Node root, int[] max) {

        if(root == null) {
            return 0;
        }

        int lSum = Math.max(0, sum(root.left, max));
        int rSum = Math.max(0, sum(root.right, max));
        max[0] = Math.max(max[0], lSum + rSum + root.data);

        return root.data + Math.max(lSum, rSum);
    }
}
