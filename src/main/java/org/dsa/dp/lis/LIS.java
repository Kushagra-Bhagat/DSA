package org.dsa.dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LIS {
    public static void main(String[] args) {
        int[] ar = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("length of longest increasing subsequence: " + lisLen(ar, 0, -1));

        int n = ar.length;
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], - 1);
        }
        System.out.println("Using memoization: " + lisLenMemo(dp, ar, 0, -1));
        System.out.println("using tabulation: " + lisLenTabu(ar));
        System.out.println("space optimized: " + lisOpt(ar));
        System.out.println("another optimization: " + lisOpt2(ar));
        System.out.println("using binary search: " + lisBinary(ar));

    }

    // TC -> O(2^n)
    // SC -> O(n)
    public static int lisLen(int[] ar, int idx, int prevIdx) {

        if (idx == ar.length) {
            return 0;
        }

        int pick = Integer.MIN_VALUE;
        if (prevIdx == -1 || ar[idx] > ar[prevIdx]) {
            pick = 1 + lisLen(ar, idx + 1, idx);
        }
        int notPick = lisLen(ar, idx + 1, prevIdx);
        return Math.max(pick, notPick);
    }

    // TC -> O(n*n)
    // SC -> O(n*n)
    public static int lisLenMemo(int[][] dp, int[] ar, int idx, int prevIdx) {

        if (idx == ar.length) {
            return 0;
        }

        if (dp[idx][prevIdx + 1] != -1) {
            return dp[idx][prevIdx + 1];
        }

        int pick = Integer.MIN_VALUE;
        if (prevIdx == -1 || ar[idx] > ar[prevIdx]) {
            pick = 1 + lisLenMemo(dp, ar, idx + 1, idx);
        }
        int notPick = lisLenMemo(dp, ar, idx + 1, prevIdx);
        dp[idx][prevIdx + 1] = Math.max(pick, notPick);
        return dp[idx][prevIdx + 1];
    }

    // dp[i][j] -> max len from index i where prev idx is j
    public static int lisLenTabu(int[] ar) {

        int n = ar.length;
        // base case is for n == ar.length and for prev idx we also have to take -1
        // so we have shifted index by 1
        int[][] dp = new int[n + 1][n + 1];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int prevIdx = idx - 1; prevIdx >= -1; prevIdx--) {
                int notTake = dp[idx + 1][prevIdx + 1];
                int take = 0;
                if (prevIdx == -1 || ar[idx] > ar[prevIdx]) {
                    take = 1 + dp[idx + 1][idx + 1];
                }
                dp[idx][prevIdx + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }

    public static int lisOpt(int[] ar) {

        int n = ar.length;
        int[] nextRow = new int[n + 1];
        int[] currRow = new int[n + 1];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int prevIdx = idx - 1; prevIdx >= -1; prevIdx--) {
                int notTake = nextRow[prevIdx + 1];
                int take = 0;
                if (prevIdx == -1 || ar[idx] > ar[prevIdx]) {
                    take = 1 + nextRow[idx + 1];
                }
                 currRow[prevIdx + 1] = Math.max(take, notTake);
            }
            nextRow = currRow;
        }

        return nextRow[0];
    }

    // TC -> O(n^2)
    // SC -> O(n)
    // needed to print lis
    public static int lisOpt2(int[] ar) {

        int n = ar.length;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        int[] hash = new int[n];

        for (int i = 0; i < n; i++) {
            hash[i] = i;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (ar[j] < ar[i] && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
        }

        int res = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > res) {
                res = dp[i];
                idx = i;
            }
        }

        List<Integer> lis = new ArrayList<>();
        while (idx != hash[idx]) {
            lis.add(ar[idx]);
            idx = hash[idx];
        }
        lis.add(idx);

        Collections.reverse(lis);
        System.out.println("Lis: " + lis);

        return res;
    }

    // {10, 9, 2, 5, 3, 7, 101, 18}
    // TC -> O(n log n)
    public static int lisBinary(int[] nums) {

        int n = nums.length;
        int[] tail = new int[n];
        int size = 0;

        for (int num : nums) {

            int pos = binarySearch(tail, 0, size, num);

            tail[pos] = num;

            if (pos == size) {
                size++;
            }
        }

        return size;
    }

    public static int binarySearch(int[] arr, int low, int high, int target) {

        while (low < high) {
            int mid = low - (low - high) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return low;
    }
}
