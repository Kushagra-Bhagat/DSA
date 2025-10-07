package org.dsa.greedy;

public class JumpGame {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 4};

        System.out.println(jump(arr));

        // for jump game 2 we need to find min no of jumps required to reach the end
        // input are sure to reach the end
        // can be done recursively and then dp but still can be optimized using dp

        int[] jump = {2, 3, 1, 4, 1, 1, 1, 2};
        System.out.println("min no of jumps to reach the end: " + jumpsTaken(jump));
    }

    public static boolean jump(int[] arr) {

        int n = arr.length;
        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            if (i > maxIdx) {
                return false;
            }
            maxIdx = Math.max(maxIdx, i + arr[i]);

            // further optimization
            if (maxIdx >= n - 1) {
                return true;
            }
        }

        return true;
    }

    // TC -> O(n)
    // SC -> O(1)
    // trying to reach the farthest so under greedy
    public static int jumpsTaken(int[] arr) {

        int n = arr.length;
        int l = 0, r = 0;
        int jump = 0;

        while (r < n - 1) {
            int maxIdx = 0;
            for (int i = l; i <= r; i++) {
                maxIdx = Math.max(maxIdx, i + arr[i]);
            }
            jump++;
            l = r + 1;
            r = maxIdx;
        }

        return jump;
    }
}
