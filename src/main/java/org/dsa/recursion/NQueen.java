package org.dsa.recursion;

import java.util.Arrays;

public class NQueen {
    public static void main(String[] args) {

        int n = 6;
        int[][] sol = new int[n][n];
        int[] upDiagonal = new int[n + n];
        int[] downDiagonal = new int[n + n];
        int[] leftRow = new int[n];
        NumberOfQueenCombinations(0, n, sol, upDiagonal, downDiagonal, leftRow);
    }

    // We only need to check left side as right is empty any ways
    // Not efficient takes O(n)
    public static boolean isSafe(int row, int col, int[][] sol, int n) {
        boolean safe = true;
        for (int i = 0; i < col; i++) {
            if (sol[row][i] == 1) {
                safe = false;
            }
        }
        for (int i = 1; i <= col; i++) {
            if (row - i >= 0 && col - i >= 0 && sol[row - i][col - i] == 1) {
                safe = false;
            }
            if (row + i < n && col - i >= 0 && sol[row + i][col - i] == 1) {
                safe = false;
            }
        }
        return safe;
    }


    public static void NumberOfQueenCombinations(int col, int n, int[][] sol,
                                                 int[] upDiagonal, int[] downDiagonal, int[] leftRow) {
        if (col >= n) {
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(sol[i]));
            }
            System.out.println();
            return;
        }
        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && downDiagonal[row + col] == 0 && upDiagonal[(n - 1) + (col - row)] == 0) {
                sol[row][col] = 1;
                leftRow[row] = 1;
                downDiagonal[row + col] = 1;
                upDiagonal[(n - 1) + (col - row)] = 1;
                NumberOfQueenCombinations(col + 1, n, sol, upDiagonal, downDiagonal, leftRow);
                sol[row][col] = 0;
                leftRow[row] = 0;
                downDiagonal[row + col] = 0;
                upDiagonal[n - 1 + col - row] = 0;
            }
        }
    }
}
