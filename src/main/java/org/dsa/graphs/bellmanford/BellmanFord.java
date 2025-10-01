package org.dsa.graphs.bellmanford;

import java.util.Arrays;
import java.util.List;


public class BellmanFord {

    public static void main(String[] args) {
        int V = 6;
        WeightedGraph graph = new WeightedGraph();
        graph.addEdge(3,2,6);
        graph.addEdge(5,3,1);
        graph.addEdge(0,1,5);
        graph.addEdge(1,5,-3);
        graph.addEdge(1,2,-2);
        graph.addEdge(3,4,-2);
        graph.addEdge(2,4,3);

        List<List<Integer>> adjList = graph.getAdjList();

        System.out.println("Shortest distance array: " + Arrays.toString(bellman(adjList, 0, V)));
    }

    // TC -> O(V * E)
    public static int[] bellman(List<List<Integer>> adjList, int src, int V) {

        int n = V;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (List<Integer> it : adjList) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for (List<Integer> it : adjList) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return dist;
    }
}
