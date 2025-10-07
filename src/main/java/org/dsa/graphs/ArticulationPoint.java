package org.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticulationPoint {

    public static void main(String[] args) {

        List<List<Integer>> connections = new ArrayList<>();
        int n = 5;

        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 4));
        connections.add(Arrays.asList(2, 3));
        connections.add(Arrays.asList(2, 4));
        connections.add(Arrays.asList(3, 4));

        ArticulationPoint point = new ArticulationPoint();

        List<Integer> res = point.criticalConnections(connections, n);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> criticalConnections(List<List<Integer>> connections, int n) {

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            adjList.get(edge.get(0)).add(edge.get(1));
            adjList.get(edge.get(1)).add(edge.get(0));
        }

        int[] vis = new int[n];
        int[] time = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n];

        dfs(0, -1, adjList, vis, time, low, mark);

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mark[i] == 1) {
                res.add(i);
            }
        }

        if (res.size() == 0) {
            res.add(-1);
        }

        return res;
    }

    private int timer = 1;
    public void dfs(int node, int parent, List<List<Integer>> adjList, int[] vis, int[] time, int[] low, int[] mark) {

        vis[node] = 1;
        time[node] = low[node] = timer;
        timer++;
        int child = 0;

        for (int it : adjList.get(node)) {
            if (it == parent) continue;
            if (vis[it] == 0) {
                dfs(it, node, adjList, vis, time, low, mark);
                low[node] = Math.min(low[node], low[it]);

                if (low[it] >= time[node] && parent != -1) {
                    mark[node] = 1;
                }
                child++;
            }
            else {
                low[node] = Math.min(low[node], time[it]);
            }
        }
        if (child > 1 && parent == -1) {
            mark[node] = 1;
        }
    }
}
