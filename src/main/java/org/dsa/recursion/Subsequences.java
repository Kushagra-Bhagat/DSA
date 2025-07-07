package org.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

// print all subsequences of an array
// they should be sequence but can skip elements
// O(n) -> space complexity
public class Subsequences {
    public static void main(String[] args) {
        int[] ar = {3, 1, 2};
        List<Integer> res = new ArrayList<>();
        sub(0, ar, res);

        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();
        int[] arr = {1,2,1};
        int k = 2;
        List<Integer> res2 = new ArrayList<>();
        subWithSum(0, arr, 0, res2, k);

        System.out.println();
        oneSubWithSum(0, arr, 0, res2, k);

        System.out.println();
        List<Integer> res3 = new ArrayList<>();
        System.out.println(countSubWithSum(0, arr, 0, res3, k));
    }

    // O(2^n * n)
    public static void sub (int idx, int[] ar , List<Integer> res) {
        if (idx >= ar.length) {
            System.out.println(res);
            return;
        }


        // add
        res.add(ar[idx]);
        sub(idx + 1, ar, res);
        // remove the added element
        res.remove(res.size() - 1);
        sub(idx + 1, ar, res);
    }

    // O(2^n * n)
    public static void subWithSum(int idx, int[] ar, int sum, List<Integer> res, int k) {

        if (sum > k) {
            return;
        }

        if (idx >= ar.length) {
            if (sum == k) {
                System.out.println(res);
            }
            return;
        }

        res.add(ar[idx]);
        sum += ar[idx];
        subWithSum(idx + 1, ar, sum, res, k);
        sum -= res.remove(res.size() - 1);
        subWithSum(idx + 1, ar, sum, res, k);
    }

    // O(2^n + n) -> O(2^n) -> because we are only printing the res once
    public static boolean oneSubWithSum(int idx, int[] ar, int sum, List<Integer> res, int k) {

        if (sum > k) {
            return false;
        }

        if (idx >= ar.length) {
            if (sum == k) {
                System.out.println(res);
                return true;
            }
            return false;
        }

        res.add(ar[idx]);
        sum += ar[idx];
        boolean check = oneSubWithSum(idx + 1, ar, sum, res, k);
        if (check == true) {
            return true;
        }
        sum -= res.remove(res.size() - 1);
        return oneSubWithSum(idx + 1, ar, sum, res, k);
    }

    //O(2^n) -> because we are not printing array
    public static int countSubWithSum(int idx, int[] ar, int sum, List<Integer> res, int k) {

        // only if array is of only positive integers
        if (sum > k) {
            return 0;
        }

        if (idx >= ar.length) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }

        res.add(ar[idx]);
        sum += ar[idx];
        int left = countSubWithSum(idx + 1, ar, sum, res, k);
        sum -= res.remove(res.size() - 1);
        int right = countSubWithSum(idx + 1, ar, sum, res, k);
        return left + right;
    }
}
