package org.dsa.graphs;

import java.util.*;

public class Bipartite {
    public static void main(String[] args) {

        List<List<Integer>> adjList = new ArrayList<>();
        int v = 8;

        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(1).add(2);

        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(2).add(6);

        adjList.get(3).add(2);
        adjList.get(3).add(4);

        adjList.get(4).add(3);
        adjList.get(4).add(5);
        adjList.get(4).add(7);

        adjList.get(5).add(4);
        adjList.get(5).add(6);

        adjList.get(6).add(2);
        adjList.get(6).add(5);

        adjList.get(7).add(4);
        adjList.get(7).add(8);

        adjList.get(8).add(7);

        System.out.println("Bipartite: " + isBipartite(adjList));
    }

    public static boolean isBipartite(List<List<Integer>> adjList) {

        int n = adjList.size();
        int[] colour = new int[n];
        Arrays.fill(colour, -1);

        boolean bfs = false;
        for (int i = 1; i < n; i++) {
            if (colour[i] == -1) {
                if (!bfs(i, colour, adjList)) {
                    bfs = false;
                    break;
                } else {
                    bfs = true;
                }
            }
        }

        Arrays.fill(colour, -1);
        boolean dfs = false;
        for (int i = 1; i < n; i++) {
            if (colour[i] == -1) {
                if (!dfs(i, 0, colour, adjList)) {
                    dfs = false;
                    break;
                } else {
                    dfs = true;
                }
            }
        }

        return bfs && dfs;
    }

    public static boolean bfs(int start, int[] colour, List<List<Integer>> adjList) {

        int n = adjList.size();
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        colour[start] = 0;

        while (!q.isEmpty()) {

            int val = q.remove();
            for (int node : adjList.get(val)) {
                if (colour[node] == -1) {
                    colour[node] = 1 - colour[val];
                    q.offer(node);
                } else if (colour[node] == colour[val]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean dfs(int idx, int color, int[] colour, List<List<Integer>> adjList) {

        colour[idx] = color;

        for (int node : adjList.get(idx)) {
            if (colour[node] == -1) {
                if (!dfs(node, 1 - color, colour, adjList)) {
                    return false;
                }
                else if (colour[node] == color) {
                    return false;
                }
            }
        }

        return true;
    }
}
