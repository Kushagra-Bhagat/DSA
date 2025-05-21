package org.dsa.trees;

public class Search {

    static boolean searchDFS(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.data == value) {
            return true;
        }

        boolean leftRes = searchDFS(root.left, value);
        boolean rightRes = searchDFS(root.right, value);

        return leftRes || rightRes;
    }

    public static void main(String[] args) {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);
        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        secondNode.left = fourthNode;
        thirdNode.right = fifthNode;

        System.out.println(searchDFS(firstNode, 9));
    }
}
