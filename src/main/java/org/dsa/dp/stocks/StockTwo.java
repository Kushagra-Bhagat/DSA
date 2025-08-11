package org.dsa.dp.stocks;

import java.util.Arrays;

// can buy/sell multiple stocks
// we cannot buy and buy again
public class StockTwo {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6 ,4};
        System.out.println("Max profit with unlimited buy/sell: " + buy(prices, 0, 0));
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("using memoization: " + buyMemo(dp, prices, 0, 0));
        System.out.println("using tabulation: " + buyTabu(prices));
        System.out.println("using space optimization: " + buyOpt(prices));
    }

    public static int buy(int[] prices, int idx, int buy) {

        if (idx == prices.length) {
            return 0;
        }

        int profit = 0;
        if (buy == 0) {
            int take = -prices[idx] + buy(prices, idx + 1, 1);
            int notTake = 0 + buy(prices, idx + 1, 0);
            profit = Math.max(take, notTake);
        }
        else if(buy == 1) {
            int take = prices[idx] + buy(prices, idx + 1, 0);
            int notTake = 0 + buy(prices, idx + 1, 1);
            profit = Math.max(take, notTake);
        }
        return profit;
    }

    // TC -> O(n * 2)
    // SC -> O(n * 2)
    public static int buyMemo(int[][] dp, int[] prices, int idx, int buy) {
        if (idx == prices.length) {
            return 0;
        }

        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }

        int profit = 0;
        if (buy == 0) {
            int take = -prices[idx] + buyMemo(dp,prices, idx + 1, 1);
            int notTake = buyMemo(dp,prices, idx + 1, 0);
            profit = Math.max(take, notTake);
        }
        else if(buy == 1) {
            int take = prices[idx] + buyMemo(dp,prices, idx + 1, 0);
            int notTake = buyMemo(dp,prices, idx + 1, 1);
            profit = Math.max(take, notTake);
        }
        dp[idx][buy] = profit;
        return dp[idx][buy];

    }

    public static int buyTabu(int[] prices) {

        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {

            dp[i][0] = Math.max(-prices[i] + dp[i + 1][1], dp[i + 1][0]);
            dp[i][1] = Math.max(prices[i] + dp[i + 1][0], dp[i + 1][1]);
        }

        return dp[0][0];
    }

    // TC -> O(n)
    // SC -> O(1)
    public static int buyOpt(int[] prices) {

        int n = prices.length;
        int buy = 0;
        int sell = 0;

        for (int i = n - 1; i >= 0; i--) {
            int buyPrev = Math.max(-prices[i] + sell, buy);
            int sellPrev = Math.max(prices[i] + buy, sell);

            buy = buyPrev;
            sell = sellPrev;
        }

        return buy;
    }
}
