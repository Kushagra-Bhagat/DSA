package org.basic.streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimitiveStream {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5};
        // this is primitve stream unlike Stream<Integer>
        IntStream stream = Arrays.stream(num);

        // use boxed() to make it a Stream<Integer>
        System.out.println(IntStream.range(1, 5).boxed().collect(Collectors.toList()));

    }
}
