package org.basic.streams;

import java.net.URLPermission;
import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // 1. collecting as list
        List<String> namesUppercase = names
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(namesUppercase);

        // 2. to find distinct numbers
        List<Integer> nums = Arrays.asList(1, 1, 3, 4, 5, 6, 1, 5, 2, 4);
        // we can use distinct as well or we can just collect as set
        Set<Integer> set = nums.stream().collect(Collectors.toSet());
        System.out.println(set);

        // 3. use any Collection
        LinkedList<Integer> linkedList = nums.stream().collect(Collectors.toCollection(LinkedList::new));
        System.out.println(linkedList.get(1));

        // 4. joining elements as string (concatenate)
        String s = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(s);

        // 5. summarize -> (count, sum, min, average, max)
        IntSummaryStatistics intSummaryStatistics = nums.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Sum: " + intSummaryStatistics.getSum());

        // 6. grouping elements
        List<String> words = Arrays.asList("hello", "best", "world", "kushagra", "ninetendo", "bhagat");
        Map<Integer, List<String>> map1 = words
                .stream()
                .collect(Collectors.groupingBy(String::length));

        Map<Integer, Long> map2 = words
                .stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));

        // sorts based on key values
        TreeMap<Integer, Long> map3 = words
                .stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));

        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);

    }
}
