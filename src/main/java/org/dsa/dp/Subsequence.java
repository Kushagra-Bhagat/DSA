package org.dsa.dp;

import java.util.Arrays;

public class Subsequence {

    public static void main(String[] args) {
        int[] ar = {2, 4, 6, 10};
        int k = 16;
        System.out.println(sum(ar, ar.length - 1, k));
        int[][] dp = new int[ar.length][k + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Using memoization: " + sumMemo(ar, dp, ar.length - 1, k));
        System.out.println("Using tabulation: " + sumTabu(ar, k));
        System.out.println("Using space optimization: " + sumOpt(ar, k));
    }

    // TC -> O(2^n)
    // SC -> O(n)
    public static boolean sum(int[] ar, int idx, int sum) {
        if (sum == 0) {
            return true;
        }
        if (idx < 0) {
            return false;
        }
        return sum(ar, idx - 1, sum - ar[idx]) || sum(ar, idx - 1, sum);
    }

    // TC, SC -> O(N * k)
    public static boolean sumMemo(int[] ar, int[][] dp, int idx, int sum) {
        if (sum == 0) {
            return true;
        }
        if (idx < 0 || sum < 0) {
            return false;
        }
        if (dp[idx][sum] != -1) {
            return dp[idx][sum] == 0;
        }
        boolean take = sumMemo(ar, dp, idx - 1, sum - ar[idx]);
        boolean notTake = sumMemo(ar, dp, idx - 1, sum);
        dp[idx][sum] = (take || notTake) ? 0 : 1;
        return take || notTake;
    }

    public static boolean sumTabu(int[] ar, int sum) {

        int n = ar.length;
        boolean[][] dp = new boolean[n][sum + 1];

        // we can achieve sum 0 from anywhere by leaving all elements
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (ar[0] <= sum) {
            dp[0][ar[0]] = true;
        }

        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[0].length; col++) {
                boolean notTake = dp[row - 1][col];
                boolean take = false;
                if (ar[row] <= col) {
                    take = dp[row - 1][col - ar[row]];
                }
                dp[row][col] = take || notTake;
            }
        }

        return dp[n - 1][sum];
    }

    public static boolean sumOpt(int[] ar, int total) {

        boolean[] prev = new boolean[total + 1];

        prev[0] = true;
        if (ar[0] <= total) {
            prev[ar[0]] =  true;
        }

        for (int i = 1; i < ar.length; i++) {
            boolean[] curr = new boolean[total + 1];
            curr[0] = true;
            for (int j = 1; j <= total; j++) {
                boolean notTake = prev[j];
                boolean take = false;
                if (ar[i] <= j) {
                    take = prev[j - ar[i]];
                }
                curr[j] = notTake || take;
            }
            prev = curr;
        }
        return prev[total];
    }
}
