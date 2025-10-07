package org.dsa.greedy;

import java.util.Arrays;

public class Cookies {
    public static void main(String[] args) {

        int[] children = {1, 5, 3, 3, 4};
        int[] cookies = {4, 2, 1, 2, 1, 3};

        System.out.println("Max no of children satisfied: " + maxChildrenSatisfied(children, cookies));
    }

    public static int maxChildrenSatisfied(int[] children, int[] cookies) {

        Arrays.sort(children);
        Arrays.sort(cookies);

        int child = 0;
        int childPointer = 0, cookiePointer = 0;

        while (cookiePointer < cookies.length) {

            if (cookies[cookiePointer] >= children[childPointer]) {
                childPointer++;
                child++;
            }
            cookiePointer++;

        }

        return child;
    }
}
