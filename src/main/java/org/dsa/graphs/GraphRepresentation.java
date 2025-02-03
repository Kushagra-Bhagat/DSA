package org.dsa.graphs;

public class GraphRepresentation {

    // for undirected also do mat[j][i] = 1;
    static void addedge(int[][] mat, int i, int j) {
        mat[i][j] = 1;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] adjMat = new int[4][4];
        addedge(adjMat, 1, 0);
        addedge(adjMat, 1, 2);
        addedge(adjMat, 0, 2);
    }
}
