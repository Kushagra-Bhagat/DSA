package org.dsa.dp.recursion;

// Memoization - Top down
// Tabulation - Bottom up
// Fibonacci - by not repeating itself
public class Introduction {

    public static void main(String[] args) {
        int n = 4;
        int res = fibonacci(n);
        System.out.println("result using recursion: " + res);
        int[] mem = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            mem[i] = -1;
        }
        System.out.println("Result from memoization: " + fiboMemoization(mem, n));
        System.out.println("Results from tabulation: " + fiboTabulation(n));
        System.out.println("Results after space optimization: " + fiboSpaceOptimize(n));
    }

    // recursion - but we are repeating itself by calculating f(n) multiple times
    // This is what we call overlapping sub problem
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Using memoization
    // Same steps as recursion, but before going for sub problems you check if we have already solved this problem
    // O(n) -> Time complexity
    // O(n) + O(n) -> Space complexity
    public static int fiboMemoization(int[] mem, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (mem[n] != -1) {
            return mem[n];
        }
        mem[n] = fiboMemoization(mem, n - 1) + fiboMemoization(mem, n - 2);
        return mem[n];
    }

    // Start with base case
    // Initialize the array like in memoization and fill base cases
    // Then use for loop to execute your recursive pattern
    // O(n) -> Time and Space complexity
    public static int fiboTabulation(int n) {
        int[] dp = new int[n + 1];
        // Initialize base case
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // O(n) -> Time complexity
    // O(1) -> Space complexity
    public static int fiboSpaceOptimize(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int prev2 = 0;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
