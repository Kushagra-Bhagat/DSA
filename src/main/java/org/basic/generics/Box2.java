package org.basic.generics;

public class Box2 {

    // generic constructor
    public <T extends Number> Box2(T value) {

    }

    public static <T> void test(T[] array) {
        for (T value : array) {
            System.out.println(value);
        }
    }

    public static void test(Integer[] array) {
        System.out.println("This array");
        for (Integer value : array) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        // has to be wrapper classes
        Integer[] ar = {1, 2, 3};
        String[] words = {"hello", "world"};
        Box2.test(ar);
        Box2.test(words);
    }
}
