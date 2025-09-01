package org.dsa.trees.bt;

import java.util.Stack;

public class Flatten {
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

        Node node = flattenToLL(root);

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }

        node = flattenOpt(root);
        System.out.println();
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    // TC - O(n)
    // SC - O(n)
    public static Node flattenToLL(Node root) {

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            Node node = st.pop();

            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }

            if (!st.isEmpty()) {
                node.right = st.peek();
            }
            node.left = null;
        }

        return root;
    }

    // make rightmost node of left subtree point right to curr.right
    // then make curr.right point to curr.left and move to curr.right
    public static Node flattenOpt(Node root) {

        Node curr = root;

        while (curr != null) {
            if (curr.left != null) {
                Node prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
            }
            curr = curr.right;
        }

        return root;
    }
}
