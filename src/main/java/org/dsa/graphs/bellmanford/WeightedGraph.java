package org.dsa.graphs.bellmanford;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeightedGraph {

    private List<List<Integer>> adjList;

    public WeightedGraph() {
        adjList = new ArrayList<>();
    }

    // Add undirected edge (u - v) with weight w
    public void addEdge(int u, int v, int w) {
        adjList.add(Arrays.asList(u, v, w));
    }

    public List<List<Integer>> getAdjList() {
        return adjList;
    }
}
