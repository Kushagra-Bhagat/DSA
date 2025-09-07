package org.dsa.graphs;

import java.util.ArrayList;
import java.util.List;



public class DFS {

    public static void main(String[] args) {
        //       2  - 5
        //     /   \ /
        //    1     4
        //     \   /
        //       3

        ArrayList<ArrayList<Integer>> adjList = GraphRepresentation.adjacentList(5, 6);
        ArrayList<Integer> res = new ArrayList<>();
        int v = 5;
        boolean[] vis = new boolean[v + 1];
        dfs(4, vis, res, adjList);
        System.out.println(res);

    }

    // TC -> O(V) + O(E)
    // SC -> O(V)
    public static void dfs(int node, boolean[] vis, List<Integer> res, List<ArrayList<Integer>> adjList) {

        vis[node] = true;
        res.add(node);

        for (int val : adjList.get(node)) {
            if (!vis[val]) {
                dfs(val, vis, res, adjList);
            }
        }
    }
}
