package org.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        //       2  - 5
        //     /   \ /
        //    1     4
        //     \   /
        //       3

        ArrayList<ArrayList<Integer>> adjList = GraphRepresentation.adjacentList(5, 6);
        System.out.println(breadthSearch(5, adjList, 1));

    }

    // TC -> O(n) + O(2*E) -> for every node it runs for all its neighbour nodes
    // SC -> O(n)
    public static ArrayList<Integer> breadthSearch(int v, ArrayList<ArrayList<Integer>> adjList, int start) {

        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[v + 1];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int val = q.poll();
            bfs.add(val);

            for (int node : adjList.get(val)) {
                if (!vis[node]) {
                    vis[node] = true;
                    q.add(node);
                }
            }
        }

        return bfs;
    }
}
