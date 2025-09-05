package org.dsa.trees.bst;

import org.dsa.trees.bt.Node;

public class Recover {
    public static void main(String[] args) {

    }

    private static Node prev;
    private static Node first;
    private static Node middle;
    private static Node last;

    // TC -> O(n)
    // SC -> O(n) recursive stack space
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null && root.data < prev.data) {
            if (first == null) {
                first = prev;
                middle = root;
            }
            else {
                last = root;
            }
        }

        prev = root;
        inorder(root.right);
    }

    public static void recover(Node root) {

        prev = first = middle = last = null;
        inorder(root);

        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        else if (first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }
}
