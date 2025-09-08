package org.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclesInUndirectedUsingDFS {

    public static void main(String[] args) {
        int V = 5;
        List<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).addAll(Arrays.asList(1, 2, 3));
        adj.get(1).addAll(Arrays.asList(0, 2));
        adj.get(2).addAll(Arrays.asList(0, 1));
        adj.get(3).addAll(Arrays.asList(0, 4));
        adj.get(4).addAll(Arrays.asList(3));

        cycle(adj);
    }

    public static void cycle(List<ArrayList<Integer>> adjList) {

        int v = adjList.size();
        boolean[] vis = new boolean[v];

        boolean cycle = false;
        for (int i = 0; i < v; i++) {
            if(!vis[i]) {
                cycle = dfsCycle(i, -1, adjList, vis);
                if(cycle) {
                    System.out.println("true");
                    break;
                }
            }
        }
        if(!cycle) {
            System.out.println("false");
        }
    }

    public static boolean dfsCycle(int curr, int parent, List<ArrayList<Integer>> adjList, boolean[] vis) {

        vis[curr] = true;
        for (int node : adjList.get(curr)) {
            if (!vis[node]) {
                return dfsCycle(node, curr, adjList, vis);
            }
            else if (node != parent) {
                return true;
            }
        }
        return false;
    }
}
