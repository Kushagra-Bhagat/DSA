package org.dsa.graphs;

import java.util.*;

public class ShortestPathUnit {
    public static void main(String[] args) {

        List<List<Integer>> adjList = new ArrayList<>();
        int V = 9;

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(1);
        adjList.get(0).add(3);

        adjList.get(1).add(0);
        adjList.get(1).add(2);
        adjList.get(1).add(3);

        adjList.get(2).add(1);
        adjList.get(2).add(6);

        adjList.get(3).add(0);
        adjList.get(3).add(4);

        adjList.get(4).add(3);
        adjList.get(4).add(5);

        adjList.get(5).add(4);
        adjList.get(5).add(6);

        adjList.get(6).add(2);
        adjList.get(6).add(5);
        adjList.get(6).add(7);
        adjList.get(6).add(8);

        adjList.get(7).add(6);
        adjList.get(7).add(8);

        adjList.get(8).add(6);
        adjList.get(8).add(7);

        int source = 0;
        int[] res = distance(adjList, source);

        for (int i = 0; i < res.length; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        System.out.println("Shortest distance: " + Arrays.toString(res));
    }

    public static int[] distance(List<List<Integer>> adjList, int source) {

        int n = adjList.size();
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        q.offer(source);
        dist[source] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int it : adjList.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = 1 + dist[node];
                    // you might revisit node because distance is updated
                    q.offer(it);
                }
            }
        }

        return dist;
    }
}
