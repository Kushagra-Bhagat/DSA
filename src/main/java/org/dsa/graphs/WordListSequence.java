package org.dsa.graphs;

import java.util.*;

public class WordListSequence {

    public static void main(String[] args) {

        String[] wordList = {"pat", "bot", "pot", "poz", "coz"};
        String beginWord = "bat";
        String EndWord = "coz";

        System.out.println("Sequence: " + sequence(wordList, beginWord, EndWord));
    }

    public static List<List<String>> sequence(String[] wordList, String beginWord, String finishWord) {

        Set<String> st = new HashSet<>();

        Collections.addAll(st, wordList);

        Queue<List<String>> q = new LinkedList<>();
        q.offer(new ArrayList<>(Arrays.asList(beginWord)));

        List<List<String>> res = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();

            for (int idx = 0; idx < size; idx++) {
                List<String> seq = q.poll();
                String word = seq.get(seq.size() - 1);
                if (word.equals(finishWord)) {
                    res.add(seq);
                }
                st.remove(word);
                for (int i = 0; i < word.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char[] wordArray = word.toCharArray();
                        wordArray[i] = ch;
                        String newWord = new String(wordArray);
                        if (st.contains(newWord)) {
                            ArrayList<String> newList = new ArrayList<>(seq);
                            newList.add(newWord);
                            q.offer(newList);
                        }
                    }
                }
            }
        }

        return res;
    }
}
