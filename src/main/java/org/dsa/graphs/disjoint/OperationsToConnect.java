package org.dsa.graphs.disjoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperationsToConnect {

    public static void main(String[] args) {

        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(Arrays.asList(0, 1));
        adjList.add(Arrays.asList(0, 2));
        adjList.add(Arrays.asList(0, 3));
        adjList.add(Arrays.asList(2, 3));
        adjList.add(Arrays.asList(1, 2));

        adjList.add(Arrays.asList(4, 5));
        adjList.add(Arrays.asList(5, 6));

        adjList.add(Arrays.asList(7, 8));

        System.out.println("Minimum no of operation required to connect graph: " + minNoOfOperations(adjList, 8));
    }

    public static int minNoOfOperations(List<List<Integer>> adjList, int V) {

        DisjointSet set = new DisjointSet(V);
        int extraEdges = 0;


        for (List<Integer> edge : adjList) {
            int u = edge.get(0);
            int v = edge.get(1);

            if (set.findUParent(u) == set.findUParent(v)) {
                extraEdges++;
            }
            else {
                set.unionBySize(u, v);
            }
        }

        int components = 0;

        for (int i = 0; i <= V; i++) {
            if (set.findUParent(i) == i) {
                components++;
            }
        }

        if (extraEdges >= components - 1) {
            return components - 1;
        }

        return -1;
    }
}
