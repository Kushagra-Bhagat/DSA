package org.dsa.dp.subsequence;

// Also S1 is greater than S2
public class CountSubsetsWithSumD {
    public static void main(String[] args) {
        int[] ar = {5, 2, 6, 4};
        int k = 3;
        System.out.println(countTabu(ar, k));
    }

    public static int countTabu(int[] ar, int k) {

        int sum = 0, n = ar.length;
        for (int val : ar) {
            sum += val;
        }

        if (k > sum || (sum + k) % 2 != 0) {
            return 0;
        }

        int[][] dp = new int[n][sum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        if (ar[0] <= sum) {
            dp[0][ar[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (ar[i] <= j) {
                    dp[i][j] += dp[i - 1][j - ar[i]];
                }
            }
        }

        int target = (sum + k) / 2;

        return dp[n - 1][target];

//        non - efficient
//        int s1 = sum / 2;
//        if (sum % 2 != 0) {
//            s1 += 1;
//        }
//
//        int res = 0;
//        for (int i = s1; i <= sum; i++) {
//            if (i - (sum - i) == k) {
//                res += dp[n - 1][i];
//            }
//        }
//
//        return res;
    }
}
