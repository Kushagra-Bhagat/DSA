package org.dsa.trees.bst;

import org.dsa.trees.bt.Node;

import java.util.Stack;

class BSTIterator {

    Stack<Node> st = new Stack<>();
    boolean reverse = true;

    public BSTIterator(Node root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root);
    }

    private void pushAll(Node node) {
        while (node != null) {
            st.push(node);
            if (reverse) node = node.right;
            else node = node.left;
        }
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public int next() {
        Node node = st.pop();
        if (reverse) pushAll(node.left);
        else pushAll(node.right);

        return node.data;
    }
}

public class TwoSum {
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

        int k = 100;
        System.out.println("Has sum " + k + ": " + hasSum(root, k));
    }

    public static boolean hasSum (Node root, int k) {
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int l = left.next();
        int r = right.next();

        while (l < r) {
            if (l + r == k) return true;
            else if (l + r < k) {
                l = left.next();
            }
            else {
                r = right.next();
            }
        }

        return false;
    }
}
