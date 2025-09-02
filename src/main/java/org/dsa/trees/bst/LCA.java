package org.dsa.trees.bst;

import org.dsa.trees.bt.Node;

public class LCA {
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

        System.out.println("LCA: " + lca(root, 8, 14).data);
    }

    public static Node lca(Node root, int val1, int val2) {

        Node curr = root;
        if (val2 < val1) {
            int temp = val1;
            val1 = val2;
            val2 = temp;
        }

        while (curr != null) {
            if (val1 <= curr.data && val2 >= curr.data) {
                return curr;
            }
            else if (val2 < curr.data) {
                curr = curr.left;
            }
            else if (val1 > curr.data) {
                curr = curr.right;
            }
        }

        return null;
    }
}
