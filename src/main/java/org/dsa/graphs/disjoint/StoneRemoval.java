package org.dsa.graphs.disjoint;

import java.util.HashSet;
import java.util.Set;

public class StoneRemoval {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0},
                {0, 2},
                {1, 3},
                {3, 1},
                {3, 2},
                {4, 3}
        };

        System.out.println("Stones removed: " + stones(grid));
    }

    public static int stones(int[][] grid) {

        int maxRow = 0;
        int maxCol = 0;
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, grid[i][0]);
            maxCol = Math.max(maxCol, grid[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int nodeRow = grid[i][0];
            int nodeCol = grid[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            set.add(nodeRow);
            set.add(nodeCol);
        }

        int cnt = 0;
        for (int val : set) {
            if (ds.findUParent(val) == val) {
                cnt++;
            }
        }

        return n - cnt;
    }
}
