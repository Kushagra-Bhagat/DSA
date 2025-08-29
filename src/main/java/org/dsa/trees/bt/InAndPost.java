package org.dsa.trees.bt;

import java.util.HashMap;
import java.util.Map;

public class InAndPost {

    public static void main(String[] args) {

    }

    public static Node tree(int[] inOrder, int[] postOrder) {

        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }

        return buildTree(
                inOrder, 0, inOrder.length - 1,
                postOrder, 0, postOrder.length - 1,
                inMap
        );
    }

    public static Node buildTree(int[] inOrder, int inStart, int inEnd,
                                 int[] postOrder, int postStart, int postEnd, Map<Integer, Integer> inMap) {

            if (inEnd < inStart || postEnd < postStart) return null;

            Node root = new Node(postOrder[postEnd]);

            int inRoot = inMap.get(root.data);
            int numLeft = inRoot - inStart;

            root.left = buildTree(inOrder, inStart, inRoot - 1,
                    postOrder, postStart, postStart + numLeft - 1, inMap);
            root.right = buildTree(inOrder, inRoot + 1, inEnd,
                    postOrder, postStart + numLeft, postEnd - 1, inMap);

            return root;
    }
}
