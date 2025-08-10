package org.dsa.dp.strings;

// Shortest Common Super sequence
// length of super sequence = n + m - length(lcs)
public class SCS {

    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";
        System.out.println("Length of smallest super-sequence: " + count(s1, s2));
    }

    public static int count(String s1, String s2) {

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
                if (dp[i - 1][j] < dp[i][j - 1]) {
                    res.insert(0, s2.charAt(j - 1));
                    j--;
                }
                else {
                    res.insert(0, s1.charAt(i - 1));
                    i--;
                }
            }
        }

        while (i > 0) {
            res.insert(0, s1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            res.insert(0, s2.charAt(j - 1));
            j--;
        }

        System.out.println("Smallest Super-sequence: " + res);

        return (n + m - dp[n][m]);
    }
}
