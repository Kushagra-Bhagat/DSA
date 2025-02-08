package org.dsa.graphs;


import java.util.LinkedList;

// O(V) space complexity
public class CycleInDirectedUsingColors {

    final static int BLACK = 2, GREY = 1, WHITE = 0;
    static class Graph {
        int V;
        LinkedList<Integer>[] adj;

        public Graph(int ver) {
            V = ver;
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
        }
    }

    static void addEdge(Graph g, int u, int v) {
        g.adj[u].add(v);
    }

    static boolean isCyclic(Graph g) {
        int[] color = new int[g.V];
        for (int i = 0; i < color.length; i++) {
            color[i] = WHITE;
        }
        for (int i = 0; i < color.length; i++) {
            if (color[i] == WHITE && DFS(g, color, i)) {
                return true;
            };
        }
        return false;
    }

    static boolean DFS(Graph g, int[] color, int start) {
        color[start] = GREY;
        for (int i : g.adj[start]) {
            if (color[i] == GREY) {
                return true;
            }
            else if (color[i] == WHITE && DFS(g, color, i)) {
                return true;
            }
        }
        color[start] = BLACK;
        return false;
    }
    public static void main(String[] args) {
        Graph g = new Graph(4);
        addEdge(g, 0, 1);
        addEdge(g, 0, 2);
        addEdge(g, 1, 2);
        addEdge(g, 2, 0);
        addEdge(g, 2, 3);
        addEdge(g, 3, 3);
        if (isCyclic(g))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}
