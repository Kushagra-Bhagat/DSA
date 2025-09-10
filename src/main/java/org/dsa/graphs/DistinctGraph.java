package org.dsa.graphs;

import java.util.*;

public class DistinctGraph {
    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };

        System.out.println("No of distinct islands: " + distinct(grid));
    }

    public static int distinct(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                     set.add(bfs(i, j, vis, grid));
                }
            }
        }

        for (List<Integer> res : set) {
            System.out.println(res);
        }

        return set.size();
    }

    public static List<Integer> bfs (int row, int col, boolean[][] vis, int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        vis[row][col] = true;

        List<Integer> res = new ArrayList<>();

        int[] dRow = {0, 0, -1, 1};
        int[] dCol = {-1, 1, 0, 0};

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int currRow = pair.row;
            int currCol = pair.col;

            int rowVal = currRow - row;
            int colVal = currCol - col;
            res.add(rowVal);
            res.add(colVal);

            for (int i = 0; i < dRow.length; i++) {
                int nRow = currRow + dRow[i];
                int nCol = currCol + dCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                        && grid[nRow][nCol] == 1
                        && !vis[nRow][nCol]) {
                    vis[nRow][nCol] = true;
                    q.offer(new Pair(nRow, nCol));
                }
            }
        }

        return res;
    }
}
