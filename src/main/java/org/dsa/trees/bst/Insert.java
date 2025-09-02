package org.dsa.trees.bst;

import org.dsa.trees.bt.Node;

// basically insert on a leaf node
public class Insert {
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

        Node node = insertNode(root, 7);
        System.out.println(root.left.left.right.right.data);
    }

    public static Node insertNode(Node root, int data) {

        if (root == null) {
            return new Node(data);
        }

        Node curr = root;
        while(true) {
            if (data > curr.data) {
                if (curr.right != null) curr = curr.right;
                else {
                    curr.right = new Node(data);
                    break;
                }
            }
            else {
                if (curr.left != null) curr = curr.left;
                else {
                    curr.left = new Node(data);
                    break;
                }
            }
        }
        return root;
    }
}
