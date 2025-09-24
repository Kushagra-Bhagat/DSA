package org.dsa.graphs;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class DistanceMatrix {
    int distance;
    int row;
    int col;

    public DistanceMatrix(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

// since the distance between each adjacent node is 1, we can use queue to remove log n of priority queue
public class BinaryMazeShortestDistance {
    public static void main(String[] args) {

        int[][] mat = {
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 0}
        };

        int rowSource = 0;
        int colSource = 1;
        int rowDestination = 2;
        int colDestination = 2;

        System.out.println("Shortest path: " + shortestDistance(mat, rowSource, colSource, rowDestination, colDestination));
    }

    public static int shortestDistance(int[][] mat, int rowSource, int colSource, int rowDestination, int colDestination) {

        if (rowSource == rowDestination && colSource == colDestination) {
            return 0;
        }

        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[rowSource][colSource] = 0;

        Queue<DistanceMatrix> q = new LinkedList<>();
        q.offer(new DistanceMatrix(0, rowSource, colSource));

        int[] dRow = {0, 0, -1, 1};
        int[] dCol = {-1, 1, 0, 0};

        while (!q.isEmpty()) {
            int distance = q.peek().distance;
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && distance + 1 < dist[nRow][nCol]) {
                    dist[nRow][nCol] = 1 + distance;
                    if (nRow == rowDestination && nCol == colDestination) {
                        return dist[nRow][nCol];
                    }
                    q.offer(new DistanceMatrix(dist[nRow][nCol], nRow, nCol));
                }
            }
        }

        return -1;
    }
}
