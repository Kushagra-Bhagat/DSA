package org.basic.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperations {
    public static void main(String[] args) {
        // they terminate the stream

        // 1. collect()
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        // can use toList() for newer v ersion of java
        List<Integer> collect = nums.stream().filter(x -> x % 2 == 0).toList();
        List<Integer> collect1 = nums.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());

        // 2. forEach()
        nums.stream().forEach(System.out::println);

        // 3. reduce -> combines elements to produce a single result
        Optional<Integer> reduce = nums.stream().reduce((x, y) -> x + y);
        System.out.println(reduce.get());
        Optional<Integer> reduce1 = nums.stream().reduce(Integer::sum);
        System.out.println(reduce1.get());

        // 4. anyMatch, allMatch, noneMatch
        boolean anyMatch = nums.stream().anyMatch(x -> x % 2 == 0);
        boolean allMatch = nums.stream().allMatch(x -> x > 0);
        boolean noneMatch = nums.stream().noneMatch(x -> x < 0);

        // 5. findAny, findFirst
        Optional<Integer> first = nums.stream().findFirst();
        Optional<Integer> any = nums.stream().findAny();


        // Examples
        // Counting occurence of characters
        String s = "hello world";
        // even if we make char array we can't convert char array to stream
        // we have a special function to convert string to stream

        System.out.println(s.chars().filter(x -> x == 'l').count());

        // stateless and stateful
        // stateless -> doesn't know about all other elements eg -> map
        // stateful -> opposite of stateless eg - distinct, sorted

        // 6. forEachOrdered -> we use it as forEach for parallel streams
        System.out.println("Before using for each ordered: ");
        nums.parallelStream().forEach(System.out::println);
        System.out.println("After using for each ordered: ");
        nums.parallelStream().forEachOrdered(System.out::println);
    }
}
