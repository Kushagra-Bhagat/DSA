package org.dsa.dp;

import java.util.Arrays;

public class CountSubsets {
    public static void main(String[] args) {
        int[] ar = {1, 2, 2, 3};
        int k = 3;
        System.out.println("Using recursion: " + count(ar, 0, k));
        int[][] dp = new int[ar.length][k + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Using memoization: " + countMemo(ar, dp, 0, k));
        System.out.println("Using Tabulation: " + countTabu(ar, k));
        System.out.println("Using space optimization: " + countOpt(ar, k));
    }

    public static int count(int[] ar, int idx, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (idx == ar.length) {
            return 0;
        }

        int notTake = count(ar, idx + 1, sum);
        int take = 0;
        if (ar[idx] <= sum) {
            take = count(ar, idx + 1, sum - ar[idx]);
        }
        return take + notTake;
    }

    public static int countMemo(int[] ar, int[][] dp, int idx, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (idx == ar.length) {
            return 0;
        }
        if (dp[idx][sum] != -1) {
            return dp[idx][sum];
        }

        int notTake = countMemo(ar, dp, idx + 1, sum);
        int take = 0;
        if (ar[idx] <= sum) {
            take = countMemo(ar, dp, idx + 1, sum - ar[idx]);
        }
        dp[idx][sum] = take + notTake;
        return dp[idx][sum];
    }

    // dp[i][j] -> means no of subsets that can be formed from ar[0..i] with sum = j
    public static int countTabu(int[] ar, int sum) {
        int n = ar.length;

        int[][] dp = new int[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        if (ar[0] <= sum) {
            dp[0][ar[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (ar[i] <= j) {
                    dp[i][j] += dp[i - 1][j - ar[i]];
                }
            }
        }
        return dp[n - 1][sum];
    }

    public static int countOpt(int[] ar, int sum) {
        int n = ar.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        if (ar[0] <= sum) {
            dp[ar[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[sum + 1];
            curr[0] = 1;
            for (int j = 1; j <= sum; j++) {
                curr[j] = dp[j];
                if (ar[i] <= j) {
                    curr[j] += dp[j - ar[i]];
                }
            }
            dp = curr;
        }
        return dp[sum];
    }
}
