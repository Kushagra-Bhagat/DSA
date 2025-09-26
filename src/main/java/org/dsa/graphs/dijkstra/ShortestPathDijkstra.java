package org.dsa.graphs.dijkstra;

import org.dsa.graphs.dijkstra.Edge;
import org.dsa.graphs.dijkstra.NodeDistance;

import java.util.*;

public class ShortestPathDijkstra {

    public static List<Integer> shortestPath(int src, int destination, List<List<Edge>> adjList) {

        int size = adjList.size();
        int[] dist = new int[size];
        int[] parent = new int[size];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }

        PriorityQueue<NodeDistance> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        pq.offer(new NodeDistance(src, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int distance = pq.peek().distance;
            pq.poll();

            if (distance > dist[node]) {
                continue;
            }

            for (int i = 0; i < adjList.get(node).size(); i++) {
                int adjNode = adjList.get(node).get(i).getNode();
                int edgeWeight = adjList.get(node).get(i).getWeight();

                if (edgeWeight + distance < dist[adjNode]) {
                    dist[adjNode] = edgeWeight + distance;
                    parent[adjNode] = node;
                    pq.offer(new NodeDistance(adjNode, dist[adjNode]));
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        if (dist[destination] == Integer.MAX_VALUE) {
            res.add(-1);
            return res;
        }

        res.add(destination);
        int currNode = destination;

        while (dist[currNode] != 0) {
            res.add(parent[currNode]);
            currNode = parent[currNode];
        }

        Collections.reverse(res);

        return res;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Edge>> adjList = new ArrayList<>();

        adjList.add(new ArrayList<>(Arrays.asList(new Edge(1, 4), new Edge(2, 4))));
        adjList.add(new ArrayList<>(Arrays.asList(new Edge(0, 4), new Edge(2, 2))));
        adjList.add(new ArrayList<>(Arrays.asList(new Edge(0, 4), new Edge(1, 2), new Edge(3, 3), new Edge(4, 1), new Edge(5, 6))));
        adjList.add(new ArrayList<>(Arrays.asList(new Edge(2, 3), new Edge(5, 2))));
        adjList.add(new ArrayList<>(Arrays.asList(new Edge(2, 1), new Edge(5, 3))));
        adjList.add(new ArrayList<>(Arrays.asList(new Edge(2, 6), new Edge(3, 2), new Edge(4, 3))));

        int src = 0;
        int destination = 5;

        System.out.println("Shortest path route: " + shortestPath(src, destination, adjList));
    }
}
