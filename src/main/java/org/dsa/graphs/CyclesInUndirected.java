package org.dsa.graphs;


import java.util.*;

// Using BFS
public class CyclesInUndirected {

    public static boolean BFS (List<List<Integer>> adj, boolean[] visited, int start) {
        Queue<int[]> qt = new LinkedList<>();

        qt.offer(new int[]{start, -1});
        visited[start] = true;

        while (!qt.isEmpty()) {
            int[] val = qt.poll();
            int node = val[0];
            int parent = val[1];

            for (int v : adj.get(node)) {
                if (!visited[v]) {
                    visited[v] = true;
                    qt.offer(new int[]{v, node});
                }
                else if (v != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycle(List<List<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && BFS(adj, visited, i)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).addAll(Arrays.asList(1, 2, 3));
        adj.get(1).addAll(Arrays.asList(0, 2));
        adj.get(2).addAll(Arrays.asList(0, 1));
        adj.get(3).addAll(Arrays.asList(0, 4));
        adj.get(4).addAll(Arrays.asList(3));

        if (isCycle(adj)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
