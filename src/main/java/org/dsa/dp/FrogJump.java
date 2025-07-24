package org.dsa.dp;

import java.util.Arrays;

// create definition for f(n) -> it helps
public class FrogJump {
    public static void main(String[] args) {
        int[] height = {30, 10, 60, 10, 60, 50};
        int n = height.length - 1;
        int res = jump(height, n);
        System.out.println(res);
        int[] dp = new int[height.length];
        Arrays.fill(dp, -1);
        System.out.println("Using memoization: " + jumpMemoization(height, dp, n));
        System.out.println("Using tabulation: " + jumpTabulation(height, n));
        System.out.println("Using space optimization: " + jumpSpaceOptimized(height, n));
    }

    public static int jump(int[] height, int n) {
        if (n == 0) {
            return 0;
        }
        int min1 = jump(height, n - 1) + Math.abs(height[n - 1] - height[n]);
        if (n > 1) {
            int min2 = jump(height, n - 2)  + Math.abs(height[n - 2] - height[n]);
            return Math.min(min1, min2);
        }
        return min1;
    }

    // Overlapping sub problem as we are calculating f(n) again and again
    // dp[n] = min energy required to jump from 0 to n;
    public static int jumpMemoization(int[] height, int[] dp, int n) {
        if (n == 0) {
            return 0;
        }
        // Adding memoization
        if (dp[n] != -1) {
            return dp[n];
        }
        int min1 = jump(height, n - 1) + Math.abs(height[n - 1] - height[n]);
        int min2 = Integer.MAX_VALUE;
        if (n > 1) {
            min2 = jump(height, n - 2)  + Math.abs(height[n - 2] - height[n]);
        }
        dp[n] = Math.min(min1, min2);
        return dp[n];
    }

    public static int jumpTabulation(int[] height, int n) {

        int[] dp = new int[height.length];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min1 = dp[i - 1] + Math.abs(height[i - 1] - height[i]);
            int min2 = Integer.MAX_VALUE;
            if (i > 1) {
                min2 = dp[i - 2] + Math.abs(height[i - 2] - height[i]);
            }
            dp[i] = Math.min(min1, min2);
        }
        return dp[n];
    }

    // prev2 = min energy to jump from n - 2 cell
    // prev = min energy to jump from n - 1 cell
    public static int jumpSpaceOptimized(int[] height, int n) {

        int prev2 = 0;
        int prev = 0;
        for (int i = 1; i <= n; i++) {
            int min1 = prev + Math.abs(height[i - 1] - height[i]);
            int min2 = Integer.MAX_VALUE;
            if (i > 1) {
                min2 = prev2 + Math.abs(height[i - 2] - height[i]);
            }
            int curr = Math.min(min1, min2);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
