package org.dsa.dp.subsequence;

import java.util.Arrays;

// divide into two subsets with s1 - s2 = d
// same as that
public class TargetSum {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 1};
        int sum = 3;
        System.out.println("Using recursion: " + sum(ar, 0, sum));
        int n = ar.length;
        int[][] dp = new int[n][sum + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Using memoization: " + sumMemo(ar, dp, 0, sum));
    }

    public static int sum(int[] ar, int idx, int sum) {
        if (idx == ar.length) {
            if (sum == 0)
                return 1;
            return 0;
        }

        int positive = sum(ar, idx + 1, sum - ar[idx]);
        int negative = sum(ar, idx + 1, sum + ar[idx]);
        return positive + negative;
    }

    public static int sumMemo(int[] ar, int[][] dp, int idx, int sum) {
        if (idx == ar.length) {
            if (sum == 0)
                return 1;
            return 0;
        }

        if (dp[idx][sum] != -1) {
            return dp[idx][sum];
        }

        int positive = sumMemo(ar, dp, idx + 1, sum - ar[idx]);
        int negative = sumMemo(ar, dp, idx + 1, sum + ar[idx]);
        dp[idx][sum] = positive + negative;
        return dp[idx][sum];
    }
}
