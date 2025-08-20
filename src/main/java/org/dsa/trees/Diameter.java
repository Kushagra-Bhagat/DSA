package org.dsa.trees;


// Longest path between 2 nodes
// Doesn't need to pass via root
public class Diameter {

    public static void main(String[] args) {
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int[] dia = new int[1];
        diameter(root, dia);
        System.out.println("Diameter: " + dia[0]);
    }

    // TC -> O(n)
    public static int diameter(Node root, int[] dia) {

        if (root == null) {
            return 0;
        }

        int lh = diameter(root.left, dia);
        int rh = diameter(root.right, dia);

        dia[0] = Math.max(dia[0], lh + rh);

        return 1 + Math.max(lh, rh);
    }



}
