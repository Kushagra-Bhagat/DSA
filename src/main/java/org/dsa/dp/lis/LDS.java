package org.dsa.dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// largest divisible subset
// no need of order
// every pair should be divisible
// distinct and print any answer (we can sort)
public class LDS {

    public static void main(String[] args) {

        int[] ar = {1, 16, 7, 8, 4};
        Arrays.sort(ar);
        lds(ar);
    }

    public static void lds(int[] ar) {

        int n = ar.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];
        for (int i = 0; i < n; i++) {
            hash[i] = i;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (ar[i] % ar[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
        }

        int res = 0, idx = 0;
        for (int i = 0; i < n; i++) {
            if (res < dp[i]) {
                res = dp[i];
                idx = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        while (idx != hash[idx]) {
            list.add(ar[idx]);
            idx = hash[idx];
        }
        list.add(ar[idx]);

        System.out.println(list);
    }
}
