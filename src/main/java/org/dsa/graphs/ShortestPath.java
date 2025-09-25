package org.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Edge {
    int node;
    int weight;

    public int getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

// TC -> O(V + E)
public class ShortestPath {
    public static void main(String[] args) {

        List<List<Edge>> adjList = new ArrayList<>();
        int V = 7;

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(new Edge(1, 2));

        adjList.get(1).add(new Edge(3, 1));

        adjList.get(2).add(new Edge(3, 3));

        adjList.get(4).add(new Edge(0, 3));
        adjList.get(4).add(new Edge(2, 1));

        adjList.get(5).add(new Edge(4, 1));

        adjList.get(6).add(new Edge(4, 2));
        adjList.get(6).add(new Edge(5, 3));

        int source = 0;
        int[] res = distance(adjList, source);

        for (int i = 0; i < res.length; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        System.out.println("Shortest distance: " + Arrays.toString(res));
    }

    public static int[] distance(List<List<Edge>> adjList, int source) {

        int n = adjList.size();
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                topoSort(i, adjList, vis, st);
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        while (!st.isEmpty()) {
            int node = st.pop();

            if (dist[node] != Integer.MAX_VALUE) {
                for (Edge edge : adjList.get(node)) {
                    int v = edge.getNode();
                    int wt = edge.getWeight();

                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        return dist;
    }

    public static void topoSort(int idx, List<List<Edge>> adjList, boolean[] vis, Stack<Integer> res) {

        vis[idx] = true;

        for (Edge node : adjList.get(idx)) {
            if (!vis[node.getNode()]) {
                topoSort(node.getNode(), adjList, vis, res);
            }
        }

        res.push(idx);
    }
}
