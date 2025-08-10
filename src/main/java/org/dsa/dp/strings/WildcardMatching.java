package org.dsa.dp.strings;

import java.util.Arrays;

public class WildcardMatching {

    public static void main(String[] args) {
        String s1 = "abc*?d";
        String s2 = "abcdefgd";
        int n = s1.length();
        int m = s2.length();
        System.out.println("using recursion: " + match(s1, s2, n - 1, m - 1));

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], - 1);
        }
        System.out.println("using memoization: " + matchMemo(dp, s1, s2, n - 1, m - 1));
        System.out.println("using tabulation: " + matchTabu(s1, s2));
    }

    public static boolean match(String s1, String s2, int i, int j) {

        if (i < 0 && j < 0) {
            return true;
        }
        if (i < 0) {
            return false;
        }
        if (j < 0 && i >= 0) {
            for (int k = i; k >= 0; k--) {
                if (s1.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            return match(s1, s2, i - 1, j - 1);
        }

        if (s1.charAt(i) == '*') {
            return (match(s1, s2, i - 1, j) || match(s1, s2, i, j - 1));
        }

        return false;
    }

    public static boolean matchMemo(int[][] dp, String s1, String s2, int i, int j) {

        if (i < 0 && j < 0) {
            return true;
        }
        if (i < 0) {
            return false;
        }
        if (j < 0 && i >= 0) {
            for (int k = i; k >= 0; k--) {
                if (s1.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 0;
        }

        boolean val;

        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            val = matchMemo(dp, s1, s2, i - 1, j - 1);
        }

        else if (s1.charAt(i) == '*') {
            val = (matchMemo(dp, s1, s2, i - 1, j) || matchMemo(dp, s1, s2, i, j - 1));
        }

        else {
            val = false;
        }

        dp[i][j] = val ? 0 : 1;
        return val;
    }

    // can be space optimized
    public static boolean matchTabu(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            if (s1.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
            else {
                dp[i][0] = false;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (s1.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}
