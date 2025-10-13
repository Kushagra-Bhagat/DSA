package org.dsa.greedy;

public class Parenthesis {
    public static void main(String[] args) {

        String s = "(**(";
        System.out.println(countBrute(s, 0, 0));

        System.out.println(count(s));
    }

    // TC -> O(3^n)
    // SC -> O(n)
    public static boolean countBrute(String s, int idx, int cnt) {
        if (cnt < 0) {
            return false;
        }
        if (idx == s.length()) {
            return cnt == 0;
        }

        if (s.charAt(idx) == '(') {
            return countBrute(s, idx + 1, cnt + 1);
        }
        else if (s.charAt(idx) == ')') {
            return countBrute(s, idx + 1, cnt - 1);
        }
        else {
            boolean res = countBrute(s, idx + 1, cnt + 1) ||
                    countBrute(s, idx + 1, cnt - 1) ||
                    countBrute(s, idx + 1, cnt);
            return res;
        }
    }

    // TC -> O(n)
    // SC -> O(1)
    public static boolean count(String s) {

        int min = 0, max = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                min++;
                max++;
            }
            else if (s.charAt(i) == ')') {
                min--;
                max--;
            }
            else {
                if (min > 1) {
                    min = min - 1;
                }
                max = max + 1;
            }
        }

        if (min <= 0 && max >= 0) {
            return true;
        }
        return false;
    }
}
