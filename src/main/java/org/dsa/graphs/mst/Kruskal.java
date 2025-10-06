package org.dsa.graphs.mst;

import org.dsa.graphs.disjoint.DisjointSet;

import java.util.*;

// TC -> O(E log V)
// SC -> O(E + V)
public class Kruskal {

    public static void main(String[] args) {

        List<List<Integer>> adjList = new ArrayList<>();

        adjList.add(Arrays.asList(1, 2, 2));
        adjList.add(Arrays.asList(2, 3, 3));
        adjList.add(Arrays.asList(3, 4, 5));
        adjList.add(Arrays.asList(1, 4, 1));
        adjList.add(Arrays.asList(2, 4, 3));
        adjList.add(Arrays.asList(1, 5, 4));
        adjList.add(Arrays.asList(4, 5, 9));
        adjList.add(Arrays.asList(2, 6, 7));
        adjList.add(Arrays.asList(3, 6, 8));

        Kruskal kruskal = new Kruskal();

        System.out.println("sum of mst: " + kruskal.mstSum(adjList, 6));
    }

    public int mstSum (List<List<Integer>> adjList, int V) {

        Collections.sort(adjList, Comparator.comparingInt(x -> x.get(2)));

        DisjointSet set = new DisjointSet(V);
        int sum = 0;
        int count = 0;

        for (List<Integer> edge : adjList) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);

            if (set.findUParent(u) != set.findUParent(v)) {
                set.unionBySize(u, v);
                sum += wt;
                if (++count == V - 1) {
                    break;
                }
            }
        }

        return sum;
    }
}
