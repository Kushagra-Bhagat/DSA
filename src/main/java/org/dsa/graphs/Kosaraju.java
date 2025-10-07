package org.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Kosaraju {

    public static void main(String[] args) {

        List<List<Integer>> adjList = new ArrayList<>();
        int V = 8;

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(2).add(0);
        adjList.get(2).add(3);
        adjList.get(3).add(4);
        adjList.get(4).add(5);
        adjList.get(4).add(7);
        adjList.get(5).add(6);
        adjList.get(6).add(4);
        adjList.get(6).add(7);


        System.out.println("No of strongly connected components: " + scc(adjList));
    }

    private static void dfs(int node, List<List<Integer>> adjList, boolean[] vis, Stack<Integer> st) {

        vis[node] = true;
        for (int adjNode : adjList.get(node)) {
            if (!vis[adjNode]) {
                dfs(adjNode, adjList, vis, st);
            }
        }
        st.push(node);
    }

    private static void dfs2(int node, List<List<Integer>> adjTemp, boolean[] vis) {
        vis[node] = true;
        for (int adjNode : adjTemp.get(node)) {
            if (!vis[adjNode]) {
                dfs2(adjNode, adjTemp, vis);
            }
        }
    }

    // TC -> O(V + E)
    public static int scc(List<List<Integer>> adjList) {

        int n = adjList.size();
        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, adjList, vis, st);
            }
        }

        List<List<Integer>> adjTemp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjTemp.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            vis[i] = false;
            for (int adjNode : adjList.get(i)) {
                adjTemp.get(adjNode).add(i);
            }
        }
        int scc = 0;

        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            if (!vis[node]) {
                scc++;
                dfs2(node, adjTemp, vis);
            }
        }

        return scc;
    }
}
