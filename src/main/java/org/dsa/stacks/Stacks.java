package org.dsa.stacks;

public class Stacks {

    final static int MAX_SIZE = 8;
    static int[] stack = new int[MAX_SIZE];

    static int top = -1;

    public static boolean isFull() {
        return top >= MAX_SIZE - 1;
    }

    public static boolean isEmpty() {
        return top == -1;
    }

    public static void push(int val) {
        if (isFull()) {
            System.out.println("Stack is full!");
        }
        else {
            stack[++top] = val;
        }
    }

    public static int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        else {
            int data = 0;
            data = stack[top];
            top--;
            return data;
        }
    }

    public static int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        else {
            return stack[top];
        }
    }

    public static void main(String[] args) {
        peek();
        push(1);
        push(2);
        System.out.println(pop());
        System.out.println(peek());
        push(3);
        System.out.println(pop());
        push(4);
        push(5);
        push(6);
        push(7);
        push(8);
        System.out.println(pop());
        System.out.println(pop());
    }


}
