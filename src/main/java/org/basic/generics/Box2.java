package org.basic.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box2 {

    // generic constructor
    public <T extends Number> Box2(T value) {

    }

    // we use wildcard ? when there is only read
    public static void test(List<?> array) {
        for (Object value : array) {
            System.out.println(value);
        }
    }

//    public static void test(ArrayList<Integer> array) {
//        System.out.println("This array");
//        for (Integer value : array) {
//            System.out.println(value);
//        }
//    }

    public static void main(String[] args) {
        // has to be wrapper classes
        List<Integer> ar = Arrays.asList(1, 2, 3);
        List<String> words = Arrays.asList("hello", "world");
        Box2.test(ar);
        Box2.test(words);
    }
}
