package org.dsa.arrays;

import java.util.Arrays;

public class BubbleSort {

    public static void sorting(int[] ar) {

        int n = ar.length;
        for (int i = 1; i < n; i++) {
            boolean swap = false;
            for (int j = 0; j < n - i; j++) {
                if (ar[j] > ar[j + 1]) {
                    swap = true;
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                }
            }
            if(!swap) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] ar = {10, 16, 1, 4, 2, 12};
        sorting(ar);
        System.out.println(Arrays.toString(ar));
    }
}
