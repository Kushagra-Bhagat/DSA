package org.dsa.dp.recursion;

//Similar to fibonacci as we can only jump 1 or 2 steps
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Stairs with recursion: " + stairs(n));
        int[] mem = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            mem[i] = -1;
        }
        System.out.println("Stairs with memoization: " + stairsMemoization(n, mem));
        System.out.println("Stairs with tabulation: " + stairsTabulation(n));
    }

    public static int stairs(int n) {
        // only one way to go or you are on last stair
        if (n == 0 || n == 1) {
            return 1;
        }
        int left = stairs(n - 1);
        int right = stairs(n - 2);
        // counting all ways to climb stairs
        return left + right;
    }

    public static int stairsMemoization(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int left = stairs(n - 1);
        int right = stairs(n - 2);
        // counting all ways to climb stairs
        dp[n] = left + right;
        return dp[n];
    }

    public static int stairsTabulation(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
