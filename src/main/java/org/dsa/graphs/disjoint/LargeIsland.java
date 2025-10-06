package org.dsa.graphs.disjoint;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargeIsland {

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 0, 1},
                {1, 0, 1, 0},
                {1, 0, 0, 0},
                {0, 1, 0, 1}
        };

        System.out.println(sum(grid));
    }

    // TC -> O(n * m)
    public static int sum (int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        DisjointSet set = new DisjointSet(n * m);

        int[] dRow = {0, 0, -1, 1};
        int[] dCol = {-1, 1, 0, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {
                    int nRow = i + dRow[k];
                    int nCol = j + dCol[k];

                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1) {
                        int node = i * m + j;
                        int adjNode = nRow * m + nCol;
                        set.unionBySize(node, adjNode);
                    }
                }
            }
        }

        int mx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }

                Set<Integer> parent = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int nRow = i + dRow[k];
                    int nCol = j + dCol[k];

                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1) {
                        int node = i * m + j;
                        int adjNode = nRow * m + nCol;
                        parent.add(set.findUParent(adjNode));
                    }
                }

                int size = 1;
                for (int parentVal : parent) {
                    size += set.size.get(parentVal);
                }

                mx = Math.max(mx, size);
            }
        }

        for (int i = 0; i < n * m; i++) {
            mx = Math.max(mx, set.size.get(set.findUParent(i)));
        }

        return mx;
    }
}
