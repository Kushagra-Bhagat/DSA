package org.dsa.dp.subsequence;

import java.util.Arrays;

// answer might not be possible then return -1
public class MinimumCoins {

    public static void main(String[] args) {
        int[] ar = {9, 6, 5, 1};
        int sum = 11;
        System.out.println("Using recursion: " + minSum(ar, 0, sum));
        int n = ar.length;
        int[][] dp = new int[n][sum + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Using memoization: " + minSumMemo(ar, dp, 0, sum));
        System.out.println("Using Tabulation: " + minSumTabu(ar, sum));
        System.out.println("Using space optimization: " + minSumOpt(ar, sum));
    }

    public static int minSum(int[] ar, int idx, int sum) {

        if (sum == 0) {
            return 0;
        }

        if (idx == ar.length) {
            return Integer.MAX_VALUE;
        }

        int notPick = minSum(ar, idx + 1, sum);
        int pick = Integer.MAX_VALUE;
        if (ar[idx] <= sum) {
            pick = 1 + minSum(ar, idx, sum - ar[idx]);
        }
        return Math.min(pick, notPick);
    }

    public static int minSumMemo(int[] ar, int[][] dp, int idx, int sum) {
        if (sum == 0) {
            return 0;
        }

        if (idx == ar.length || sum < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[idx][sum] != -1) {
            return dp[idx][sum];
        }

        int notPick = minSumMemo(ar, dp, idx + 1, sum);
        int pick = minSumMemo(ar, dp, idx, sum - ar[idx]);
        // to avoid overflow
        if (pick != Integer.MAX_VALUE) {
            pick += 1;
        }
        dp[idx][sum] = Math.min(pick, notPick);
        return dp[idx][sum];
    }

    public static int minSumTabu(int[] ar, int sum) {

        int n = ar.length;
        int[][] dp = new int[n][sum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i<= sum; i++) {
            dp[0][i] = Integer.MAX_VALUE;
            if (i % ar[0] == 0) {
                dp[0][i] = i / ar[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                int notPick = dp[i - 1][j];
                int pick = Integer.MAX_VALUE;
                // not i - 1 because we can pick same coin again
                if (ar[i] <= j && dp[i][j - ar[i]] != Integer.MAX_VALUE) {
                    pick = 1 + dp[i][j - ar[i]];
                }
                dp[i][j] = Math.min(pick, notPick);
            }
        }
        return dp[n - 1][sum];
    }

    public static int minSumOpt(int[] ar, int sum) {

        int n = ar.length;
        int[] dp = new int[sum + 1];
        dp[0] = 0;
        for (int i = 1; i<= sum; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (i % ar[0] == 0) {
                dp[i] = i / ar[0];
            }
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[sum + 1];
            for (int j = 1; j <= sum; j++) {
                int notPick = dp[j];
                int pick = Integer.MAX_VALUE;
                // not i - 1 because we can pick same coin again
                if (ar[i] <= j && dp[j - ar[i]] != Integer.MAX_VALUE) {
                    pick = 1 + dp[j - ar[i]];
                }
                curr[j] = Math.min(pick, notPick);
            }
            dp = curr;
        }
        return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
    }
}
