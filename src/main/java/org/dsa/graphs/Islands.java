package org.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
public class Islands {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 1, 0}
        };
        islands(grid);
    }

    // TC -> O(n^2)
    // SC -> O(n^2)
    public static void islands(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                    bfs(i, j, grid, vis);
                }
            }
        }

        System.out.println("No of islands: " + count);
    }

    public static void bfs(int row, int col, int[][] grid, boolean[][] vis) {

        int n = grid.length;;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        vis[row][col] = true;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            row = pair.row;
            col = pair.col;

            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int nRow = row + delRow;
                    int nCol = col + delCol;

                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && !vis[nRow][nCol]) {
                        vis[nRow][nCol] = true;
                        q.offer(new Pair(nRow, nCol));
                    }
                }
            }
        }
    }
}
