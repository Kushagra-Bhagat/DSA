package org.dsa.graphs;

import java.util.ArrayList;
import java.util.List;

public class CycleInDirected {

    public static boolean dfs(List<List<Integer>> adjList, int idx, boolean[] vis, boolean[] path) {

        vis[idx] = true;
        path[idx] = true;

        for (int node : adjList.get(idx)) {
            if (!vis[node]) {
                if (dfs(adjList, node, vis, path)) {
                    return true;
                }
            }
            else if (path[node]) {
                return true;
            }
        }

        path[idx] = false;
        return false;
    }

    public static boolean isCyclic(List<List<Integer>> adj, int V) {
        boolean[] vis = new boolean[V];
        boolean[] path = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(adj, i, vis, path)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(3);

        if (isCyclic(adj, V)) {
            System.out.println("Has cycle");
        }
        else {
            System.out.println("Doesn't have cycle");
        }
    }
}
