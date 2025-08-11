package org.dsa.dp.stocks;

// best day to buy and sell stock
public class StockOne {

    public static void main(String[] args) {
        int[] ar = {7, 1, 5, 6, 4};
        System.out.println("Max profit earned if buy/sell once: " + buy(ar));
    }

    // just keep track of min value on left
    public static int buy(int[] ar) {

        int n = ar.length;
        int minLeft = ar[0];
        int profit = 0;

        for (int i = 1; i < n; i++) {
            int cost = ar[i] - minLeft;
            profit = Math.max(profit, cost);
            minLeft = Math.min(minLeft, ar[i]);
        }

        return profit;
    }
}
