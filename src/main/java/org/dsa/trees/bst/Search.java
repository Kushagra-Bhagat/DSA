package org.dsa.trees.bst;

import org.dsa.trees.bt.Node;

public class Search {
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

        Node node = search(50, root);
        int val = node != null ? node.data : -1;

        System.out.println(val);
    }


    public static Node search(int val, Node root) {

        Node curr = root;

        while (curr != null) {
            if (curr.data == val) {
                return curr;
            }
            else if (val < curr.data) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }

        return null;
    }
}
