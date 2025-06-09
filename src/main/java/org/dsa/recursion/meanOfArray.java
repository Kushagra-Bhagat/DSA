package org.dsa.recursion;

import java.util.Arrays;

public class meanOfArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7,8,10,15};
        System.out.println("Mean = " + findMean(arr));
    }

    // mean(n) = ((mean(n - 1) * (n - 1)) + element at n) / n;
    static double findMean(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return (double) arr[n - 1];
        }

        return (findMean(Arrays.copyOf(arr, n - 1)) * (n - 1) + arr[n - 1]) / n;
    }
}
