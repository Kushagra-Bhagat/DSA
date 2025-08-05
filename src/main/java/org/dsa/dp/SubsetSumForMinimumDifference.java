package org.dsa.dp;

// divide array in 2 subsets with minimum absolute difference
public class SubsetSumForMinimumDifference {
    public static void main(String[] args) {
        int[] ar = {3,9,7,3};
        int[] ar2 = {2,-1,0,4,-2,-9};
        int[] ar3 = {-36,36};
        System.out.println("Positive: " + solution(ar));
        System.out.println("Negative: " + solutionNegative(ar));
        System.out.println("Negative: " + solutionNegative(ar2));
        System.out.println("Negative: " + solutionNegative(ar3));
    }

    // only for arrays with positive integers
    public static int solution(int[] ar) {

        int sum = 0;
        for (int val : ar) {
            sum += val;
        }

        boolean[][] dp = new boolean[ar.length][sum + 1];

        for (int i = 0; i < ar.length; i++) {
            dp[i][0] = true;
        }
        if (ar[0] <= sum) {
            dp[0][ar[0]] = true;
        }

        for (int i = 1; i < ar.length; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if (ar[i] <= j) {
                    take = dp[i - 1][j - ar[i]];
                }
                dp[i][j] = take || notTake;
            }
        }

        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            if (dp[ar.length - 1][i]) {
                int s1 = i;
                int s2 = sum - s1;
                int diff = Math.abs(s1 - s2);
                minValue = Math.min(minValue, diff);
            }
        }
        if (minValue == Integer.MAX_VALUE) {
            return -1;
        }
        return minValue;
    }

    // For negative array we calculate minSum and maxSum
    // we move index to -minsum meaning index 0 (sum = 0 means minsum)
    // all sums are between min and max
    // and since we cant have negative index, we have min at index 0
    public static int solutionNegative(int[] ar) {

        int minSum = 0, maxSum = 0, n = ar.length;
        for (int val : ar) {
            if (val > 0)
                maxSum += val;
            else
                minSum += val;
        }

        int range = maxSum - minSum + 1;
        boolean[][] dp = new boolean[n][range];
        for (int i = 0; i < n; i++)
            dp[i][-minSum] = true;

        if (ar[0] - minSum >= 0 && ar[0] - minSum < range)
            dp[0][ar[0] - minSum] = true;

        for (int i = 1; i < n; i++) {
            for (int s = minSum; s <= maxSum; s++) {
                boolean notTake = dp[i - 1][s - minSum];
                boolean take = false;
                int prev = s - ar[i];
                if (prev >= minSum && prev <= maxSum) {
                    take = dp[i - 1][prev - minSum];
                }
                dp[i][s - minSum] = take || notTake;
            }
        }

        int total = 0;
        for (int val : ar)
            total += val;

        int minVal = Integer.MAX_VALUE;
        for (int i = minSum; i <= maxSum; i++) {
            if (dp[n - 1][i - minSum]) {
                int diff = Math.abs((total - i) - i);
                minVal = Math.min(minVal, diff);
            }
        }

        return minVal;
    }
}
