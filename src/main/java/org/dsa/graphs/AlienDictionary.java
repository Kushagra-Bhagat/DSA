package org.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {

        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};

        System.out.println("Order: " + order(dict, 5));
    }

    public static String order (String[] dict, int K) {

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adjList.add(new ArrayList<>());
        }


        for (int i = 0; i < dict.length - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adjList.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(adjList, K);
        StringBuilder res = new StringBuilder();
        for (int it : topo) {
            res.append((char)(it + (int)'a'));
        }

        return res.toString();
    }

    public static List<Integer> topoSort (List<List<Integer>> adjList, int V) {

        int[] inDegree = new int[V];
        for (int i = 0; i < adjList.size(); i++) {
            for (int it : adjList.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for (int it : adjList.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        return res;
    }
}
