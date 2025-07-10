package org.dsa.recursion;

import java.util.ArrayList;
import java.util.List;


public class CombinationSum {
    public static void main(String[] args) {
        int[] ar = {2, 3, 6, 7};
        int target = 9;
        List<Integer> res = new ArrayList<>();

        comb(0, ar, target, res);

        System.out.println();

        int[] ar2 = {1, 1, 1, 2, 2};
        int target2 = 4;
        List<Integer> res2 = new ArrayList<>();
        comb2(0, ar2, target2, res2);

    }

    // no. can be repeated (extension of subsequence)
    // O(2^t * k)
    // t -> target
    // k -> average time taken to put elements in one DS to another DS, if we use .add()
    // Here question is we can repeat elements at same index
    public static void comb(int idx, int[] ar , int sum, List<Integer> res) {
        if (sum == 0) {
            System.out.println(res);
            return;
        }
        if (idx >= ar.length || sum < 0) {
            return;
        }

        res.add(ar[idx]);
        comb(idx, ar, sum - ar[idx], res);
        res.remove(res.size() - 1);
        comb(idx + 1, ar, sum, res);
    }

    // Here we cannot repeat elements at same index
    // Also, the solution should be unique
    // O(2^n * k)
    // k -> when putting answers in a list
    // O(k * x)
    // x -> no of combinations
    public static void comb2(int idx, int[] ar, int sum, List<Integer> res) {
        if (sum == 0) {
            System.out.println(res);
            return;
        }
        for (int i = idx; i < ar.length; i++) {
            if (i > idx && ar[i] == ar[i - 1]) {
                continue;
            }
            if (ar[i] > sum) {
                break;
            }
            res.add(ar[i]);
            comb2(i + 1, ar, sum - ar[i], res);
            res.remove(res.size() - 1);
        }
    }
}
