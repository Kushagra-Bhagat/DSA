package org.dsa.sorting;

import java.util.Arrays;

public class QuickSort {
    static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(arr, low, high);
        sort (arr, low, pivot - 1);
        sort (arr, pivot + 1, high);
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low, j = high;
        while (i < j) {
            while (arr[i] <= pivot && i < high) {
                i++;
            }
            while (arr[j] > pivot && j > low) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,1,2,9,4,3};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
