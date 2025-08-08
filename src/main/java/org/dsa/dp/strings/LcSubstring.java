package org.dsa.dp.strings;

public class LcSubstring {

    public static void main(String[] args) {
        String s1 = "abcdxyz";
        String s2 = "xyzabcd";
        System.out.println("longest substring: " + subString(s1, s2));
        System.out.println("space optimized: " + subStringOpt(s1, s2));
    }

    public static String subString(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int maxLen = 0;
        int end = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        end = i; // i is 1 based indexing
                    }
                }
            }
        }

        return s1.substring(end - maxLen, end);
    }

    public static String subStringOpt(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();
        int[] dp = new int[m + 1];
        int maxLen = 0;
        int end = 0;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + dp[j - 1];
                    if (curr[j] > maxLen) {
                        maxLen = curr[j];
                        end = i;
                    }
                }
            }
            dp = curr;
        }

        return s1.substring(end - maxLen, end);
    }
}
