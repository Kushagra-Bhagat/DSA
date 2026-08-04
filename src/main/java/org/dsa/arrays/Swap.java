package org.dsa.arrays;

import java.util.Arrays;

// if arr[i] = j then arr[j] = i;
public class Swap {
    public static void main(String[] args) {

        int[] arr = {2, 0, 1, 4, 5, 3};
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            arr[arr[i] % n] += i * n;
        }

        for (int i = 0; i < n; i++) {
            arr[i] /= n;
        }

        System.out.println(Arrays.toString(arr));
    }
}
