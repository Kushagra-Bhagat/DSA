package org.dsa.dp.recursion;

// can start anywhere on first row and end anywhere on last row
    public class MaxPathForVariablePoints {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}
        };
        int maxVal = Integer.MIN_VALUE;
        for (int col = 0; col < mat[0].length; col++) {
            int val = maxPoints(mat, 0, col);
            maxVal = Math.max(maxVal, val);
        }
        System.out.println(maxVal);
        System.out.println(maxPointsTabu(mat));
        System.out.println(maxPointsOPt(mat));
    }

    public static int maxPoints(int[][] mat, int row, int col) {
        if (row == mat.length - 1) {
            return mat[row][col];
        }

        int left = mat[row][col];
        if (col > 0) {
            left += maxPoints(mat, row + 1, col - 1);
        }
        int middle = mat[row][col] + maxPoints(mat, row + 1, col);
        int right = mat[row][col];
        if (col < mat[row].length - 1) {
            right += maxPoints(mat, row + 1, col + 1);
        }
        return Math.max(left, Math.max(middle, right));
    }

    public static int maxPointsMemo(int[][] mat, int[][] dp, int row, int col) {

        if (col < 0 || col >= mat[row].length) {
            return Integer.MIN_VALUE;
        }

        if (row == mat.length - 1) {
            return mat[row][col];
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int left = mat[row][col] + maxPointsMemo(mat, dp, row + 1, col - 1);
        int middle = mat[row][col] + maxPointsMemo(mat, dp, row + 1, col);
        int right = mat[row][col] + maxPointsMemo(mat, dp, row + 1, col + 1);
        dp[row][col] = Math.max(left, Math.max(middle, right));
        return dp[row][col];
    }

    public static int maxPointsTabu(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];

        for (int col = 0; col < m - 1; col++) {
            dp[0][col] = mat[0][col];
        }

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < m; col++) {
                int left = mat[row][col];
                if (col > 0) {
                    left += dp[row - 1][col - 1];
                }
                int middle = mat[row][col] + dp[row - 1][col];
                int right = mat[row][col];
                if (col < m - 1) {
                    right += dp[row - 1][col + 1];
                }
                dp[row][col] = Math.max(left, Math.max(middle, right));
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for (int col = 0; col < m; col++) {
            maxVal = Math.max(maxVal, dp[n - 1][col]);
        }
        return maxVal;
    }

    public static int maxPointsOPt(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] dp = new int[m];
        int[] values = new int[3];

        for (int col = 0; col < m; col++) {
            dp[col] = mat[0][col];
        }

        for (int row = 1; row < n; row++) {
            int[] newDp = new int[m];
            for (int col = 0; col < m; col++) {
                values[0] = Integer.MIN_VALUE;
                if (col > 0) {
                    values[0] = dp[col - 1];
                }
                values[1] = dp[col];
                values[2] = Integer.MIN_VALUE;
                if (col < m - 1) {
                    values[2] = dp[col + 1];
                }

                int val = Math.max(values[0], Math.max(values[1], values[2]));
                newDp[col] = mat[row][col] + val;
            }
            dp = newDp;
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
