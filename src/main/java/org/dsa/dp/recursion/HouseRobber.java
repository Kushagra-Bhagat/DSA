package org.dsa.dp.recursion;

import java.util.Arrays;

// The diff from max sum of non adj is that array is circular
// So we cannot rob last and first house
public class HouseRobber {

    public static void main(String[] args) {
        int[] ar = {2, 1, 4, 9};
        int[] ar2 = {2, 3, 2};
        int[] dp = new int[ar.length];
        Arrays.fill(dp, -1);
        System.out.println(rob(ar, ar.length - 1, false));
        System.out.println(rob(ar2, ar2.length - 1, false));
//        System.out.println(sumMemo(ar, dp, ar.length - 1));
//        System.out.println(sumTabu(ar));
//        System.out.println(sumOpt(ar));
    }

    // My method but what you can do is basically create two arrays and include 0 - n-2 index
    // and 1 - n-1 index elements and max the solution of both arrays
    // But if you want to write just one function below is the solution
    // this wont work in memoization so standard way is convert it into 2 linear problems
    public static int rob(int[] money, int idx, boolean pickedLast) {
        if (idx == 0) {
            if (!pickedLast) {
                return money[0];
            }
            return 0;
        }
        if (idx < 0) {
            return 0;
        }

        int pick = money[idx];
        if (idx == money.length - 1) {
            pick += rob(money, idx - 2, true);
        }
        else {
            pick += rob(money, idx - 2, pickedLast);
        }

        int notPick = rob(money, idx - 1, pickedLast);
        return Math.max(pick, notPick);
    }

}
