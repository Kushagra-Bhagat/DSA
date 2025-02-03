package org.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;



public class Solution {
    public static ArrayList<Integer> maxSubArray(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        int resStart = 0, resEnd = 0;
        int currStart = 0, currEnd = 0;
        int currMax = arr[0], globalMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (currMax + arr[i] >= arr[i]) {
                currMax += arr[i];
                currEnd++;
            }
            else {
                currMax = arr[i];
                currStart = i;
                currEnd = currStart;
            }
            System.out.println(globalMax + " " + currMax + " for " + i);
            if (currMax > globalMax) {
                globalMax = currMax;
                resStart = currStart;
                resEnd = currEnd;
            }
        }
        for (int i = resStart; i <= resEnd; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    static int maxProduct(int[] arr) {
        int res = Integer.MIN_VALUE;
        int currMin = arr[0], currMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = Math.min(arr[i], Math.min(arr[i] * currMin, arr[i] * currMax));
            currMax = Math.max(arr[i], Math.max(arr[i] * currMin, arr[i] * currMax));
            currMin = temp;
            System.out.println(currMax + " " + currMin);
            res = Math.max(res,currMax);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = {2, 3, -8, 7, -1, 2, 3};
//        ArrayList<Integer> result = maxSubArray(arr);
//        System.out.println(Arrays.toString(result.toArray()));
//
        int[] arr = {-2, 6, -3, -10, 0, 2};
        System.out.println(maxProduct(arr));
    }
}
