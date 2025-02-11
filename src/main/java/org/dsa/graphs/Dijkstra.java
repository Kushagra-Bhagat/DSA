package org.dsa.graphs;

import java.util.Arrays;

// Doesn't work if negative cycle present because once a vertex is added we are sure of the path.

// O(V^2)// Can be optimized using heaps
public class Dijkstra {

    static void dijkstra(int[][] graph, int src) {
        int v = graph.length;
        int[] dist = new int[v];
        boolean[] spSet = new boolean[v];

        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        // Because shortest distance would have v-1 edges
        for (int count = 0; count < v - 1; count++) {
            int u = minDist(spSet, dist);

            spSet[u] = true;

            for (int i = 0; i < v; i++) {
                if (!spSet[i] && graph[u][i] != 0
                    && dist[u] + graph[u][i] < dist[i]) {
                    dist[i] = dist[u] + graph[u][i];
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }


    static int minDist(boolean[] spSet, int[] dist) {
        int v = dist.length;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < v; i++) {
            if(!spSet[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int graph[][]
                = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        dijkstra(graph, 0);
    }
}
