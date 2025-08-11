package org.dsa.dp.stocks;

import java.util.Arrays;

// can do at most 2 transactions
// 0 -> can buy, 1 -> can sell
public class StockThree {

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int cap = 2;
        System.out.println("Max profit with max " + cap + " transaction: " + buy(prices, 0, 0, cap));

        int n = prices.length;
        int[][][] dp = new int[n][2][cap];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println("Using memoization: " + buyMemo(dp, prices, 0, 0, cap));
        System.out.println("using tabulation: " + buyTabu(prices, cap));
        System.out.println("using space optimization: " + buyOpt(prices, cap));
    }

    public static int buy(int[] prices, int idx, int buy, int cap) {

        if (idx == prices.length || cap == 0) {
            return 0;
        }

        int profit = 0;
        if (buy == 0) {
            int take = -prices[idx] + buy(prices, idx + 1, 1, cap);
            int notTake = buy(prices, idx + 1, 0, cap);
            profit = Math.max(take, notTake);
        }
        else if(buy == 1) {
            int take = prices[idx] + buy(prices, idx + 1, 0, cap - 1);
            int notTake = buy(prices, idx + 1, 1, cap);
            profit = Math.max(take, notTake);
        }
        return profit;
    }

    public static int buyMemo(int[][][] dp, int[] prices, int idx, int buy, int cap) {

        if (idx == prices.length || cap == 0) {
            return 0;
        }

        if (dp[idx][buy][cap - 1] != -1) {
            return dp[idx][buy][cap - 1];
        }

        int profit = 0;
        if (buy == 0) {
            int take = -prices[idx] + buyMemo(dp,prices, idx + 1, 1, cap);
            int notTake = buyMemo(dp, prices, idx + 1, 0, cap);
            profit = Math.max(take, notTake);
        }
        else if(buy == 1) {
            int take = prices[idx] + buyMemo(dp, prices, idx + 1, 0, cap - 1);
            int notTake = buyMemo(dp, prices, idx + 1, 1, cap);
            profit = Math.max(take, notTake);
        }
        dp[idx][buy][cap - 1] = profit;
        return dp[idx][buy][cap - 1];
    }

    public static int buyTabu(int[] prices, int cap) {

        int n = prices.length;
        int[][][] dp = new int[n + 1][2][cap + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= cap; j++) {

                dp[i][0][j] = Math.max(-prices[i] + dp[i + 1][1][j], dp[i + 1][0][j]);
                dp[i][1][j] = Math.max(prices[i] + dp[i + 1][0][j - 1], dp[i + 1][1][j]);
            }
        }

        return dp[0][0][cap];
    }

    public static int buyOpt(int[] prices, int cap) {

        int n = prices.length;
        int[][] dp = new int[2][cap + 1];

        for (int i = n - 1; i >= 0; i--) {
            int[][] curr = new int[2][cap + 1];
            for (int j = 1; j <= cap; j++) {

                curr[0][j] = Math.max(-prices[i] + dp[1][j], dp[0][j]);
                curr[1][j] = Math.max(prices[i] + dp[0][j - 1], dp[1][j]);
            }
            dp = curr;
        }

        return dp[0][cap];
    }
}
