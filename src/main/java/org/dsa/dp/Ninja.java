package org.dsa.dp;

import java.util.Arrays;

public class Ninja {

    public static void main(String[] args) {
        int[][] points = {
                {1, 2, 5}, // day 0
                {3, 1, 1}, // day 1
                {3, 3, 4}  // day 2
        };
        //System.out.println(ninjaMax(points, 0, -1));
        int[][] dp = new int[points.length][4];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("using memoization: " + ninjaMaxMemo(points, dp, 0, 3));
        System.out.println("using tabulation: " + ninjaMaxTabu(points));
        System.out.println("Using space optimization: " + ninjaMaxOpt(points));
    }

    public static int ninjaMax(int[][] points, int idx, int activity) {
        if (idx == points.length) {
            return 0;
        }

        int maxPoints = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != activity) {
                int pick = points[idx][i] + ninjaMax(points, idx + 1, i);
                maxPoints = Math.max(maxPoints, pick);
            }
        }
        return maxPoints;
    }

    // ninjaMaxMemo(points, dp, idx, last) -> gives us value of point of idx day when we cant perform activity last
    public static int ninjaMaxMemo(int[][] points, int[][] dp, int idx, int last) {
        if (idx == points.length) {
            return 0;
        }

        if (dp[idx][last] != -1) {
            return dp[idx][last];
        }

        int maxPoints = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int pick = points[idx][i] + ninjaMaxMemo(points, dp, idx + 1, i);
                maxPoints = Math.max(pick, maxPoints);
            }
        }
        dp[idx][last] = maxPoints;
        return maxPoints;
    }

    // Tabulation is much easier for this for me to understand
    // O(n * 4 * 3) -> time complexity
    // O(n * 4) -> space complexity no stack space
    public static int ninjaMaxTabu(int[][] points) {
        int[][] dp = new int[points.length][4];
        for (int i = 0; i <= 3; i++) {
            dp[0][i] = 0;
            for (int j = 0; j < 3; j++) {
                if (j != i) {
                    dp[0][i] = Math.max(dp[0][i], points[0][j]);
                }
            }
        }

        for (int i = 1; i < points.length; i++) {
            for (int j = 0; j <= 3; j++) {
                dp[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    if (k != j) {
                        // logic -> on day 0 we can chose activity 1 or activity 2
                        // activity 1 + dp[row - 1][1] -> because we know we didn't do activity 1 previously
                        // same for activity 2
                        // solution will be stored in dp[row][0] -> because we didn't do activity 0
                        int val = dp[i - 1][k] + points[i][k];
                        dp[i][j] = Math.max(dp[i][j], val);
                    }
                }
            }
        }
        return dp[points.length - 1][3];
    }

    // O(n) - Time complexity, no space required
    // YOu can also create array of fixed size 4 still O(1) would be the complexity
    public static int ninjaMaxOpt(int[][] points) {
        int first = Math.max(points[0][1], points[0][2]);
        int second = Math.max(points[0][0], points[0][2]);
        int third = Math.max(points[0][0], points[0][1]);
        for (int i = 1; i < points.length; i++) {
            int val1 = Math.max(second + points[i][1], third + points[i][2]);
            int val2 = Math.max(first + points[i][0], third + points[i][2]);
            int val3 = Math.max(first + points[i][0], second + points[i][1]);
            first = val1;
            second = val2;
            third = val3;
        }
        return Math.max(first, Math.max(second, third));
    }
}
