package org.dsa.dp.strings;

import java.util.Arrays;

public class DistinctSubsequences {
    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";
        int n = s1.length();
        int m = s2.length();
        System.out.println("Count: " + count(s1, s2, n - 1, m - 1));

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("using memoization: " + countMemo(dp, s1, s2, n - 1, m - 1));
        System.out.println("using tabulation: " + countTabu(s1, s2));
    }

    public static int count(String s1, String s2, int idx1, int idx2) {

        if (idx2 < 0) {
            return 1;
        }
        if (idx1 < 0) {
            return 0;
        }

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return count(s1, s2, idx1 - 1, idx2 - 1) + count(s1, s2, idx1 - 1, idx2);
        }
        else {
            return count(s1, s2, idx1 - 1, idx2);
        }
    }

    // TC -> O(n * m)
    public static int countMemo(int[][] dp, String s1, String s2, int idx1, int idx2) {
        if (idx2 < 0) {
            return 1;
        }
        if (idx1 < 0) {
            return 0;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            dp[idx1][idx2] = countMemo(dp, s1, s2, idx1 - 1, idx2 - 1) + countMemo(dp, s1, s2, idx1 - 1, idx2);
        }
        else {
            dp[idx1][idx2] = countMemo(dp, s1, s2, idx1 - 1, idx2);
        }
        return dp[idx1][idx2];
    }

    public static int countTabu(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
}
