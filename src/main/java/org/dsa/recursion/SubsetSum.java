package org.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// return sum of all subsets of array
public class SubsetSum {
    public static void main(String[] args) {
        int[] ar = {5, 2, 1};
        List<Integer> res = new ArrayList<>();
        subset(0, ar, 0, res);
        Collections.sort(res);
        System.out.println(res);
    }

    public static void subset(int idx, int[] ar, int sum, List<Integer> res) {
        if (idx == ar.length) {
            res.add(sum);
            return;
        }
        //pick the element at index idx
        subset(idx + 1, ar, sum + ar[idx], res);

        //not pick the element at index idx
        subset(idx + 1, ar, sum, res);
    }
}
