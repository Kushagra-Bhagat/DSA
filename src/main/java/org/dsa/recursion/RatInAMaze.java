package org.dsa.recursion;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        boolean[][] visited = new boolean[mat.length][mat.length];

        path(0, 0, mat, visited, "");

    }

    // We can also use array fo size 4 to make code short for directions
    public static void path(int x, int y, int[][] mat, boolean[][] vis, String path) {
        if (x == mat.length - 1 && y == mat[0].length - 1) {
            System.out.println(path);
            return;
        }

        vis[x][y] = true;

        if (x + 1 != mat.length && mat[x + 1][y] == 1 && !vis[x + 1][y]) {
            path(x + 1, y, mat, vis, path + "D");
        }
        if (y != 0 && mat[x][y - 1] == 1 && !vis[x][y - 1]) {
            path(x, y - 1, mat, vis, path + "L");
        }
        if (y + 1 != mat[0].length && mat[x][y + 1] == 1 && !vis[x][y + 1]) {
            path(x, y + 1, mat, vis, path + "R");
        }
        if (x != 0 && mat[x - 1][y] == 1 && !vis[x - 1][y]) {
            path(x - 1, y, mat, vis, path + "U");
        }
        vis[x][y] = false;
    }
}
