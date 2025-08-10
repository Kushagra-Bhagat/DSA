package org.dsa.dp.strings;

import static org.dsa.dp.strings.lcs.countOpt;

public class ConvertString {

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "anc";
        int l1 = s1.length();
        int l2 = s2.length();


        int len = countOpt(s1, s2);
        int op1 = l2 - len;
        int op2 = l1 - len;

        System.out.println("minimum no of operation to covert: " + (op1 + op2));

    }
}
