package org.dsa.graphs;

import java.util.*;


// for directed graph and can be used to detect cycle as well

// O(V + E)
// O(V)

// Topological sort used in software dependency, scheduling tasks.
public class KahnAlgorithm {

    static List<Integer> topologicalSort (List<List<Integer>> adj, int V) {

        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int idx : adj.get(i)) {
                inDegree[idx]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        // if (res.size() != V) -> contains a cycle

        return res;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {4, 5}, {5, 1}, {5, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        System.out.println(topologicalSort(adj, V));
    }
}
