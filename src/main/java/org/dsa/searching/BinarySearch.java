package org.dsa.searching;

// Data should be sorted
// O(log n)
public class BinarySearch {
    static void search(int val, int[] arr, int low, int high) {
        // We use this to avoid overflow that's it.
        int mid = low + (high - low) / 2;
        if (arr[mid] == val) {
            System.out.println(val + " found at index: " + mid);
        }
        else if (low <= high) {
            if (val < arr[mid]) {
                search(val, arr, low, mid - 1);
            }
            else if (val > arr[mid]) {
                search(val, arr, mid + 1, high);
            }
        }
        else {
            System.out.println("Unsuccessful search!");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,6,7,8,10,11};
        search(0, arr, 0, arr.length - 1);
    }
}
