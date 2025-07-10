package org.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

// subsets that are not duplicate
public class PowerSet {
    public static void main(String[] args) {
        // pass a sorted array
        int[] ar = {1, 2, 2};
        List<Integer> res = new ArrayList<>();
        power(0, ar, res);
    }

    // O(2^n * k) -> k is the average length of res
    // because we are visiting every subset only once even though our branching looks different
    // O(k) average length of res
    public static void power(int idx, int[] ar, List<Integer> res) {
        System.out.println(res);
        for (int i = idx; i < ar.length; i++) {
            if (i > idx && ar[i - 1] == ar[i])
                continue;
            res.add(ar[i]);
            power(i + 1, ar, res);
            res.remove(res.size() - 1);
        }
    }

}
