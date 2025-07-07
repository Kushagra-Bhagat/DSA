package org.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

// print all subsequences of an array
// they should be sequence but can skip elements
public class Subsequences {
    public static void main(String[] args) {
        int[] ar = {3, 1, 2};
        List<Integer> res = new ArrayList<>();
        sub(0, ar, res);
    }

    public static void sub (int idx, int[] ar , List<Integer> res) {
        if (idx >= ar.length) {
            System.out.println(res);
            return;
        }

        res.add(ar[idx]);
        sub(idx + 1, ar, res);
        res.remove(res.size() - 1);
        sub(idx + 1, ar, res);
    }
}
