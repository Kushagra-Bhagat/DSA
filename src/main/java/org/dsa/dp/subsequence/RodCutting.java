package org.dsa.dp.subsequence;

public class RodCutting {
    public static void main(String[] args) {
        int n = 5;
        int[] price = {2, 5, 7, 8, 10};
        System.out.println("Using tabulation: " + cutTabu(price, n));

    }

    public static int cutTabu(int[] price, int n) {

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (i <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i][j - i]);
                }
            }
        }
        return dp[n][n];
    }
}
