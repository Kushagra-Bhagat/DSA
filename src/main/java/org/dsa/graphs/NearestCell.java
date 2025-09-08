package org.dsa.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// nearest cell with value = 1
public class NearestCell {
    public static void main(String[] args) {

        int[][] grid = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 0, 0}
        };

        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    res[i][j] = 0;
                }
                else {
                    res[i][j] = nearest(i, j, grid);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    // TC -> O(n^2 * m^2) - because bfs over every cell (worst 0 matrix)
    // SC -> O(n * m)
    public static int nearest(int row, int col, int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = true;

        int[] dRow = {0, 0, -1, 1};
        int[] dCol = {-1, 1, 0, 0};
        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int idx = 0; idx < size; idx++) {
                Pair pair = q.poll();
                row = pair.row;
                col = pair.col;
                for (int i = 0; i < dRow.length; i++) {
                    int nRow = row + dRow[i];
                    int nCol = col + dCol[i];

                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !vis[nRow][nCol]) {
                        if (grid[nRow][nCol] == 1) {
                            return distance + 1;
                        }
                        else {
                            q.offer(new Pair(nRow, nCol));
                            vis[nRow][nCol] = true;
                        }
                    }
                }
            }

            distance++;
        }

        return -1;
    }
}
