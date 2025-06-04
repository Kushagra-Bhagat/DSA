package org.dsa.trees;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// O(n) every edge of tree is traversed at most 3 times and O(1) space complexity
public class MorrisTraversal {

    public static void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.println("Inorder traversal: ");
        Node curr = root;

        while (curr != null) {
            // end of left subtree print left
            if (curr.left == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            else {
                Node prev = curr.left;
                // keep going to right of left subtree
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                // reached rightmost leaf of left subtree
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                // print middle node and move to right subtree bcz left -> middle is done
                else {
                    System.out.print(curr.data + " ");
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
    }

    public static void traversePreOrder(Node root) {
        if (root == null) {
            return;
        }

        Node curr = root;
        System.out.println("Preorder traversal: ");

        while (curr != null) {
            // curr.right will hold value as curr is predecessor, if not end of traversal
            if (curr.left == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            else {
                Node prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    System.out.print(curr.data + " ");
                    prev.right = curr;
                    curr = curr.left;
                }
                else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
    }

    // O(n) space complexity because we have to use list
    public static void postTraversal(Node root) {
        if (root == null) {
            return;
        }

        List<Integer> res = new ArrayList<>();
        Node curr = root;
        System.out.println("Postorder traversal: ");

        while (curr != null) {
            if (curr.right == null) {
                res.add(curr.data);
                curr = curr.left;
            }
            else {
                Node prev = curr.right;
                while (prev.left != null && prev.left != curr) {
                    prev = prev.left;
                }
                if (prev.left == null) {
                    res.add(curr.data);
                    prev.left = curr;
                    curr = curr.right;
                }
                else {
                    prev.left = null;
                    curr = curr.left;
                }
            }
        }
        Collections.reverse(res);
        System.out.print(res);
    }

    public static void main(String[] args) {

//                1
//              /   \
//             2     3
//            /     /  \
//           4     5    6
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);
        Node sixthNode = new Node(6);
        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        secondNode.left = fourthNode;
        thirdNode.left = fifthNode;
        thirdNode.right = sixthNode;

        traverseInOrder(firstNode);
        System.out.println();
        traversePreOrder(firstNode);
        postTraversal(firstNode);
    }
}
