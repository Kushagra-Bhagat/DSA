package org.dsa.graphs;

import java.util.*;


class Word {
    private String word;
    private int level;

    public Word(String word, int level) {
        this.word = word;
        this.level = level;
    }

    public String getWord() {
        return word;
    }

    public int getLevel() {
        return level;
    }
}

public class WordList {
    public static void main(String[] args) {

        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        String beginWord = "hit";
        String finishWord = "cog";

        System.out.println("No of transformation: " + steps(beginWord, finishWord, wordList));
    }

    // TC -> O(N * 26 * log n) -> log n for set finding word
    public static int steps(String beginWord, String finishWord, String[] wordList) {

        int len = wordList.length;
        Set<String> st = new HashSet<>();
        for (int i = 0; i < len; i++) {
            st.add(wordList[i]);
        }

        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(beginWord, 1));
        st.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.peek().getWord();
            int level = q.peek().getLevel();
            q.poll();

            if (word.equals(finishWord)) {
                return level;
            }

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);

                    if (st.contains(newWord)) {
                        q.offer(new Word(newWord, level + 1));
                        st.remove(newWord);
                    }
                }
            }
        }

        return 0;
    }
}
