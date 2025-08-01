package org.dsa.dp;

import java.util.Arrays;

// Without Obstacles
public class UniquePath {

    public static void main(String[] args) {
        int[][] ar = {
                {2, 2},
                {1, 1}
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

    // O(2^m+n)
    public static int paths(int[][] arr, int row, int col) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            return 1;
        }
        int moveRight = 0;
        int moveDown = 0;
        if (col != arr[0].length - 1) {
            moveRight = paths(arr, row, col + 1);
        }
        if (row != arr.length - 1) {
            moveDown = paths(arr, row + 1, col);
        }
        return moveRight + moveDown;
    }

    // dp[i][j] will store unique path from cell(i, j) to cell(n-1, m-1)
    // O(mn) -> Time complexity
    // O(mn) + O(mn) ->  for space complexity
    public static int pathsMemo(int[][] arr, int[][] dp, int row, int col) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            return 1;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int moveRight = 0;
        int moveDown = 0;
        if (col != arr[0].length - 1) {
            moveRight = pathsMemo(arr, dp, row, col + 1);
        }
        if (row != arr.length - 1) {
            moveDown = pathsMemo(arr, dp, row + 1, col);
        }
        dp[row][col] = moveRight + moveDown;
        return dp[row][col];
    }

    // O(mn) -> time and space no recursion stack
    public static int pathsTabu(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        for (int row = 0; row < arr.length; row++) {
            dp[row][m - 1] = 1;
        }
        for (int col = 0; col < arr[0].length; col++) {
            dp[n - 1][col] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    public static int pathsOpt(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[] dp = new int[m];

        // Covers 1x1, 1xm, nx1
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        return dp[0];
    }
}
