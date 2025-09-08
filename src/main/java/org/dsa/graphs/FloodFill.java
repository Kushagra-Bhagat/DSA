package org.dsa.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 1},
                {2, 2, 0},
                {2, 1, 2},
        };

        int row = 2;
        int col = 0;
        colour(row, col, 3, grid);

        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    // TC -> O(n*m)
    // SC -> O(n*n)
    public static void colour(int row, int col, int pixel, int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int originalColor = grid[row][col];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        vis[row][col] = true;

        int[] dRow = {0, 0, -1, 1};
        int[] dCol = {-1, 1, 0, 0};

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            row = pair.row;
            col = pair.col;
            grid[row][col] = pixel;

            for (int i = 0; i < dRow.length; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                && grid[nRow][nCol] == originalColor
                && !vis[nRow][nCol]) {
                    vis[nRow][nCol] = true;
                    q.offer(new Pair(nRow, nCol));
                }
            }
        }
    }
}
