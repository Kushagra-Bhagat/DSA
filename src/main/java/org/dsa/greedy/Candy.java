package org.dsa.greedy;

public class Candy {
    public static void main(String[] args) {

        int[] ar = {0, 2, 4, 3, 2, 1, 1, 3, 5, 6, 4, 0, 0};

        System.out.println("min no of candies: " + minCandy(ar));
        System.out.println("optimized: " + candy(ar));
    }

    // TC -> O(3n)
    // SC -> O(2n)
    public static int minCandy(int[] ar) {

        int n = ar.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ar[i] > ar[i - 1]) {
                left[i] = 1 + left[i - 1];
            }
            else {
                left[i] = 1;
            }
        }

        // you can combine this step and avoid 1 array and 1 loop
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ar[i] > ar[i + 1]) {
                right[i] = 1 + right[i + 1];
            }
            else {
                right[i] = 1;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res + Math.max(left[i], right[i]);
        }

        return res;
    }

    // slope based intuition -> imp
    // TC -> O(n)
    // SC -> O(1)
    public static int candy(int[] ar) {

        int sum = 1, i = 1;
        int n = ar.length;

        while (i < n) {
            if (ar[i] == ar[i - 1]) {
                sum += 1;
                i++;
                continue;
            }

            int peak = 1;
            while (i < n && ar[i] > ar[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }

            int down = 1;
            while (i < n && ar[i] < ar[i - 1]) {
                sum += down;
                down++;
                i++;
            }

            if (down > peak) {
                sum += down - peak;
            }
        }

        return sum;
    }
}
