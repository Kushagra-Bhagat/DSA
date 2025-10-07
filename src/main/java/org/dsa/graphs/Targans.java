package org.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TC -> O(V + E)
// SC -> O(V)
public class Targans {

    public static void main(String[] args) {

        List<List<Integer>> connections = new ArrayList<>();
        int n = 5;

        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 3));

        Targans graph = new Targans();
        List<List<Integer>> bridges = graph.criticalConnections(connections, n);

        System.out.println("Bridges: " + Arrays.toString(bridges.toArray()));

    }

    public List<List<Integer>> criticalConnections(List<List<Integer>> connections, int n) {

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            adjList.get(edge.get(0)).add(edge.get(1));
        }

        int[] vis = new int[n];
        int[] time = new int[n];
        int[] low = new int[n];


        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, adjList, vis, time, low, bridges);
        return bridges;
    }

    private int timer = 1;
    public void dfs(int node, int parent, List<List<Integer>> adjList, int[] vis, int[] time, int[] low, List<List<Integer>> bridges) {

        vis[node] = 1;
        time[node] = low[node] = timer;
        timer++;

        for (int it : adjList.get(node)) {
            if (it == parent) continue;
            if (vis[it] == 0) {
                dfs(it, node, adjList, vis, time, low, bridges);
                low[node] = Math.min(low[node], low[it]);

                if (low[it] > time[node]) {
                    bridges.add(Arrays.asList(node, it));
                }
            }
            else {
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
}
