package org.dsa.greedy;

import java.util.Arrays;
import java.util.Comparator;

// unlike knapsack you can take fraction of a unit as well to satisfy the weight
public class FractionalKnapsack {

    public static void main(String[] args) {

        int[][] ar = {
                {100, 20},
                {60, 10},
                {100, 50},
                {200, 50}
        };

        int wt = 90;

        System.out.println("max sum: " + maxValue(ar, wt));
    }

    public static double maxValue(int[][] ar, int wt) {

        int n = ar.length;
        Arrays.sort(ar, Comparator.comparingDouble(x -> - (double) x[0] / x[1]));

        double sum = 0;
        for (int i = 0; i < n; i++) {
            if (ar[i][1] <= wt) {
                sum += ar[i][0];
                wt -= ar[i][1];
            }
            else {
                sum = sum + (wt * ((double) ar[i][0] / ar[i][1]));
                break;
            }
        }

        return sum;
    }
}
