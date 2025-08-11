package org.dsa.dp.stocks;

// Adding a transaction fee
public class StockFive {

    public static void main(String[] args) {

    }

    public static int buy(int[] prices, int idx, int buy, int fee) {

        if (idx == prices.length) {
            return 0;
        }

        int profit = 0;
        if (buy == 0) {
            int take = -prices[idx] + buy(prices, idx + 1, 1, fee);
            int notTake = buy(prices, idx + 1, 0, fee);
            profit = Math.max(take, notTake);
        }
        else if(buy == 1) {
            int take = prices[idx] - fee + buy(prices, idx + 1, 0, fee);
            int notTake = buy(prices, idx + 1, 1, fee);
            profit = Math.max(take, notTake);
        }
        return profit;
    }
}
