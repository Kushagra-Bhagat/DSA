package org.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Province {

    public static void main(String[] args) {
        //       2  - 5     6    8
        //     /   \ /     /
        //    1     4     7
        //     \   /
        //       3

        int[][] adj = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        countProvinces(adj, 8);
    }


    public static void countProvinces (int[][] adj, int v) {

        int count = 0;
        boolean[] vis = new boolean[v + 1];

        for (int i = 1; i <= v; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, adj, vis);
            }
        }

        System.out.println("No of province: " + count);
    }
    public static void dfs(int node, int[][] adj, boolean[] vis) {

        vis[node] = true;

        for (int i = 1; i < adj[node].length; i++) {
            if (adj[node][i] != 0 && !vis[i]) {
                dfs(i, adj, vis);
            }
        }
    }
}
