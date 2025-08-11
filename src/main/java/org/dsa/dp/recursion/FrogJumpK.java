package org.dsa.dp.recursion;

import java.util.Arrays;

public class FrogJumpK {

    public static void main(String[] args) {
        int[] height = {30, 10, 60, 10, 60, 50};
        int n = height.length - 1;
        int k = 4;
        int res = jump(height, n, k);
        System.out.println(res);
        int[] dp = new int[height.length];
        Arrays.fill(dp, -1);
        System.out.println("Using memoization: " + jumpMemo(height, dp, n, k));
        System.out.println("Using tabulation: " + jumpTabu(height, n, k));
        //System.out.println("Using space optimization: " + jumpSpaceOptimized(height, n));
    }

    // O(n * k)
    // O(n) + O(n)
    public static int jump(int[] height, int n, int k) {
        if (n == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k && n >= i; i++) {
            int step = jump(height, n - i, k) + Math.abs(height[n] - height[n - i]);
            min = Math.min(step, min);
        }
        return min;
    }


    // O(n * k)
    // O(n)
    public static int jumpMemo(int[] height, int[] dp, int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k && n >= i; i++) {
            int step = jumpMemo(height, dp, n - i, k) + Math.abs(height[n] - height[n - i]);
            min = Math.min(step, min);
        }
        dp[n] = min;
        return min;
    }

    // no need to space optimize as it will be O(k) no use if k = n
    public static int jumpTabu(int[] height, int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k && i >= j; j++) {
                int step = dp[i - j] + Math.abs(height[i] - height[i - j]);
                min = Math.min(min, step);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
