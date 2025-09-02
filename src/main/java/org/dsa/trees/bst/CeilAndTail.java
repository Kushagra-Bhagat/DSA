package org.dsa.trees.bst;

import org.dsa.trees.bt.Node;

public class CeilAndTail {

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

        Node node = findCeil(root, 24);
        System.out.println("Ceil: " + node == null ? -1 : node.data);

        node = findTail(root, 24);
        System.out.println("Floor: " + node == null ? -1 : node.data);
    }

    // ceil = Smallest node.val >= key
    // TC -> O(h)
    public static Node findCeil(Node root, int key) {

        Node node = root;
        Node sol = null;

        while (node != null) {
            if (node.data >= key) {
                sol = node;
                node = node.left;
            }

            else {
                node = node.right;
            }
        }

        return sol;
    }

    // Floor = greatest value <= key
    public static Node findTail(Node root, int key) {

        Node node = root;
        Node sol = null;

        while (node != null) {
            if (node.data <= key) {
                sol = node;
                node = node.right;
            }
            else {
                node = node.left;
            }
        }

        return sol;
    }
}
