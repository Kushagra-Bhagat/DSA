package org.dsa.dp.lis;

import java.util.Arrays;

public class LLIS {

    public static void main(String[] args) {
        int[] ar = {1, 5, 4, 3, 2, 6, 7, 10, 8, 9};
        System.out.println("number of lis: " + sub(ar));
    }

    public static int sub(int[] ar) {

        int n = ar.length;
        int[] dp = new int[n];
        int[] curr = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(curr, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (ar[j] < ar[i]) {
                    if (dp[i] < 1 + dp[j]) {
                        dp[i] = 1 + dp[j];
                        curr[i] = curr[j];
                    }
                    else if (dp[i] == 1 + dp[j]) {
                        curr[i] += curr[j];
                    }
                }
            }
        }

        int total = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (res < dp[i]) {
                res = dp[i];
            }
        }

        // because subsequence can end at multiple places
        for (int i = 0; i < n; i++) {
            if (dp[i] == res) {
                total += curr[i];
            }
        }

        return total;
    }
}
