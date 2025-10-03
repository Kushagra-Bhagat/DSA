package org.dsa.graphs.mst;

import java.util.*;


class EdgeParent {
    int node;
    int parent;
    int distance;

    public EdgeParent(int node, int parent, int distance) {
        this.node = node;
        this.parent = parent;
        this.distance = distance;
    }
}

public class Prims {

    public static void main(String[] args) {

        int V = 5;
        WeightedGraph graph = new WeightedGraph(V);
        graph.addEdgeUndirectional(0, 1, 2);
        graph.addEdgeUndirectional(0, 2, 1);
        graph.addEdgeUndirectional(1, 2, 1);
        graph.addEdgeUndirectional(2, 4, 2);
        graph.addEdgeUndirectional(2, 3, 2);
        graph.addEdgeUndirectional(4, 3, 1);

        List<List<Edge>> adjList = graph.getAdjList();

        System.out.println("sum of mst: " + sumOfMst(adjList, V));
    }

    public static int sumOfMst (List<List<Edge>> adjList, int V) {

        boolean[] vis = new boolean[V];

        PriorityQueue<EdgeParent> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        pq.offer(new EdgeParent(0, 0, 0));
        int sum = 0;

        WeightedGraph mstGraph = new WeightedGraph(V);

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int parent = pq.peek().parent;
            int distance = pq.peek().distance;
            pq.poll();

            if (vis[node]) {
                continue;
            }

            vis[node] = true;
            sum += distance;

            mstGraph.addEdgeUndirectional(node, parent, distance);

            for (Edge edge : adjList.get(node)) {
                if (!vis[edge.node]) {
                    pq.offer(new EdgeParent(edge.node, node , edge.distance));
                }
            }

        }


        List<List<Edge>> mst = mstGraph.getAdjList();
        for (int i = 0; i < V; i++) {
            System.out.println("For vertex: " + i);
            System.out.print("Edge: " + mst.get(i).toString());
            System.out.println();
        }

        return sum;
    }
}
