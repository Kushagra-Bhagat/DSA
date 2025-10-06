package org.dsa.graphs.disjoint;

import java.util.*;

public class MergingDetails {

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"));
        accounts.add(Arrays.asList("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"));
        accounts.add(Arrays.asList("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"));
        accounts.add(Arrays.asList("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"));
        accounts.add(Arrays.asList("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co"));

        List<List<String>> res = merge(accounts);

        System.out.println(Arrays.toString(res.toArray()));


    }

    public static List<List<String>> merge(List<List<String>> accounts) {

        int n = accounts.size();

        DisjointSet set = new DisjointSet(n);
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {

                String mail = accounts.get(i).get(j);
                if (!map.containsKey(mail)) {
                    map.put(mail, i);
                } else {
                    set.unionBySize(i, map.get(mail));
                }
            }
        }

        List<List<String>> mergedMail = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            mergedMail.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> it : map.entrySet()) {
            String mail = it.getKey();
            int node = set.findUParent(it.getValue());
            mergedMail.get(node).add(mail);
        }


        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedMail.get(i).size() == 0) {
                continue;
            }
            Collections.sort(mergedMail.get(i));
            String name = accounts.get(i).get(0);
            mergedMail.get(i).add(0, name);
        }

        return mergedMail;
    }
}
