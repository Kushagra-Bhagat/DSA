package org.dsa.dp.strings;

import java.util.Arrays;

public class lcs {
    public static void main(String[] args) {
        String s1 = "abcbdab";
        String s2 = "bdcabb";

        System.out.println("Using recursion: " + count(s1, s1.length() - 1, s2, s2.length() - 1));

        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Using memoization: " + countMemo(dp, s1, s1.length() - 1, s2, s2.length() - 1));
        System.out.println("Using tabulation: " + countTabu(s1, s2));
        System.out.println("using space optimization: " + countOpt(s1, s2));
        System.out.println("lcs: " + getLcs(s1, s2));

        String s = "bbabcbcab";
        System.out.println("length of palindrome lcs is: " + lengthOfLcsPalindrome(s));

    }

    public static int count(String s1, int idx1, String s2, int idx2) {

        if (idx1 < 0 || idx2 < 0) {
            return 0;
        }

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return 1 + count(s1, idx1 - 1, s2, idx2 - 1);
        }

        return Math.max(count(s1, idx1 - 1, s2, idx2), count(s1, idx1, s2, idx2 - 1));
    }

    // dp[i][j] -> lcs for s1(0..i) and s2(0..j)
    // TC -> O(n * m)
    // SC -> O(n * m)
    // aux -> O(n + m) -> because everytime a string length is traversed we reach our base case
    public static int countMemo(int[][] dp, String s1, int idx1, String s2, int idx2) {
        if (idx1 < 0 || idx2 < 0) {
            return 0;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            dp[idx1][idx2] = 1 + countMemo(dp, s1, idx1 - 1, s2, idx2 - 1);
        }
        else {
            dp[idx1][idx2] = Math.max(countMemo(dp, s1, idx1 - 1, s2, idx2), countMemo(dp, s1, idx1, s2, idx2 - 1));
        }
        return dp[idx1][idx2];
    }

    // TC -> O(n * m)
    // SC -> O(n * m)
    public static int countTabu(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static int countOpt(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + dp[j - 1];
                }
                else {
                    curr[j] = Math.max(dp[j], curr[j - 1]);
                }
            }
            dp = curr;
        }
        return dp[m];
    }

    public static String getLcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // To understand know what dp[][] stores
        int i = n;
        int j = m;
        StringBuilder res = new StringBuilder();

        while (i > 0 && j > 0) {

            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                res.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            }

            else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                }
                else {
                    j--;
                }
            }
        }

        return res.toString();
    }

    public static int lengthOfLcsPalindrome(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();

        System.out.println("Longest common palindrome lcs is: " + getLcs(s1, s2));

        return countOpt(s1, s2);
    }
}
