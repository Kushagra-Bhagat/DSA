package org.dsa.trees.bt;

import java.util.*;

public class Traversal {

    // TC -> O(n), n = no of nodes as every node is visited at max 1
    // SC -> O(h), h = height of the tree
    public static void preOrder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {

        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int currLevel = 0;

        while(!q.isEmpty()) {
            int len = q.size();
            res.add(new ArrayList<>());

            for (int i = 0; i < len; i++) {
                Node node = q.poll();
                res.get(currLevel).add(node.data);

                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            currLevel++;
        }

        return res;
    }

    // TC -> O(n)
    // SC -> O(h)
    public static void preOrderIterative(Node root) {

        if (root == null) {
            return;
        }

        Stack<Node> st = new Stack<>();
        st.add(root);

        while(!st.isEmpty()) {

            Node node = st.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                st.add(node.right);
            }
            if (node.left != null) {
                st.add(node.left);
            }
        }
    }

    public static ArrayList<Integer> inOrderIterative(Node root) {

        Stack<Node> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        Node node = root;

        while(true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            }
            else {
                if (st.isEmpty()) {
                    break;
                }
                node = st.pop();
                res.add(node.data);
                node = node.right;
            }
        }
        return res;
    }

    // TC -> O(n)
    // SC -> O(2h)
    public static void postOrderIterative(Node root) {

        if (root == null) {
            return;
        }

        ArrayList<Integer> res = new ArrayList<>();

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.add(root);

        while (!s1.isEmpty()) {

            Node node = s1.pop();
            s2.add(node);

            if(node.left != null) {
                s1.add(node.left);
            }
            if(node.right != null) {
                s1.add(node.right);
            }
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    public static void postOrderOneStack(Node root) {

        Stack<Node> st = new Stack<>();
        Node node = root;

        while(true) {
            if (node != null) {
                st.push(node);
                st.push(node);
            }
            if (st.isEmpty()) {
                break;
            }
            node = st.pop();
            if (!st.isEmpty() && root == st.peek()) {
                node = node.right;
            }
            else {
                System.out.print(node.data);
                node = null;
            }
        }
    }

    public static void allInOne(Node root) {

        class Pair {
            Node node;
            int num;

            public Pair(Node node, int num) {
                this.node = node;
                this.num = num;
            }
        }

        if(root == null) return;

        Stack<Pair> st = new Stack<>();
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();

        Pair pair = new Pair(root, 1);
        st.push(pair);

        while (!st.isEmpty()) {

            Pair it = st.pop();

            if (it.num == 1) {
                pre.add(it.node.data);
                it.num += 1;
                st.push(it);

                if (it.node.left != null) {
                    Pair newPair = new Pair(it.node.left, 1);
                    st.push(newPair);
                }
            }

            else if(it.num == 2) {
                in.add(it.node.data);
                it.num += 1;
                st.push(it);

                if (it.node.right != null) {
                    Pair newPair = new Pair(it.node.right, 1);
                    st.push(newPair);
                }
            }

            else {
                post.add(it.node.data);
            }
        }

        System.out.println("Preorder: " + pre);
        System.out.println("Inorder: " + in);
        System.out.println("Postorder: " + post);
    }


    public static void main(String[] args) {
//                 1
//                / \
//               2   3
//              / \ / \
//             4  5 6  7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Pre order traversal using recursion: ");
        preOrder(root);
        System.out.println("\nIn order traversal using recursion: ");
        inOrder(root);
        System.out.println("\nPost order traversal using recursion: ");
        postOrder(root);
        System.out.println("\nLevel order traversal or BFS: " + levelOrder(root));
        System.out.println("Pre order traversal using iteration: ");
        preOrderIterative(root);
        System.out.println("\nIn order traversal using iteration: " + inOrderIterative(root));
        System.out.println("Post order traversal using iteration and 2 stacks: ");
        postOrderIterative(root);
        System.out.println("\nAll: ");
        allInOne(root);
    }
}
