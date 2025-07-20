package org.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromeSubstring {
    public static void main(String[] args) {
        String s = "baa";
        ArrayList<String> res = new ArrayList<>();
        palindrome(0, s, res);
    }

    public static void palindrome(int idx,
                                  String s,
                                  ArrayList<String> sol) {

        if (idx == s.length()) {
            System.out.println(sol);
        }

        for (int i = idx; i < s.length(); i++) {
            if(isPalindrome(s, idx, i)) {
                sol.add(s.substring(idx, i + 1));
                palindrome(i + 1, s, sol);
                sol.remove(sol.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
