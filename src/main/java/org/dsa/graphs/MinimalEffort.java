package org.dsa.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// TC -> E log V -> n * m * 4 * log (n * m)
// SC -> O(n * m)
public class MinimalEffort {
    public static void main(String[] args) {

        int[][] mat = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
    }

    public static int path(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<DistanceMatrix> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        pq.offer(new DistanceMatrix(0, 0, 0));

        int[] dRow = {0, 0, -1, 1};
        int[] dCol = {-1, 1, 0, 0};

        while (!pq.isEmpty()) {
            int distance = pq.peek().distance;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.poll();

            if (row == n - 1 && col == m - 1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
                    int newEffort = Math.max(Math.abs(mat[row][col] - mat[nRow][nCol]), distance);
                    if (newEffort < dist[nRow][nCol]) {
                        dist[nRow][nCol] = newEffort;
                        pq.offer(new DistanceMatrix(newEffort, nRow, nCol));
                    }
                }
            }
        }

        return 0;
    }
}
