package org.dsa.graphs;

import java.util.ArrayList;
import java.util.List;


// O(V + E)
// O(V)
public class DFS {
    static void addEdge(List<List<Integer>> list, int a, int b) {
        list.get(a).add(b);
        list.get(b).add(a);
    }

    static void traversal(List<List<Integer>> adj, boolean[] visited, int s) {
        visited[s] = true;
        System.out.print(s + " ");

        for (int i : adj.get(s)) {
            if (!visited[i]) {
                traversal(adj, visited, i);
            }
        }
    }

    static void DFS(List<List<Integer>> adj, int s) {
        boolean[] visited = new boolean[adj.size()];
        traversal(adj, visited, s);

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                traversal(adj, visited, i);
            }
        }
    }


    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 1, 2);
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 4, 5);
        DFS(adj, 0);
    }
}
