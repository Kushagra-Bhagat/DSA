package org.dsa.arrays;

import java.util.Arrays;


// O(nlog n) average case
// not stable but good for large data sets
// divide and conquer
// u can use another algo for partition
// in the algo used we have not gone with algo that gives location of exact location of pivot
public class QuickSort {

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int cnt = 0;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] <= pivot) {
                cnt++;
            }
        }

        int pivotIndex = low + cnt;
        arr[low] = arr[pivotIndex];
        arr[pivotIndex] = pivot;

        int i = low, j = high;
        while (i < pivotIndex && j > pivotIndex) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i < pivotIndex && j > pivotIndex) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return pivotIndex;
    }
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
//        System.out.println("Original array: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
