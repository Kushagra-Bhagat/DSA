package org.dsa.arrays;


// O(log n)
public class BinarySearch {

    static int binarySearch(int n, int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == n) {
                return mid;
            }
            else if (arr[mid] < n) {
                low = mid + 1;
            }
            else if (arr[mid] > n) {
                high = mid - 1;
            }
        }
        return -1;
    }

    static int binarySearchRecursive(int n, int[] arr, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == n) {
                return mid;
            }
            else if (arr[mid] < n) {
                return binarySearchRecursive(n, arr, mid + 1, high);
            }
            else if (arr[mid] > n) {
                return binarySearchRecursive(n, arr, low, mid - 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,8,19,22,25};

        int res = binarySearch(22, arr);
        int result = binarySearchRecursive(22, arr, 0, arr.length - 1);
        System.out.println(result + " " + res);
    }
}
