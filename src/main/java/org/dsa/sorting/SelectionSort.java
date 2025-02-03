package org.dsa.sorting;

import java.util.Arrays;

public class SelectionSort {
    static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int iMin = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[iMin] > arr[j]) {
                    iMin = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[iMin];
            arr[iMin] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,4,6,7,8,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
