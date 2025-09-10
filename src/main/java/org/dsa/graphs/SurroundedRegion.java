package org.dsa.graphs;

import java.util.Arrays;

public class SurroundedRegion {

    public static void main(String[] args) {

        char[][] grid = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}
        };

        surround(grid);

        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    // TC -> O(n*m)
    // SC -> O(n*m) + O(n*m)
    public static void surround(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && grid[i][j] == 'O') {
                    dfs(i, j, grid, vis);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(int row, int col, char[][] grid, boolean[][] vis) {

        int n = grid.length;
        int m = grid[0].length;

        vis[row][col] = true;
        int[] dRow = {0, 0, -1, 1};
        int[] dCol = {-1, 1, 0, 0};

        for (int i = 0; i < dRow.length; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                    && !vis[nRow][nCol]
                    && grid[nRow][nCol] == 'O') {
                dfs(nRow, nCol, grid, vis);
            }
        }
    }
}
