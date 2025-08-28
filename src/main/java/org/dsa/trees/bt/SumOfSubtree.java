package org.dsa.trees.bt;

public class SumOfSubtree {

    public static boolean checkSum(Node root, int sum) {
        if (root == null) {
            return false;
        }

        boolean[] foundSum = new boolean[0];
        check(root, foundSum, sum);

        return foundSum[0];
    }

    public static int check (Node node, boolean[] foundSum, int sum) {
        if (node == null) {
            return 0;
        }

        int checkSum = node.data + check(node.left, foundSum, sum) + check(node.right, foundSum, sum);

        if (checkSum == sum) {
            foundSum[0] = true;
        }

        return checkSum;
    }

    public static void main(String[] args) {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);
        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        secondNode.left = fourthNode;
        thirdNode.right = fifthNode;
    }
}
