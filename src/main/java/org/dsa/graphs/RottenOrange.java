package org.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

// 0 -> no orange
// 1 -> nice orange
// 2 -> rotten orange
public class RottenOrange {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 2},
                {0, 1, 1},
                {2, 1, 1}
        };

        orange(grid);
    }

    // TC -> O(n*m)
    // SC -> O(n*m)
    public static void orange(int[][] grid) {

        int n = grid.length;;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        int[] dRow = {0, 0, -1, 1};
        int[] dCol = {-1, 1, 0, 0};
        int count = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            boolean rotten = false;
            for (int idx = 0; idx < size; idx++) {
                Pair pair = q.poll();
                int row = pair.row;
                int col = pair.col;

                for (int i = 0; i < dRow.length; i++) {
                    int nRow = row + dRow[i];
                    int nCol = col + dCol[i];

                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                            && grid[nRow][nCol] == 1
                            && !vis[nRow][nCol]) {

                        vis[nRow][nCol] = true;
                        q.offer(new Pair(nRow, nCol));
                        grid[nRow][nCol] = 2;
                        rotten = true;
                    }
                }
            }

            if (rotten) {
                count++;
            }
        }

        System.out.println("Time taken: " + count);
    }
}
