package org.dsa.graphs;

import java.util.*;

class PairParent {
    int curr;
    int parent;

    public PairParent(int curr, int parent) {
        this.curr = curr;
        this.parent = parent;
    }
}
// Using BFS
public class CyclesInUndirected {

    // TC -> O(V + 2E)
    // SC -> O(n)
    public static boolean isCycle(int start, List<ArrayList<Integer>> adjList, boolean[] vis) {

        Queue<PairParent> q = new LinkedList<>();
        q.offer(new PairParent(start, -1));
        vis[start] = true;

        while(!q.isEmpty()) {
            PairParent pair = q.poll();
            int currNode = pair.curr;
            int parentNode = pair.parent;

            for(int node : adjList.get(currNode)) {
                if(!vis[node]) {
                    vis[node] = true;
                    q.offer(new PairParent(node, currNode));
                }
                else if(node != parentNode) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        List<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).addAll(Arrays.asList(1, 2, 3));
        adj.get(1).addAll(Arrays.asList(0, 2));
        adj.get(2).addAll(Arrays.asList(0, 1));
        adj.get(3).addAll(Arrays.asList(0, 4));
        adj.get(4).addAll(Arrays.asList(3));

        boolean[] vis = new boolean[V];
        boolean cycle = false;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                cycle = isCycle(i, adj, vis);
                if (cycle) {
                    System.out.println("true");
                    break;
                }
            }
        }

        if (!cycle) {
            System.out.println("false");
        }
    }
}
