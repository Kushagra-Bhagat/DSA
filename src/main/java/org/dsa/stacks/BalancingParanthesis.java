package org.dsa.stacks;

import java.util.Stack;

public class BalancingParanthesis {
    Stack<Character> stack;

    public BalancingParanthesis() {
        stack = new Stack<>();
    }

    boolean check(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else {
                if (!stack.isEmpty() && ((ch == ')' && stack.peek() == '(') ||
                        (ch == '}' && stack.peek() == '{') ||
                        (ch == ']' && stack.peek() == '['))) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BalancingParanthesis obj = new BalancingParanthesis();
        boolean result = obj.check("]");
        System.out.println(result);
    }
}
