package org.dsa.stacks;

import java.util.*;

// We can use DLL implementation as well
public class PopingMiddleElement {
    Deque<Integer> deque;
    Stack<Integer> stack;

    public PopingMiddleElement() {
        deque = new ArrayDeque<>();
        stack = new Stack<>();
    }

    void add(int n) {
        deque.addLast(n);
        if (deque.size() > stack.size() + 1) {
            int temp = deque.getFirst();
            stack.push(temp);
        }
    }

    void pop() {
        if (!deque.isEmpty()) {
            int temp = deque.getLast();
            System.out.println("Popped element is: " + temp);
        }
        else {
            System.out.println("Stack is empty!");
        }
        if (stack.size() > deque.size()) {
            int temp = stack.pop();
            deque.addFirst(temp);
        }
    }

    int middleElement() {
        return deque.getFirst();
    }

    void deleteMiddleElement() {
        deque.removeFirst();
        if (deque.size() < stack.size()) {
            int temp = stack.pop();
            deque.addFirst(temp);
        }
    }

}
