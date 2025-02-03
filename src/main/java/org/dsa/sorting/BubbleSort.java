package org.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {
    static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int swap = 0;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = 1;
                }
            }
            if (swap == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,4,6,7,8,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
