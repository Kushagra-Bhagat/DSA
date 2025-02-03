package org.dsa.stacks;

import java.util.Stack;

public class ExpressionConversion {

    static int precedence(char ch) {
        if (ch == '^') {
            return 3;
        }
        else if (ch == '/' || ch == '*') {
            return 2;
        }
        else if (ch == '+' || ch == '-') {
            return 1;
        }
        return -1;
    }

    static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '1' && ch <= '9')) {
                result.append(ch);
            }
            else if (ch == '(') {
                stack.push('(');
            }
            else if (ch == ')') {
                while (stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            }
            else {
                while ((!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()))) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    static String infixToPrefix(String s) {
        char[] str = s.toCharArray();
        StringBuilder sNew = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] == '(') {
                str[i] = ')';
            }
            else if (str[i] == ')') {
                str[i] = '(';
            }
            sNew.append(str[i]);
        }
        s = sNew.toString();
        // instead of postfix get nearly postfix
        sNew = new StringBuilder(infixToPostfix(s));
        return sNew.reverse().toString();
    }

    static int evaluatePostfix(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '1' && ch <= '9') {
                stack.push(ch - '0');
            }
            else {
                int a,b;
                switch (ch) {
                    case '+':
                        a = stack.pop();
                        b = stack.pop();
                        result = a + b;
                        stack.push(result);
                        break;
                    case '-':
                        a = stack.pop();
                        b = stack.pop();
                        result = b - a;
                        stack.push(result);
                        break;
                    case '*':
                        a = stack.pop();
                        b = stack.pop();
                        result = a * b;
                        stack.push(result);
                        break;
                    case '/':
                        a = stack.pop();
                        b = stack.pop();
                        result = b / a;
                        stack.push(result);
                        break;
                    case '^':
                        a = stack.pop();
                        b = stack.pop();
                        result = (int) Math.pow(b,a);
                        stack.push(result);
                        break;
                }
            }
        }
        return stack.pop();
    }

    static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
    static String postfixToInfix(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (isOperand(s.charAt(i))) {
                stack.push(s.charAt(i) + "");
            }
            else {
                String op1 = stack.peek();
                stack.pop();
                String op2 = stack.peek();
                stack.pop();
                stack.push("(" + op2 + s.charAt(i) + op1 + ")");
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
        System.out.println(infixToPrefix("a+b*(c^d-e)^(f+g*h)-i"));
        System.out.println(evaluatePostfix("623+-382/+*2^3+"));
        System.out.println(postfixToInfix("abcd^e-fgh*+^*+i-"));
    }
}
