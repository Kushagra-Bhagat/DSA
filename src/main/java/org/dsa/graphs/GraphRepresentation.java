package org.dsa.graphs;

import java.util.ArrayList;

public class GraphRepresentation {

    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        //1--2
        //1--3
        //2--4
        //3--4
        //2--5
        //4--5
    }

    public static void adjMatrix(int n, int m) {

        // because n is 1 based
        int[][] adj = new int[n + 1][n + 1];

        adj[1][2] = adj[2][1] = 1;
        adj[1][3] = adj[3][1] = 1;
        adj[2][4] = adj[4][2] = 1;
        adj[3][4] = adj[4][3] = 1;
        adj[2][5] = adj[5][2] = 1;
        adj[4][5] = adj[5][4] = 1;
    }

    public static ArrayList<ArrayList<Integer>> adjacentList(int n, int m) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(1).add(2);
        adjList.get(2).add(1);

        adjList.get(1).add(3);
        adjList.get(3).add(1);

        adjList.get(2).add(4);
        adjList.get(4).add(2);

        adjList.get(4).add(3);
        adjList.get(3).add(4);

        adjList.get(2).add(5);
        adjList.get(5).add(2);

        adjList.get(4).add(5);
        adjList.get(5).add(4);

        return adjList;
    }

}
