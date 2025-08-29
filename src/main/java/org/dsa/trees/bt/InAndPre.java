package org.dsa.trees.bt;

import java.util.HashMap;
import java.util.Map;

public class InAndPre {
    public static void main(String[] args) {

        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};

        Node root = tree(inOrder, preOrder);
    }

    public static Node tree(int[] inOrder, int[] preOrder) {

        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }

        return buildTree(
                inOrder, 0, inOrder.length - 1,
                preOrder, 0, preOrder.length - 1,
                inMap
        );
    }

    public static Node buildTree(int[] inOrder, int inStart, int inEnd, int[] preOrder, int preStart,
                                 int preEnd, Map<Integer, Integer> inMap) {

        if (inEnd < inStart || preEnd < preStart) return null;

        Node root = new Node(preOrder[preStart]);

        int inRoot = inMap.get(root.data);
        int numLeft = inRoot - inStart;

        root.left = buildTree(inOrder, inStart, inRoot - 1,
                preOrder, preStart + 1, preStart + numLeft,
                inMap);
        root.right = buildTree(inOrder, inRoot + 1, inEnd,
                preOrder, preStart + numLeft + 1, preEnd,
                inMap);

        return root;
    }
}
