package org.dsa.recursion;

// only for small numbers
public class DecToBinary {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Binary of " + n + " is: " + dToB(n));
    }

    static int dToB(int n) {
        if (n == 0) {
            return 0;
        }

        return (10 * dToB(n / 2) + (n % 2));
    }
}
