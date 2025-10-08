package org.dsa.greedy;

import java.util.Arrays;

public class Platform {
    public static void main(String[] args) {

        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1130, 1150, 1200, 1900, 2000};

        System.out.println("platform: " + solution(arr,dep));
    }

    // TC -> O(NlogN + N)
    // SC -> O(1) -> my method will take space but less time maybe
    public static int solution(int[] arr, int[] dep) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int start = 0;
        int end = 0;
        int n = arr.length;
        int cnt = 0;
        int platform = 0;

        while (start < n && end < n) {
            if (arr[start] <= dep[end]) {
                cnt++;
                start++;
            }
            else if (arr[start] > dep[end]) {
                cnt--;
                end++;
            }

            platform = Math.max(platform, cnt);
        }

        return platform;
    }
}
