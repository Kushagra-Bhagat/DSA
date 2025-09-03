package org.dsa.trees.bst;

import org.dsa.trees.bt.Node;

public class PreToBST {

    public static void main(String[] args) {

    }

    // track index globally
    public static Node makeBst(int[] pre, int bound, int[] idx) {

        if (idx[0] == pre.length || pre[idx[0]] > bound) {
            return null;
        }

        Node root = new Node(pre[idx[0]]);
        idx[0]++;
        root.left = makeBst(pre, root.data, idx);
        root.right = makeBst(pre, bound, idx);
        return root;
    }
}
