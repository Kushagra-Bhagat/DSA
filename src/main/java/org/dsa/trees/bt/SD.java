package org.dsa.trees.bt;

import java.util.LinkedList;
import java.util.Queue;

import static org.dsa.trees.bt.Traversal.allInOne;

// Serialize & Deserialize
public class SD {

    public static void main(String[] args) {
        //
//                 20
//                /  \
//               8    22
//              / \   / \
//             4  12 2  25
//              \   \
//              5   14

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);

        root.left.left = new Node(4);
        root.left.right = new Node(12);

        //root.left.left.left = new Node(1);
        root.left.left.right = new Node(5);

        //root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        root.right.left = new Node(2);
        root.right.right = new Node(25);

        System.out.println("Serialized: " + serialize(root));
        Node node = deSerialize("20 8 22 4 12 2 25 # 5 # 14 # # # # # # # #");
        allInOne(node);
    }

    public static String serialize(Node root) {

        if (root == null) {
            return "#";
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        StringBuilder res = new StringBuilder();
        String sol = "";

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node != null) {
                int val = node.data;
                res = res.append(" ").append(val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                else {
                    q.offer(null);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                else {
                    q.offer(null);
                }
            }
            else {
                res.append(" #");
            }
        }

        return res.toString().trim();
    }

    public static Node deSerialize(String res) {
        if (res == null || res.trim().equals("#")) {
            return null;
        }

        String[] s = res.trim().split("\\s+");
        Queue<String> q = new LinkedList<>();
        for (String str : s) {
            q.offer(str);
        }
        Node root = new Node(Integer.parseInt(q.poll()));
        Queue<Node> qNode = new LinkedList<>();
        qNode.offer(root);

        while (!q.isEmpty()) {
            Node node = qNode.poll();

            String s1 = q.poll();
            if (s1.equals("#")) {
                node.left = null;
            }
            else {
                node.left = new Node(Integer.parseInt(s1));
                qNode.offer(node.left);
            }

            String s2 = q.poll();
            if (s2.equals("#")) {
                node.right = null;
            }
            else {
                node.right = new Node(Integer.parseInt(s2));
                qNode.offer(node.right);
            }
        }

        return root;
    }
}
