package org.dsa.searching;

// Better version of linear search
// O(square root n)
public class JumpSearch {
    static int search(int key, int[] arr) {
        int i, k, m, n;
        n = arr.length;
        i = 0;
        m = (int)Math.sqrt(n);
        k = m;
        while (arr[m] <= key && m < n) {
            i = m;
            m += k;
            if (m > n - 1) {
                return -1;
            }
        }
        for (int j = i; j < m; j++) {
            if (key == arr[j]) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,6,6,6,7,8};
        int result = search(0, arr);
        System.out.println(result);
    }
}
