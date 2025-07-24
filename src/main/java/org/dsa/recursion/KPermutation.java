package org.dsa.recursion;

public class KPermutation {
    public static void main(String[] args) {
        int n = 4;
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = i + 1;
        }
        int k = 8;
        int res = permutation(0, ar, k, 0);
        System.out.println(res);
    }

    public static int permutation(int idx, int[] ar, int n, int sol) {
        if (idx == ar.length - 1) {
            sol = sol * 10 + ar[ar.length - 1];
            return sol;
        }

        int fact = (factorial(ar.length - idx - 1) * ar.length) % n;
        swap(ar, idx, fact);
        sol = sol * 10 + ar[idx];
        return permutation(idx + 1, ar, n, sol);
    }

    public static int factorial(int n) {
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += i;
        }
        return sum;
    }

    public static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
