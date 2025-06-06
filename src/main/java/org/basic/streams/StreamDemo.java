package org.basic.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Streams are a way to use functional and declarative programming on a collection, supports various operations
public class StreamDemo {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().filter(x -> x % 2 == 0).count());

        // Stream introduction
        // generating streams
        
        // 1. from list
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();
        
        // 2. from arrays
        int[] nums = {1, 2, 3, 4, 5};
        IntStream stream1 = Arrays.stream(nums);

        // 3. using Stream.of()
        Stream<String> stream2 = Stream.of("a", "b");

        // 4. infinite stream
        Stream.generate(() -> 1).limit(100); // limit to tell the size of stream
        Stream.iterate(1, x -> x + 1).limit(100);
    }
}
