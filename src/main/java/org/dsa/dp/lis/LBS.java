package org.dsa.dp.lis;

import java.util.Arrays;

// longest bitonic subsequence <increasing <-----> decreasing>
// it can also be only increasing decreasing
public class LBS {

    public static void main(String[] args) {
        int[] ar = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println("length of longest bitonic subsequence: " + lbs(ar));
    }

    // TC -> O(n^2)
    // SC -> O(n)
    public static int lbs(int[] ar) {

        int n = ar.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (ar[j] < ar[i] && dp1[i] < dp1[j] + 1) {
                    dp1[i] = 1 + dp1[j];
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (ar[j] < ar[i] && dp2[i] < 1 + dp2[j]) {
                    dp2[i] = 1 + dp2[j];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int val = dp1[i] + dp2[i] - 1;
            res = Math.max(res, val);
        }

        return res;
    }
}
