package org.dsa.graphs;

import java.util.Arrays;


// O(V^3)
// good for dense graphs
// gives all pairs shortest path
public class FloydWarshall {
    final static int INF = 9999, V = 4;

    static int[][] allPairShortest(int[][] dist) {
        int i, j, k;

        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if(dist[k][j] + dist[i][k] < dist[i][j]) {
                        dist[i][j] = dist[k][j] + dist[i][k];
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 5, INF, 10},
                        {INF, 0, 3, INF},
                        {INF, INF, 0, 1},
                        {INF, INF, INF, 0}};

        int[][] result = allPairShortest(graph);

        System.out.println(Arrays.deepToString(result));
    }


}
