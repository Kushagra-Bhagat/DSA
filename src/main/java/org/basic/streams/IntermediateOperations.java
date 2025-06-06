package org.basic.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {

        // Intermediate operation convert streams into modified streams
        // they are lazy and are not executed till terminal operation is mentioned

        // 1. filter
        List<String> names = Arrays.asList("Aryan", "Vishal", "Naveen", "Aryan");
        Stream<String> integerStream = names.stream().filter(x -> x.startsWith("A"));
        // at this point no filtering has happened
        System.out.println(integerStream.count());

        // 2. map
        Stream<String> stringStream = names.stream().map(String::toUpperCase);

        // 3. sorted
        // sorted chronologically
        Stream<String> sorted = names.stream().sorted();
        // you can use comparator to sort based on length
        names.stream().sorted((a, b) -> a.length() - b.length());

        // 4. distinct
        Stream<String> a = names.stream().filter(x -> x.startsWith("A")).distinct();
        System.out.println(a.count());

        // 5. limit
        System.out.println(Stream.iterate(1, x -> x + 1).limit(100).count());

        // 6. skip
        // skip happened first but its infinite so stream starts from 11
        System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(100).count());
        // skip happened after limiting hence count = 90
        System.out.println(Stream.iterate(1, x -> x + 1).limit(100).skip(10).count());
    }
}
