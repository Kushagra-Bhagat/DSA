package org.dsa.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CostFlight {
    int step;
    int node;
    int cost;

    public CostFlight(int step, int node, int cost) {
        this.step = step;
        this.node = node;
        this.cost = cost;
    }
}
public class CheapestFlight {
    public static void main(String[] args) {

//        WeightedGraph graph = new WeightedGraph(5);
//        graph.addEdge(0, 1, 5);
//        graph.addEdge(0, 3, 2);
//        graph.addEdge(3, 1, 2);
//        graph.addEdge(1, 4, 1);
//        graph.addEdge(1, 2, 5);
//        graph.addEdge(4, 2, 1);

//        [[1,2,10],[2,0,7],[1,3,8],[4,0,10],[3,4,2],[4,2,10],[0,3,3],[3,1,6],[2,4,5]]
        WeightedGraph graph = new WeightedGraph(4);
        graph.addEdge(1,2,10);
        graph.addEdge(2,0,7);
        graph.addEdge(1,3,8);
        graph.addEdge(4,0,10);
        graph.addEdge(3,4,2);
        graph.addEdge(4,2,10);
        graph.addEdge(0,3,3);
        graph.addEdge(3,1,6);
        graph.addEdge(2,4,5);


        List<List<Edge>> adjList = graph.getAdjList();

        int k = 1;
        int src = 0;
        int destination = 4;

        System.out.println("Minimum cost with k stops: " + minimumCost(adjList, k, src, destination));
    }

    public static int minimumCost(List<List<Edge>> adjList, int k, int src, int destination) {

        int n = adjList.size();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<CostFlight> q = new LinkedList<>();
        q.offer(new CostFlight(0, src, 0));

        while (!q.isEmpty()) {
            int step = q.peek().step;
            int cost = q.peek().cost;
            int node = q.peek().node;
            q.poll();

            if (step > k) continue;

            for (Edge adjNode : adjList.get(node)) {
                if (cost + adjNode.weight < dist[adjNode.node]) {
                    dist[adjNode.node] = cost + adjNode.weight;
                    q.offer(new CostFlight(step + 1, adjNode.node, dist[adjNode.node]));
                }
            }
        }

        if (dist[destination] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[destination];
    }
}
