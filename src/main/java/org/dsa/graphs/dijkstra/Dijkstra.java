package org.dsa.graphs.dijkstra;



import java.util.*;

class NodeDistance {
    int node;
    int distance;

    public NodeDistance(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

// Using priority queue
// doesn't work for negative weight and cycles with negative weights
// TC -> O(E logV) -> watch video for explanation
public class Dijkstra {

    public static int[] dijkstra(List<List<Edge>> adjList, int src) {

        int n = adjList.size();
        int[] dist = new int[n];
        PriorityQueue<NodeDistance> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new NodeDistance(src, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int distance = pq.peek().distance;
            pq.poll();

            for (int i = 0; i < adjList.get(node).size(); i++) {
                int adjNode = adjList.get(node).get(i).getNode();
                int edgeWeight = adjList.get(node).get(i).getWeight();

                if (distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;
                    pq.offer(new NodeDistance(adjNode, dist[adjNode]));
                }
            }
        }

        return dist;
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

        System.out.println("distance array: " + Arrays.toString(dijkstra(adjList, src)));
    }
}
