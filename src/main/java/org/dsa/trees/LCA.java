package org.dsa.trees;

public class LCA {
    public static void main(String[] args) {
        //
//                 20
//                /  \
//               8    22
//              / \     \
//             4  12    25
//               /  \
//              10  14

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);

        root.left.left = new Node(4);
        root.left.right = new Node(12);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        root.right.right = new Node(25);

        System.out.println("LCA for 4 and 14: " + lca(root, root.left.left, root.left.right.right).data);
    }

    public static Node lca(Node root, Node p, Node q)  {

        if (root == null || root == p || root == q) {
            return root;
        }

        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);

        if (left == null) {
            return right;
        }
        else if (right == null) {
            return left;
        }
        else {
            return root;
        }
    }

}
