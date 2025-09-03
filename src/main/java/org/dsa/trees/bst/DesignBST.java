package org.dsa.trees.bst;

import org.dsa.trees.bt.Node;

import java.util.Stack;

// To know how to design properly watch ai chat
public class DesignBST {

    static Stack<Node> st = new Stack<>();

    public static boolean hasNext() {
        return !st.isEmpty();
    }

    public static Node next() {
        if (st.isEmpty()) {
            return null;
        }

        Node sol = st.pop();
        Node node = sol;
        if (node.right != null) {
            st.push(node.right);
            node = node.right;
            while (node.left != null) {
                st.push(node.left);
                node = node.left;
            }
        }
        return sol;
    }

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

        st.push(root);
        Node curr = root;
        while (curr.left != null) {
            st.push(curr.left);
            curr = curr.left;
        }
    }
}
