package org.basic.streams;

import java.lang.reflect.Array;
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


        // Example 1 - Collecting names by length
        List<String> list = Arrays.asList("Bob", "Charlie", "Alice", "Aman", "Kushagra", "Amrit");
        System.out.println(list.stream().collect(Collectors.groupingBy(String::length)));

        // Example 2 - Counting word occurrences
        String sentence = "hello world hello java world";
        System.out.println(Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        // Example 3 - Partitioning even and odd numbers
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(list1.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));

        // Example 4 - Summing values in a map
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Apple", 3);
        hashMap.put("Banana", 5);
        hashMap.put("Kiwi", 8);

        System.out.println(hashMap.values().stream().reduce(Integer::sum).get());
        System.out.println("Using Collectors: ");
        System.out.println(hashMap.values().stream().collect(Collectors.summingInt(x -> x)));

        // Example 5 - Convert list to map where values are length of key
        List<String> fruits = Arrays.asList("Apple", "banana", "Cherry", "kiwi");
        System.out.println(fruits.stream().collect(Collectors.toMap(String::toUpperCase, String::length)));

        // Example 6 - Create map for duplicate keys
        fruits = Arrays.asList("Apple", "banana", "Cherry", "kiwi", "apple", "banana", "mango");
        System.out.println(fruits.stream().collect(Collectors.toMap(String::toUpperCase, v -> 1, (x, y) -> x + y)));
    }
}
