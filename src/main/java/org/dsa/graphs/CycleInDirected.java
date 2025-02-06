package org.dsa.graphs;

import java.util.ArrayList;
import java.util.List;

public class CycleInDirected {

    static boolean isCyclicUtil (List<List<Integer>> adj, int u, boolean[] visited, boolean[] recStack) {
        if (!visited[u]) {
            visited[u] = true;
            recStack[u] = true;

            for (int x : adj.get(u)) {
                if (!visited[x] && isCyclicUtil(adj, x, visited, recStack)) {
                    return true;
                }
                else if (recStack[x]) {
                    return true;
                }
            }
        }
        recStack[u] = false;
        return false;
    }

    static boolean isCyclic(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        if (isCyclicUtil(adj, 0, visited, recStack)) {
            return true;
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
