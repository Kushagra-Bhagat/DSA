package org.dsa.graphs;

// for negative cycle
public class BellmanFordNegCycle {

    static class Edge {
        int src, dest, weight;
    }

    static class Graph {
        int V, E;
        Edge[] edge;
    }

    static Graph createGraph(int V, int E) {
        Graph graph = new Graph();
        graph.V = V;
        graph.E = E;
        graph.edge = new Edge[E];
        for (int i = 0; i < graph.edge.length; i++) {
            graph.edge[i] = new Edge();
        }
        return graph;
    }

    static boolean isNegCycleDisc(Graph g) {
        int V = g.V;
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            if(!visited[i] && BellmanFordNegCycle(g, dist, i)) {
                return true;
            }
            for (int j = 0; j < V; j++) {
                if(dist[j] != Integer.MAX_VALUE) {
                    visited[j] = true;
                }
            }
        }
        return false;
    }

    static boolean BellmanFordNegCycle (Graph graph, int[] dist, int src) {
        int V = graph.V;;
        int E = graph.E;

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < E; j++) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            int u = graph.edge[i].src;
            int v = graph.edge[i].dest;
            int weight = graph.edge[i].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5, E = 8;
        Graph graph = createGraph(V, E);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // Add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // Add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // Add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // Add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // Add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // Add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // Add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        if (isNegCycleDisc(graph))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
