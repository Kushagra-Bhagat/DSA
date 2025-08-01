package org.dsa.dp;

import java.util.Arrays;

public class UniquePathWithObstacles {
    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, -1},
                {0, -1, 0},
                {0, 0, 0}
        };
        System.out.println("Using recursion: " + path(mat, 0, 0));
        int[][] dp = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Using memoization: " + pathMemo(mat, dp, 0, 0));
        System.out.println("Using Tabulation: " + pathTabu(mat));
        System.out.println("Space optimized: " + pathOpt(mat));
    }

    public static int path(int[][] mat, int row, int col) {
        if (mat[row][col] == -1) {
            return 0;
        }
        if (row == mat.length - 1 && col == mat[0].length - 1) {
            return 1;
        }
        int down = 0, right = 0;
        if (row < mat.length - 1)
            down = path(mat, row + 1, col);
        if (col < mat[0].length - 1)
            right = path(mat, row, col + 1);
        return right + down;
    }

    public static int pathMemo(int[][] mat, int[][] dp, int row, int col) {
        if (row == mat.length - 1 && col == mat[0].length - 1) {
            return 1;
        }
        if (mat[row][col] == -1) {
            dp[row][col] = 0;
            return 0;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int down = 0, right = 0;
        if (row < mat.length - 1)
            down = pathMemo(mat, dp,row + 1, col);
        if (col < mat[0].length - 1)
            right = pathMemo(mat, dp, row, col + 1);
        dp[row][col] = right + down;
        return dp[row][col];
    }

    public static int pathTabu(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        if (mat[0][0] == -1 || mat[n-1][m-1] == -1) {
            return 0;
        }

        int[][] dp = new int[n][m];
        for (int row = n - 1; row >= 0; row--) {
            if (mat[row][m - 1] == -1) {
                break;
            }
            dp[row][m - 1] = 1;
        }

        for (int col = m - 1; col >= 0; col--) {
            if (mat[n - 1][col] == -1) {
                break;
            }
            dp[n - 1][col] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (mat[i][j] == -1) {
                    continue;
                }
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    public static int pathOpt(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        if (mat[0][0] == -1 || mat[n-1][m-1] == -1) {
            return 0;
        }

        int[] dp = new int[m];

        for (int j = m - 1; j >= 0; j--) {
            if (mat[n - 1][j] == -1) {
                break;
            }
            dp[j] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            // Important because obstacle can be in last column
            // you didnt need it in without obstacle because whole last column is 1.
            if (mat[i][m - 1] == -1) {
                dp[m - 1] = 0;
            }
            for (int j = m - 2; j >= 0; j--) {
                if (mat[i][j] == -1) {
                    dp[j] = 0;
                    continue;
                }
                dp[j] = dp[j] + dp[j + 1];
            }
        }

        return dp[0];
    }
}
