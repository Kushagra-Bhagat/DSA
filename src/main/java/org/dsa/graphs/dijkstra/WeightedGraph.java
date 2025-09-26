package org.dsa.graphs.dijkstra;

import org.dsa.graphs.dijkstra.Edge;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {

    private List<List<Edge>> adjList;

    public WeightedGraph(int V) {
        adjList = new ArrayList<>();
        // Initialize adjacency list for each vertex (1-based indexing)
        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add undirected edge (u - v) with weight w
    public void addEdge(int u, int v, int w) {
        adjList.get(u).add(new Edge(v, w));
        adjList.get(v).add(new Edge(u, w));
    }

    public List<List<Edge>> getAdjList() {
        return adjList;
    }
}
