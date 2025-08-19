package org.dsa.dp.partition;

import java.util.Arrays;

public class MatrixMultiplication {

    public static void main(String[] args) {


        // A -> 10 X 20, B -> 20 x 30
        int[] ar = {10, 20, 30, 40, 50};
        int n = ar.length;

        System.out.println("minimum no of operations: " + mcm(ar, 1, n - 1));

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("using memoization: " + mcmMemo(dp, ar, 1, n - 1));
        System.out.println("using tabulation: " + mcmTabu(ar));
    }

    public static int mcm(int[] ar, int i, int j) {
        if (i == j) {
            return 0;
        }

        int minSteps = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            // We calculate steps for this array, then break it
            int steps = (ar[i - 1] * ar[k] * ar[j]) + mcm(ar, i, k) + mcm(ar, k + 1, j);
            minSteps = Math.min(minSteps, steps);
        }

        return minSteps;
    }

    // dp[i][j] -> minimum no of steps to solve multiplication of matrices A(i) to A(j)
    // TC -> O(n^3) -> visiting every cell once and also we run the loop appx n times
    // SC -> O(n^2) + recursion stack
    public static int mcmMemo(int[][] dp, int[] ar, int i, int j) {

        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int minSteps = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            // We calculate steps for this array, then break it
            int steps = (ar[i - 1] * ar[k] * ar[j]) + mcmMemo(dp, ar, i, k) + mcmMemo(dp, ar, k + 1, j);
            minSteps = Math.min(minSteps, steps);
        }

        dp[i][j] = minSteps;
        return dp[i][j];
    }

    // TC -> O(n^3)
    public static int mcmTabu(int[] ar) {

        int n = ar.length;
        int[][] dp = new int[n][n];

        // base case dp[i][j] = 0 for i == j.

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int minSteps = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps = (ar[i - 1] * ar[k] * ar[j]) + dp[i][k] + dp[k + 1][j];
                    minSteps = Math.min(minSteps, steps);
                }
                dp[i][j] = minSteps;
            }
        }

        return dp[1][n - 1];
    }
}
