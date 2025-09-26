package org.dsa.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumMultiplication {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(9);
        graph.addEdge(0,1,1);
        graph.addEdge(0,2,2);
        graph.addEdge(0,3,1);
        graph.addEdge(0,4,2);
        graph.addEdge(1,5,2);
        graph.addEdge(2,5,1);
        graph.addEdge(3,5,2);
        graph.addEdge(3,7,3);
        graph.addEdge(3,6,2);
        graph.addEdge(4,6,1);
        graph.addEdge(5,8,1);
        graph.addEdge(7,8,1);
        graph.addEdge(6,8,1);

        List<List<Edge>> adjList = graph.getAdjList();

        int src = 0;
        int destination = 8;

        System.out.println("No of ways: " + ways(adjList, src, destination));
    }

    public static int ways (List<List<Edge>> adjList, int src, int dest) {

        int n = adjList.size();
        int[] dist = new int[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        ways[src] = 1;

        PriorityQueue<NodeDistance> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        pq.offer(new NodeDistance(src, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int distance = pq.peek().distance;
            pq.poll();

            for (Edge adjEdge : adjList.get(node)) {
                int adjNode = adjEdge.node;
                int weight = adjEdge.weight;
                if (weight + distance < dist[adjNode]) {
                    dist[adjNode] = weight + distance;
                    ways[adjNode] = ways[node];
                    pq.offer(new NodeDistance(adjNode, dist[adjNode]));
                }
                else if (weight + distance == dist[adjNode]) {
                    ways[adjNode] += ways[node];
                }
            }
        }

        return ways[dest];
    }
}
