package org.dsa.dp.subsequence;

public class CoinWays {

    public static void main(String[] args) {
        int[] coins = {2, 4};
        int sum = 7;
        System.out.println("Using tabulation: " + countTabu(coins, sum));
    }

    // dp[i][j] -> no of ways to get sum sum j using ar[0..i]
    public static int countTabu(int[] ar, int sum) {

        int n = ar.length;
        int[][] dp = new int[n][sum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= sum; i++) {
            dp[0][i] = 0;
            if (i % ar[0] == 0){
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (ar[i] <= j) {
                    dp[i][j] += dp[i][j - ar[i]];
                }
            }
        }

        return dp[n - 1][sum];
    }
}
