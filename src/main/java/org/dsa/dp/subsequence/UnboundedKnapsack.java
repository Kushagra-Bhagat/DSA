package org.dsa.dp.subsequence;

public class UnboundedKnapsack {

    public static void main(String[] args) {
        int[] wt = {1, 3, 4};
        int[] vol = {15, 50, 60};
        int weight = 7;
        System.out.println("Using recursion: " + knapsack(wt, vol, weight, 0));
        System.out.println("Using Tabulation: " + knapsackTabu(wt, vol, weight));
    }

    public static int knapsack(int[] wt, int[] vol, int weight, int idx) {

        if (idx == wt.length || weight <= 0) {
            return 0;
        }

        int notPick = knapsack(wt, vol, weight, idx + 1);
        int pick = Integer.MIN_VALUE;
        if (wt[idx] <= weight) {
            pick = vol[idx] + knapsack(wt, vol, weight - wt[idx] , idx);
        }
        return Math.max(pick, notPick);
    }

    public static int knapsackTabu(int[] wt, int[] vol, int weight) {

        int n = wt.length;
        int[][] dp = new int[n + 1][weight + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= weight; j++) {
                dp[i][j] = dp[i - 1][j];
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i][j], vol[i - 1] + dp[i][j - wt[i - 1]]);
                }
            }
        }
        return dp[n][weight];
    }
}
