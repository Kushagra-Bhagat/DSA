package org.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3};
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            map.put(ar[i], false);
        }
        List<Integer> res = new ArrayList<>();
        permutation1(0, map, res , ar);
        System.out.println();
        permutation2(0 , ar);
    }

    // O(n * n!)
    // O(n)
    // using map array (we can also use array based index)
    public static void permutation1(int idx, HashMap<Integer, Boolean> map, List<Integer> res, int[] ar) {
        if (idx == ar.length) {
            System.out.println(res);
            return;
        }

        for (int key : map.keySet()) {
            if (!map.get(key)) {
                res.add(key);
                map.put(key, true);
                permutation1(idx + 1, map, res, ar);
                res.remove(res.size() - 1);
                map.put(key, false);
            }
        }
    }

    // we can use swapping to solve without map array
    // O(n! * n)
    // O(n) -> only for recursions stack and printing array
    public static void permutation2(int idx, int[] ar) {
        if (idx == ar.length) {
            System.out.println(Arrays.toString(ar));
            return;
        }

        for (int i = idx; i < ar.length; i++) {
            swap(ar, idx, i);
            permutation2(idx + 1, ar);
            swap(ar, idx, i);
        }
    }

    public static void swap(int[] ar, int a, int b) {
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }
}
