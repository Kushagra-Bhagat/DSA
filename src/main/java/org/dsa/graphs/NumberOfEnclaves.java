package org.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };

        System.out.println("count: " + enclave(grid));
    }

    public static int enclave(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1|| j == m - 1) && grid[i][j] == 1 && !vis[i][j]) {
                    bfs(i, j, vis, grid);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void bfs(int row, int col, boolean[][] vis, int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        vis[row][col] = true;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            row = pair.row;
            col = pair.col;

            int[] dRow = {0, 0, -1, 1};
            int[] dCol = {-1, 1, 0, 0};

            for (int i = 0; i < dRow.length; i++) {

                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                        && grid[nRow][nCol] == 1
                        && !vis[nRow][nCol]) {
                    vis[nRow][nCol] = true;
                    q.offer(new Pair(nRow, nCol));
                }
            }
        }
    }
}
