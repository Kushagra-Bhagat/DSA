package org.dsa.dp;

import java.util.Arrays;

public class MaxSumOfNonAdj {
    public static void main(String[] args) {
        int[] ar = {2, 1, 4, 9};
        int[] dp = new int[ar.length];
        Arrays.fill(dp, -1);
        System.out.println(sum(ar, ar.length - 1));
        System.out.println(sumMemo(ar, dp, ar.length - 1));
        System.out.println(sumTabu(ar));
        System.out.println(sumOpt(ar));
    }

    // imp recursion technique pick/not-pick
    public static int sum(int[] arr, int idx) {
        if (idx == 0) {
            return arr[0];
        }

        if (idx < 0) {
            return 0;
        }

        int pick = arr[idx] + sum (arr, idx - 2);
        int notPick = 0 + sum(arr, idx - 1);
        return Math.max(pick, notPick);
    }

    public static int sumMemo(int[] arr, int[] dp, int idx) {
        if (idx == 0) {
            return arr[0];
        }
        if (idx < 0) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int pick = arr[idx] + sum (arr, idx - 2);
        int notPick = 0 + sum(arr, idx - 1);
        dp[idx] =  Math.max(pick, notPick);
        return dp[idx];
    }

    public static int sumTabu(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int pick = arr[i];
            if (i - 2 >= 0) {
                pick += dp[i - 2];
            }
            int notPick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[arr.length - 1];
    }

    // O(n) -> time complexity
    // O(1) -> space complexity
    public static int sumOpt(int[] arr) {
        int prev = arr[0];
        int prev2 = 0;
        for (int i = 1; i < arr.length; i++) {
            int pick = arr[i] + prev2;
            int notPick = 0 + prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
