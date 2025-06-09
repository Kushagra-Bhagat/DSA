package org.dsa.recursion;

import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Fibonacci till " + n + " element is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibo(i) + " ");
        }
        System.out.println("\nPrint fibonacci in reverse: ");
        reverseFibo(n, 0, 1);
    }

    static int fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return (fibo(n - 1) + fibo(n - 2));
    }

    //good ques
    static void reverseFibo(int n, int a, int b) {
        if (n > 0) {
            reverseFibo(n - 1, b, a + b);
            System.out.print(a + " ");
        }
    }
}
