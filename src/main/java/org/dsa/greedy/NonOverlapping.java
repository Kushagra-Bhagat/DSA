package org.dsa.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlapping {
    public static void main(String[] args) {

        int[][] intervals = {
                {0, 5},
                {3, 4},
                {1, 2},
                {5, 9},
                {5, 7},
                {7, 9}
        };

        System.out.println("min no of removals: " + solution(intervals));
    }

    public static int solution(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));

        int n = intervals.length;
        int end = 0;
        int ctr = 0;

        for (int i = 0; i < n; i++) {
            if (intervals[i][0] >= end) {
                ctr++;
                end = intervals[i][1];
            }
        }

        return n - ctr;
    }
}
