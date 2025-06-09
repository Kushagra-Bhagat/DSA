package org.dsa.recursion;

public class sumOfNaturalNumbers {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Sum: " + sum(n));
    }

    static int sum(int n) {
        if (n == 1) {
            return 1;
        }

        return n + sum(n - 1);
    }
}
