package org.dsa.stacks;

import java.util.LinkedList;
import java.util.Queue;


// Correct and make it individual
public class StackUsingQueue {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();
    static class UsingPush {
        // O(n)
        static void push(int n) {
            q2.add(n);
            while (!q1.isEmpty()) {
                q2.add(q1.peek());
                q2.remove();
            }
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
        }

        static int pop() {
            if (q1.isEmpty()) {
                return -1;
            }
            int num = q1.peek();
            q1.remove();
            return num;
        }
    }

    static class UsingPop {
        static void push (int n) {
            q1.add(n);
        }
        // O(n)
        static int pop() {
            if (q1.isEmpty()) {
                return -1;
            }
            while (q1.size() != 1) {
                q2.add(q1.peek());
                q1.remove();
            }
            int result = q1.peek();
            q1.remove();
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
            return result;
        }
    }

    public static void main(String[] args) {
        UsingPush.push(1);
        UsingPop.push(2);
        System.out.println(UsingPush.pop());
        System.out.println(UsingPush.pop());
    }
}
