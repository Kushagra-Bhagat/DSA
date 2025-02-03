package org.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// O(V + E)
// O(V) - auxillary space
public class BFS {

    static void bfs(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                traversal(adj, i, visited);
            }
        }
    }
    static void traversal(List<List<Integer>> adj, int s, boolean[] visited) {

        Queue<Integer> qt = new LinkedList<>();

        qt.add(s);
        visited[s] = true;

        while (!qt.isEmpty()) {
            int curr = qt.poll();
            System.out.print(curr + " ");
            for (int i : adj.get(curr)) {
                if (!visited[i]) {
                    qt.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    static void addEdge(List<List<Integer>> list, int i, int j) {
        list.get(i).add(j);
        list.get(j).add(i);
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);

        bfs(adj);
    }
}
