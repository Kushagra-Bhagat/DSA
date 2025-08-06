package org.dsa.dp.subsequence;


// 0/1 knapsack
public class Knapsack {
    public static void main(String[] args) {
        int[] wt = {3, 2, 5};
        int[] vol = {40, 50, 60};
        int weight = 6;
        System.out.println("Using recursion: " + maxValue(wt, vol, 0, weight));
        System.out.println("Using tabulation: " + maxTabu(wt, vol, weight));
        System.out.println("Using space optimization: " + maxOpt(wt, vol, weight));
    }

    // TC -> O(2^n)
    public static int maxValue(int[] wt, int[] vol, int idx, int weight) {
        if (weight == 0 || idx == wt.length) {
            return 0;
        }

        int notTake = maxValue(wt, vol, idx + 1, weight);
        int take = 0;
        if (weight >= wt[idx]) {
            take = vol[idx] + maxValue(wt, vol, idx + 1, weight - wt[idx]);
        }
        return Math.max(take, notTake);
    }

    public static int maxMemo(int[] wt, int[] vol, int idx, int weight, int[][] dp) {
        if (weight == 0 || idx == wt.length) {
            return 0;
        }

        if (dp[idx][weight] != -1) {
            return dp[idx][weight];
        }

        int notTake = maxMemo(wt, vol, idx + 1, weight, dp);
        int take = 0;
        if (weight >= wt[idx]) {
            take = vol[idx] + maxMemo(wt, vol, idx + 1, weight - wt[idx], dp);
        }
        dp[idx][weight] = Math.max(take, notTake);
        return dp[idx][weight];
    }

    public static int maxTabu(int[] wt, int[] vol, int weight) {

        int n = wt.length;
        // max value we can get at index i (or items) for weight j
        int[][] dp = new int[n + 1][weight + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= weight; j++) {
                dp[i][j] = dp[i - 1][j];
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i][j], vol[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
            }
        }

        return dp[n][weight];
    }

    public static int maxOpt(int[] wt, int[] vol, int weight) {

        int n = wt.length;
        int[] dp = new int[weight + 1];

        for (int i = 1; i <= n; i++){
            // you can use this to use same array
            for (int j = weight; j >= wt[i - 1]; j--) {
                dp[j] = Math.max(dp[j], vol[i - 1] + dp[j - wt[i - 1]]);
            }
        }

        return dp[weight];
    }
}
