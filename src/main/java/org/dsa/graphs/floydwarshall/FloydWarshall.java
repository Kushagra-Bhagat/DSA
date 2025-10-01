package org.dsa.graphs.floydwarshall;

import java.util.Arrays;

public class FloydWarshall {
    public static void main(String[] args) {

        int[][] mat = {
                {0, 2, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {1, 0, 3, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE},
                {3, 5, 4, 0}
        };

        int[][] res = shortestPath(mat);

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    // TC -> O(n^3)
    // SC -> O(n^2)
    public static int[][] shortestPath(int[][] mat) {

        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k == i) {
                        continue;
                    }
                    if (mat[j][i] != Integer.MAX_VALUE && mat[i][k] != Integer.MAX_VALUE && mat[j][i] + mat[i][k] < mat[j][k]) {
                        mat[j][k] = mat[j][i] + mat[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == Integer.MAX_VALUE) {
                    mat[i][j] = -1;
                }
            }
        }

        return mat;
    }
}
