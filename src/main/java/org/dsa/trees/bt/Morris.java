package org.dsa.trees.bt;

import java.util.ArrayList;
import java.util.List;

public class Morris {

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

        System.out.println("In order: " + inorder(root));
        System.out.println("Pre order: " + preorder(root));
    }

    // go to left subtree and find rightmost node
    // then make that rightmost node attached to parent of left subtree
    // O(n)
    public static List<Integer> inorder(Node root) {

        List<Integer> res = new ArrayList<>();
        Node curr = root;

        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.data);
                curr = curr.right;
            }
            else {
                Node prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                else {
                    prev.right = null;
                    res.add(curr.data);
                    curr = curr.right;
                }
            }
        }


        return res;
    }

    // we reach rightmost node in left subtree and if its right is null means
    // we haven't visited left node so print root and then visit left
    public static List<Integer> preorder(Node root) {

        List<Integer> res = new ArrayList<>();
        Node curr = root;

        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.data);
                curr = curr.right;
            }
            else {
                Node prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    res.add(curr.data);
                    prev.right = curr;
                    curr = curr.left;
                }
                else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}
