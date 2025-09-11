package org.dsa.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {

        int v = 6;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(2).add(3);

        adjList.get(3).add(1);

        adjList.get(4).add(0);
        adjList.get(4).add(1);

        adjList.get(5).add(0);
        adjList.get(5).add(2);

        System.out.println("Topological sort: " + sort(adjList));
    }

    public static List<Integer> sort(List<List<Integer>> adjList) {

        int n = adjList.size();
        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, vis, st, adjList);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!st.isEmpty()) {
            res.add(st.peek());
            st.pop();
        }

        return res;
    }

    public static void dfs (int idx, boolean[] vis,Stack<Integer> st, List<List<Integer>> adjList) {

        vis[idx] = true;
        for (int node : adjList.get(idx)) {
            if (!vis[node]) {
                dfs (node, vis, st, adjList);
            }
        }

        st.push(idx);
    }

}
