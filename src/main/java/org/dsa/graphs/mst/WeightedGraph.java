package org.dsa.graphs.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge {
    int node;
    int distance;

    public Edge(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "node=" + node +
                ", distance=" + distance +
                '}';
    }
}

// TC -> O(E * log E) -> log E for priority queue
public class WeightedGraph {

    private List<List<Edge>> adjList;

    public WeightedGraph(int V) {

        adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add undirected edge (u - v) with weight w
    public void addEdge(int u, int v, int w) {

        adjList.get(u).add(new Edge(v, w));
    }

    public void addEdgeUndirectional (int u, int v, int w) {
        adjList.get(u).add(new Edge(v, w));
        if (u != v) {
            adjList.get(v).add(new Edge(u, w));
        }
    }

    public List<List<Edge>> getAdjList() {
        return adjList;
    }
}
