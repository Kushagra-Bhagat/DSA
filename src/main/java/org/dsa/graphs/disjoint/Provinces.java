package org.dsa.graphs.disjoint;

public class Provinces {

    public static void main(String[] args) {

        int[][] adj = {
                {0, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0}
        };

        System.out.println("no of provinces: " + noOfProvinces(adj));
    }

    public static int noOfProvinces (int[][] adj) {

        int n = adj.length;

        DisjointSet set = new DisjointSet(n - 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj[i][j] == 1) {
                    set.unionBySize(i, j);
                }
            }
        }

        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (set.findUParent(i) == i) {
                provinces++;
            }
        }

        return provinces;
    }
}
