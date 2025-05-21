package org.dsa.arrays;


import java.util.Arrays;

// O(n^2)
// not stable = doesn't maintain order
public class SelectionSort {

    static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        System.out.println("original array: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
