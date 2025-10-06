package org.dsa.graphs.disjoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IslandsTwo {

    public static void main(String[] args) {

        List<List<Integer>> pair = new ArrayList<>();
        pair.add(Arrays.asList(0, 0));
        pair.add(Arrays.asList(0, 0));
        pair.add(Arrays.asList(1, 1));
        pair.add(Arrays.asList(1, 0));
        pair.add(Arrays.asList(0, 1));
        pair.add(Arrays.asList(0, 3));
        pair.add(Arrays.asList(1, 3));
        pair.add(Arrays.asList(0, 4));
        pair.add(Arrays.asList(3, 2));
        pair.add(Arrays.asList(2, 2));
        pair.add(Arrays.asList(1, 2));
        pair.add(Arrays.asList(0, 2));


        int n = 5;
        int m = 5;
        int[][] mat = new int[n][m];


        List<Integer> sol = island(mat, pair);
        System.out.println(Arrays.toString(sol.toArray()));
    }

    public static List<Integer> island(int[][] mat, List<List<Integer>> pair) {

        int n = mat.length;
        int m = mat[0].length;
        int total = n * m;
        int[][] vis = new int[n][m];

        DisjointSet set = new DisjointSet(total - 1);
        List<Integer> res = new ArrayList<>();
        int count = 0;

        int[] dRow = {0, 0, -1, 1};
        int[] dCol = {-1, 1, 0, 0};

        for (List<Integer> edge : pair) {
            int u = edge.get(0);
            int v = edge.get(1);

            if (vis[u][v] == 1) {
                res.add(count);
                continue;
            }

            vis[u][v] = 1;
            count++;

            for (int i = 0; i < 4; i++) {
                int nRow = u + dRow[i];
                int nCol = v + dCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
                    if (vis[nRow][nCol] == 1) {
                        int node = u * m + v;
                        int adjNode = nRow * m + nCol;
                        if (set.findUParent(node) != set.findUParent(adjNode)) {
                            count--;
                            set.unionBySize(node, adjNode);
                        }
                    }
                }
            }

            res.add(count);
        }

        return res;
    }
}
