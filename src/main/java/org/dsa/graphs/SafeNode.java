package org.dsa.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SafeNode {

    public static void main(String[] args) {
        int v = 12;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(1);

        adjList.get(1).add(2);

        adjList.get(2).add(3);

        adjList.get(3).add(4);
        adjList.get(3).add(5);

        adjList.get(4).add(6);

        adjList.get(5).add(6);

        adjList.get(6).add(7);

        adjList.get(8).add(1);
        adjList.get(8).add(9);

        adjList.get(9).add(10);

        adjList.get(10).add(8);

        adjList.get(11).add(9);

        System.out.println("List of safe nodes: " + safeNodes(adjList));
    }

    public static List<Integer> safeNodes(List<List<Integer>> adjList) {

        int n = adjList.size();

        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                detectCycle(i, vis, path, check, adjList);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (check[i]) {
                res.add(i);
            }
        }

        return res;
    }

    public static boolean detectCycle(int idx, boolean[] vis, boolean[] path, boolean[] check, List<List<Integer>> adjList) {

        vis[idx] = true;
        path[idx] = true;

        for (int node : adjList.get(idx)) {
            if (!vis[node]) {
                if (detectCycle(node, vis, path, check, adjList)) {
                    return true;
                }
            }
            else if (path[node]) {
                return true;
            }
        }

        check[idx] = true;
        path[idx] = false;
        return false;
    }
}
