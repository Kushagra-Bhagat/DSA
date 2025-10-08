package org.dsa.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {

        int[][] intervals = {
                {1, 2},
                {3, 4},
                {7, 7},
                {8, 10},
                {12, 16}
        };
        int[] pair = {5, 6};

        List<List<Integer>> res = solution(intervals, pair);
        System.out.println("Brute force: " + Arrays.toString(res.toArray()));
    }

    // TC -> O(n)
    // SC -> O(n)
    public static List<List<Integer>> solution(int[][] intervals, int[] pair) {

        int n = intervals.length;
        int left = -1, right = -1;

        for (int i = 0; i < n; i++) {
            if (intervals[i][1] < pair[0]) {
                left++;
                continue;
            }
            if (intervals[i][0] > pair[1]) {
                right = i;
                System.out.println("left: " + left + " right: " + right);
                break;
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i <= left; i++) {
            res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
        }

        int lVal = Math.min(intervals[left + 1][0], pair[0]);
        int rVal = Math.max(intervals[right - 1][1], pair[1]);
        res.add(Arrays.asList(lVal, rVal));

        for (int i = right; i < n; i++) {
            res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
        }

        return res;
    }
}
