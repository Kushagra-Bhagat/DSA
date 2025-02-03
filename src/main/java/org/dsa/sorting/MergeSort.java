package org.dsa.sorting;

import java.util.Arrays;


// O(Nlog n)
// Used in Collection.sort()
public class MergeSort {
    static void sort (int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    static void merge (int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] L = new int[n1];
        int[] H = new int[n2];
        int i, j = 0, k =low;
        for (i = 0; i < n1; i++) {
            L[i] = arr[low + i];
        }
        for (i = 0; i < n2; i++) {
            H[i] = arr[mid + i + 1];
        }
        i = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= H[j]) {
                arr[k] = L[i];
                k++;
                i++;
            }
            else {
                arr[k] = H[j];
                k++;
                j++;
            }
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = H[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,1,3,9,7,6};
        sort(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
