package org.dsa.dp.subsequence;

import static org.dsa.dp.subsequence.Subsequence.sumOpt;

// Partition array into two parts with equal sum
// means you need sum/2 for one
public class PartitionSubset {
    public static void main(String[] args) {
        int[] ar = {2, 3, 3, 3, 4, 5};
        int totSum = 0;
        for (int i = 0; i < ar.length; i++) {
            totSum += ar[i];
        }
        if (totSum % 2 != 0) {
            System.out.println("false");
        }
        else {
            System.out.println("Using space optimization: " + sumOpt(ar, totSum));
        }
    }

    // same as subsequence just put a check if sum of all elements is odd, we cannot create two subsets of equal sum
}
