package org.dsa.dp.strings;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        int n = s1.length();
        int m = s2.length();
        System.out.println("using recursion: " + count(s1, s2, n - 1, m - 1));

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], - 1);
        }
        System.out.println("using memoization: " + countMemo(dp, s1, s2, n - 1, m - 1));
        System.out.println("using tabulation: " + countTabu(s1, s2));
    }

    public static int count(String s1, String s2, int idx1, int idx2) {

        // we need to delete from s1
        if (idx2 < 0) {
            return idx1 + 1;
        }

        // we need to insert in s1
        if (idx1 < 0) {
            return idx2 + 1;
        }

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return count(s1, s2, idx1 - 1, idx2 - 1);
        }

        else {
            int insert = 1 + count(s1, s2, idx1, idx2 - 1);
            int delete = 1 + count(s1, s2, idx1 - 1, idx2);
            int replace = 1 + count(s1, s2, idx1 - 1, idx2 - 1);
            return Math.min(insert, Math.min(delete, replace));
        }
    }

    public static int countMemo(int[][] dp, String s1, String s2, int idx1, int idx2) {
        if (idx2 < 0) {
            return idx1 + 1;
        }

        // we need to insert in s1
        if (idx1 < 0) {
            return idx2 + 1;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            dp[idx1][idx2] = countMemo(dp, s1, s2, idx1 - 1, idx2 - 1);
        }

        else {
            int insert = 1 + countMemo(dp, s1, s2, idx1, idx2 - 1);
            int delete = 1 + countMemo(dp, s1, s2, idx1 - 1, idx2);
            int replace = 1 + countMemo(dp, s1, s2, idx1 - 1, idx2 - 1);
            dp[idx1][idx2] = Math.min(insert, Math.min(delete, replace));
        }

        return dp[idx1][idx2];
    }

    public static int countTabu(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int [][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }

        return dp[n][m];
    }
}
