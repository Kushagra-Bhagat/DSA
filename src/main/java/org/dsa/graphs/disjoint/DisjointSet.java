package org.dsa.graphs.disjoint;

import java.util.ArrayList;
import java.util.List;

// TC -> O(1) (O(4 alpha))
public class DisjointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();


    public DisjointSet(int n) {

        for (int i = 0; i <= n; i++) {
            rank.add(0);
            size.add(1);
            parent.add(i);
        }
    }

    public int findUParent (int node) {
        if (node == parent.get(node)) {
            return node;
        }

        int uParent = findUParent(parent.get(node));
        parent.set(node, uParent);
        return parent.get(node);
    }

    public void unionByRank (int u, int v) {

        int uPar = parent.get(u);
        int vPar = parent.get(v);

        if (uPar == vPar) {
            return;
        }
        if (rank.get(uPar) < rank.get(vPar)) {
            parent.set(uPar, vPar);
        }
        else if (rank.get(vPar) < rank.get(uPar)) {
            parent.set(vPar, uPar);
        }
        else {
            parent.set(vPar, uPar);
            int uRank = rank.get(uPar);
            rank.set(uPar, uRank + 1);
        }
    }

    public void unionBySize (int u, int v) {

        int uPar = parent.get(u);
        int vPar = parent.get(v);

        if (uPar == vPar) {
            return;
        }
        if (size.get(uPar) < size.get(vPar)) {
            int uSize = size.get(uPar);
            int vSize = size.get(vPar);
            size.set(vPar, uSize + vSize);
            parent.set(uPar, vPar);
        }
        else if (size.get(vPar) <= size.get(uPar)) {
            int uSize = size.get(uPar);
            int vSize = size.get(vPar);
            size.set(uPar, uSize + vSize);
            parent.set(vPar, uPar);
        }
    }

    public static void main(String[] args) {

        DisjointSet set = new DisjointSet(7);
        set.unionByRank(1, 2);
        set.unionByRank(2, 3);
        set.unionByRank(4, 5);
        set.unionByRank(6, 7);
        set.unionByRank(5, 6);

        if (set.findUParent(3) == set.findUParent(7)) {
            System.out.println("same");
        }
        else {
            System.out.println("not same");
        }

        set.unionByRank(3, 7);
        if (set.findUParent(3) == set.findUParent(7)) {
            System.out.println("same");
        }
        else {
            System.out.println("not same");
        }

        DisjointSet set2 = new DisjointSet(7);
        set2.unionBySize(1, 2);
        set2.unionBySize(2, 3);
        set2.unionBySize(4, 5);
        set2.unionBySize(6, 7);
        set2.unionBySize(5, 6);

        if (set2.findUParent(3) == set2.findUParent(7)) {
            System.out.println("same");
        }
        else {
            System.out.println("not same");
        }

        set2.unionBySize(3, 7);
        if (set2.findUParent(3) == set2.findUParent(7)) {
            System.out.println("same");
        }
        else {
            System.out.println("not same");
        }
    }
}
