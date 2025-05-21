package org.dsa.arrays;

import java.util.Arrays;

// O(n) - best case if array is already sorted
// O(n ^ 2)
// Inplace
public class InsertionSort {
    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1, key = arr[i];
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6 };
        System.out.println("Original array: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
