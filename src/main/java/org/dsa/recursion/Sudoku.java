package org.dsa.recursion;


// backtracking isValid is naive
// O(n * 9^(n*n)) -> n * n cells if all empty have 9 possibilities each and n for isValid which can be removed
public class Sudoku {
    public static void main(String[] args) {
        int[][] mat = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        if (solve(mat)) {
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static boolean solve(int[][] sud) {
        for (int i = 0; i < sud.length; i++) {
            for (int j = 0; j < sud[0].length; j++) {
                if (sud[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (isValid(i, j, sud, k)) {
                            sud[i][j] = k;
                            if (solve(sud)) {
                                return true;
                            }
                            else {
                                sud[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(int row, int col, int[][] sud, int val) {
        for (int i = 0; i < 9; i++) {
            if (sud[row][i] == val) {
                return false;
            }
            if (sud[i][col] == val) {
                return false;
            }
            if (sud[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val) {
                return false;
            }
        }
        return true;
    }
}
