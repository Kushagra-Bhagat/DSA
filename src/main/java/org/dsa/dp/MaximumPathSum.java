package org.dsa.dp;

import java.util.Arrays;

// Without obstacles
// start from (0,0) and end at (n-1,n-1)
public class MaximumPathSum {
    public static void main(String[] args) {
        int[][] ar = {
                {5, 9, 6},
                {11, 5, 2}
        };
        System.out.println("Paths with recursion: " + paths(ar, 0, 0));
        int[][] dp = new int[ar.length][ar[0].length];
        for (int i = 0; i < ar.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Using memoization: " + pathsMemo(ar, dp, 0, 0));
        System.out.println("Using Tabulation: " + pathsTabu(ar));
        System.out.println("Space optimized: " + pathsOpt(ar));
    }

    public static int paths(int[][] arr, int row, int col) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            return arr[row][col];
        }
        int moveRight = 0;
        int moveDown = 0;
        if (col != arr[0].length - 1) {
            moveRight = arr[row][col] + paths(arr, row, col + 1);
        }
        if (row != arr.length - 1) {
            moveDown = arr[row][col] + paths(arr, row + 1, col);
        }
        return Math.max(moveRight, moveDown);
    }

    public static int pathsMemo(int[][] arr, int[][] dp, int row, int col) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            dp[row][col] = arr[row][col];
            return dp[row][col];
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int moveRight = 0;
        int moveDown = 0;
        if (col < arr[0].length - 1) {
            moveRight = arr[row][col] + pathsMemo(arr, dp, row, col + 1);
        }
        if (row < arr.length - 1) {
            moveDown = arr[row][col] + pathsMemo(arr, dp, row + 1, col);
        }
        dp[row][col] = Math.max(moveRight, moveDown);
        return dp[row][col];
    }

    public static int pathsTabu(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = arr[n - 1][m - 1];

        for (int row = n - 2; row >= 0; row--) {
            dp[row][m - 1] = arr[row][m - 1] + dp[row + 1][m - 1];
        }
        for (int col = m - 2; col >= 0; col--) {
            dp[n - 1][col] = arr[n - 1][col] + dp[n - 1][col + 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = arr[i][j] + Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

    public static int pathsOpt(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[] dp = new int[m];
        dp[m - 1] = arr[n - 1][m - 1];

        // Covers 1x1, 1xm, nx1
        for (int i = m - 2; i >= 0; i--) {
            dp[i] = arr[n - 1][i] + dp[i + 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1] = dp[m - 1] + arr[i][m - 1];
            for (int j = m - 2; j >= 0; j--) {
                dp[j] = arr[i][j] + Math.max(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
