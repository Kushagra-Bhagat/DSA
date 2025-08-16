package org.dsa.dp.lis;

import java.util.*;

// longest string chain
public class LSC {

    public static void main(String[] args) {
        String[] ar = {"xbc","pcxbcf","xb","cxbc","pcxbc"};

        System.out.println("length of largest string chain: " + lsc(ar));
    }

    public static int lsc(String[] ar) {

        int n = ar.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];
        for (int i = 0; i < n; i++) {
            hash[i] = i;
        }

        Arrays.sort(ar, Comparator.comparingInt(String::length));

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (compare(ar[i], ar[j]) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
        }

        int res = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (res < dp[i]) {
                res = dp[i];
                idx = i;
            }
        }

        List<String> list = new ArrayList<>();

        while (idx != hash[idx]) {
            list.add(ar[idx]);
            idx = hash[idx];
        }
        list.add(ar[idx]);
        Collections.reverse(list);

        System.out.println("largest string chain: " + list);

        return res;
    }

    // s2 < s1 because j < i
    public static boolean compare(String s1, String s2) {

        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 != l2 + 1) {
            return false;
        }

        int i = 0, j = 0;

        while (i < l1 && j < l2) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == l2;
    }
}
