package org.dsa.trees.bst;

import org.dsa.trees.bt.Node;

public class Deletion {
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

        Node node = deleteNode(root, 8);
        System.out.println(node.left.right.right.left.data);
    }

    public static Node deleteNode(Node root, int key) {

        if (root == null) {
            return null;
        }

        if (root.data == key) {
            return helper(root);
        }

        Node curr = root;
        while (curr != null) {
            if (key < curr.data) {
                if (curr.left != null && curr.left.data == key) {
                    curr.left = helper(curr.left);
                    break;
                }
                else {
                    curr = curr.left;
                }
            }
            else {
                if (curr.right != null && curr.right.data == key) {
                    curr.right = helper(curr.right);
                    break;
                }
                else {
                    curr = curr.right;
                }
            }
        }


        return root;
    }

    public static Node helper(Node root) {
        if (root.right == null) {
            return root.left;
        }
        else if (root.left == null) {
            return root.right;
        }
        else {
            Node leftLast = findLastRight(root.left);
            leftLast.right = root.right;
            return root.left;
        }
    }
    public static Node findLastRight(Node root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
    }
}
