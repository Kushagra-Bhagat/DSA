package org.dsa.dp;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        int[][] mat = {
                {1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}
        };
        System.out.println("Using recursion: " + maxPoint(mat, 0, 0));
        int[][] dp = new int[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Using memoization: " + maxPointMemo(mat, dp, 0, 0));
        System.out.println("Using tabulation: " + maxPointsTabu(mat));
        System.out.println("Using optimization: " + maxPointsOpt(mat));
    }

    // TC -> O(2^n)
    // SC -> O(n) -> recursion stack space
    public static int maxPoint(int[][] mat, int row, int col) {

        if (row == mat.length - 1) {
            return mat[row][col];
        }

        int same = mat[row][col] + maxPoint(mat, row + 1, col);
        int notSame = mat[row][col] + maxPoint(mat, row + 1, col + 1);
        return Math.min(same, notSame);
    }

    // for grid always easier to do tabulation
    // Also, depends on how your recursion is then you can bottom-up or top-down
    // TC -> O(n^2) -> each cell of 2d array dp is computed once
    // SC -> O(n^2) + O(n)
    public static int maxPointMemo(int[][] mat, int[][] dp, int row, int col) {
        if (row == mat.length - 1) {
            return mat[row][col];
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int same = mat[row][col] + maxPointMemo(mat, dp, row + 1, col);
        int notSame = mat[row][col] + maxPointMemo(mat, dp, row + 1, col + 1);
        dp[row][col] = Math.min(same, notSame);
        return dp[row][col];
    }

    // TC -> O(n^2) -> double for loop
    // SC -> O(n^2)
    public static int maxPointsTabu(int[][] mat) {
        int n = mat.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[n - 1][i] = mat[n - 1][i];
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col = row; col >= 0; col--) {
                dp[row][col] = mat[row][col] + Math.min(dp[row + 1][col], dp[row + 1][col + 1]);
            }
        }
        return dp[0][0];
    }

    // TC -> O(n^2)
    // SC -> O(n)
    public static int maxPointsOpt(int[][] mat) {
        int n = mat.length;
        int[] dp = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = mat[n - 1][i];
        }

        for (int row = n - 2; row >= 0; row--) {
            int next = dp[row + 1];
            for (int col = row; col >= 0; col--) {
                int minVal = mat[row][col] + Math.min(dp[col], next);
                next = dp[col];
                dp[col] = minVal;
            }
        }
        return dp[0];
    }
}
