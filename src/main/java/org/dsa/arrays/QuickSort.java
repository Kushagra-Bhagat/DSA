package org.dsa.arrays;

import java.util.Arrays;


// O(nlog n) average case
// not stable but good for large data sets
// divide and conquer
// u can use another algo for partition
// in the algo used we have not gone with algo that gives location of exact location of pivot
public class QuickSort {

    static int partition(int[] arr, int low, int high) {
        int i = low - 1;
        int j = high + 1;
        int pi = arr[low];
        while(true) {
            do {
                i++;
            } while(arr[i] < pi);
            do {
                j--;
            } while(arr[j] > pi);
            if (i >= j) {
                System.out.println(Arrays.toString(arr));
                System.out.println(j);
                return j;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot);
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
