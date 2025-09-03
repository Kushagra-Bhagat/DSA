package org.dsa.trees.bst;

import org.dsa.trees.bt.Node;

public class InorderSuccessor {
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

        System.out.println("successor: " + pre(root, 14).data);
    }

    public static Node pre(Node root, int key) {

        Node curr = root;
        Node successor = null;

        while (curr != null) {
            if (key < curr.data) {
                successor = curr;
                curr = curr.left;
            }
            else if (key > curr.data) {
                curr = curr.right;
            }
            else {
                if (curr.right != null) {
                    curr = curr.right;
                    while (curr.left != null) {
                        curr = curr.left;
                    }
                    return curr;
                }
                return successor;
            }
        }
        return null;
    }
}
