package org.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphListRepresentation {

    static void addEdge(List<List<Integer>> list, int i, int j) {
        list.get(i).add(j);
        list.get(j).add(i);
    }

    static void displayList(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + ": ");
            for (int j : list.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> list = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }
        addEdge(list, 0, 1);
        addEdge(list, 1, 2);
        displayList(list);
    }
}
