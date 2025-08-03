package org.dsa.dp;

import java.util.Arrays;

public class NinjaAndHisFriends {
    public static void main(String[] args) {
        int[][] mat = {
                {3,1,1},
                {2,5,1},
                {1,5,5},
                {2,1,1}
        };
        System.out.println("using recursion: " + maxChoco(mat, 0 , 0, mat[0].length - 1));
        int n = mat.length;
        int m = mat[0].length;
        int[][][] dp = new int[n][m][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println("Using memoization: " + maxChocoMemo(mat, dp, 0, 0, m - 1));
    }

    // TC -> O(3^n * 3^n)
    // SC -> O(n)
    public static int maxChoco(int[][] mat, int row, int col1, int col2) {

        if (col1 < 0 || col1 > mat[0].length - 1 || col2 < 0 || col2 > mat[0].length - 1) {
            return Integer.MIN_VALUE;
        }

        if (row == mat.length - 1) {
            if (col1 == col2) {
                return mat[row][col1];
            }
            return mat[row][col1] + mat[row][col2];
        }

        int[] path = {-1, 0, 1};
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                int val;
                if (col1 == col2) {
                    val = mat[row][col1];
                }
                else {
                    val = mat[row][col1] + mat[row][col2];
                }
                // doing one step for both players at the same time
                val += maxChoco(mat, row + 1, col1 + path[i], col2 + path[j]);
                maxVal = Math.max(maxVal, val);
            }
        }
        return maxVal;
    }

    public static int maxChocoMemo(int[][] mat, int[][][] dp, int row, int col1, int col2) {
        if (col1 < 0 || col1 > mat[0].length - 1 || col2 < 0 || col2 > mat[0].length - 1) {
            return Integer.MIN_VALUE;
        }

        if (row == mat.length - 1) {
            if (col1 == col2) {
                return mat[row][col1];
            }
            return mat[row][col1] + mat[row][col2];
        }

        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }

        int[] path = {-1, 0, 1};
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                int val;
                if (col1 == col2) {
                    val = mat[row][col1];
                }
                else {
                    val = mat[row][col1] + mat[row][col2];
                }
                // doing one step for both players at the same time
                val += maxChocoMemo(mat, dp, row + 1, col1 + path[i], col2 + path[j]);
                maxVal = Math.max(maxVal, val);
            }
        }
        dp[row][col1][col2] = maxVal;
        return dp[row][col1][col2];
    }

    public static int maxChocoTabu(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][][] dp = new int[n][m][m];
        for (int col1 = 0; col1 < m; col1++) {
            for (int col2 = 0; col2 < m; col2++) {
                if (col1 == col2) {
                    dp[n - 1][col1][col2] = mat[n - 1][col1];
                }
                else {
                    dp[n - 1][col1][col2] = mat[n - 1][col1] + mat[n - 1][col2];
                }
            }
        }

        for (int i = n - 2; i >= 0; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    // Here you can write but very tough better to stick with memo
                }
            }
        }
    }
}
