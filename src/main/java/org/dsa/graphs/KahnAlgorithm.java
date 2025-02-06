package org.dsa.graphs;

import java.util.*;


// for directed graph and can be used to detect cycle as well

// O(V + E)
// O(V)

// Topological sort used in software dependency, scheduling tasks.
public class KahnAlgorithm {

    static int[] topologicalSort (List<List<Integer>> adj, int V) {
        int[] inDegree = new int[V];
        int[] result = new int[V];

        for (int i = 0; i < V; i++) {
            for (int idx : adj.get(i)) {
                inDegree[idx]++;
            }
        }

        Queue<Integer> qt = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                qt.offer(i);
            }
        }

        int index = 0;
        while (!qt.isEmpty()) {
            int val = qt.poll();
            result[index++] = val;

            for (int idx : adj.get(val)) {
                inDegree[idx]--;

                if (inDegree[idx] == 0) {
                    qt.offer(idx);
                }
            }
        }

        if (index != V) {
            System.out.println("Graph contains cycle!");
            return new int[0];
        }
        return result;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>(V);
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {4, 5}, {5, 1}, {5, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        int[] result = topologicalSort(adj, V);

        System.out.println(Arrays.toString(result));
    }
}
