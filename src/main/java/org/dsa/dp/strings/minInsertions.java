package org.dsa.dp.strings;

import static org.dsa.dp.strings.lcs.lengthOfLcsPalindrome;

// min insertions required to make a string palindrome
// we takeout the length of lcs which is palindrome and subtract it from s.length()
// because we keep palindrome string intact and copy paste rest of it in reverse
public class minInsertions {

    public static void main(String[] args) {
        String s = "codingninjas";
        int n = s.length();

        int len = lengthOfLcsPalindrome(s);

        System.out.println("min no of insertions: " + (n - len));
    }
}
