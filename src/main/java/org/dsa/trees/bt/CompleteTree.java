package org.dsa.trees.bt;

// find no of nodes in less that O(n)
public class CompleteTree {
    public static void main(String[] args) {
        //
//                 20
//                /  \
//               8    22
//              / \   / \
//             4  12 2  25
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

        root.right.left = new Node(2);
        root.right.right = new Node(25);

        System.out.println("No of nodes: " + number(root));
    }

    // TC -> O((log n)^2)
    // SC -> O(log n)
    public static int number(Node root) {

        if (root == null) {
            return 0;
        }

        int left = leftHeight(root);
        int right = rightHeight(root);

        if (left == right) return (int) (Math.pow(2, left + 1.0) - 1);
        else {
            return 1 + number(root.left) + number(root.right);
        }
    }

    public static int leftHeight(Node node) {
        int count = 0;
        while (node.left != null) {
            count++;
            node = node.left;
        }
        return count;
    }

    public static int rightHeight(Node node) {
        int count = 0;
        while (node.right != null) {
            count++;
            node = node.right;
        }
        return count;
    }
}
