package org.dsa.trees.bt;

import static org.dsa.trees.bt.Traversal.allInOne;

public class ChildrenSumProperty {

    public static void main(String[] args) {
        //
//                 20
//                /  \
//               8    22
//              / \     \
//             4  12    25
//               /  \
//              10  14

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);

        root.left.left = new Node(4);
        root.left.right = new Node(12);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        root.right.right = new Node(25);

        allInOne(root);
        tree(root);
        allInOne(root);
    }

    public static void tree(Node root) {

        if (root == null) {
            return;
        }

        int child = 0;
        if (root.left != null) child += root.left.data;
        if (root.right != null) child += root.right.data;

        if (child >= root.data) root.data = child;
        else {
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }

        tree(root.left);
        tree(root.right);

        int total = 0;
        if (root.left != null) total += root.left.data;
        if (root.right != null) total += root.right.data;
        if (root.right != null || root.left != null) root.data = total;
    }
}
