package org.basic.streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStreams {
    public static void main(String[] args) {
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();

        long startTime = System.currentTimeMillis();
        list.stream().map(ParallelStreams::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        list.parallelStream().map(ParallelStreams::factorial).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");

        // parallel stream can only be used when our solution isn't dependent on other variables
        // which means it can be parallelized
        // if we have to cumulative sum -> it can be parallelized

        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> sol = num.stream().map(sum::addAndGet).toList();
        System.out.println("Solution without parallel streams: " + sol);
        sol = num.parallelStream().map(sum::addAndGet).toList();
        System.out.println("Solution with parallel streams: " + sol);

        // we can use .sequential() to covert a parallel stream into sequential.

        AtomicInteger sum2 = new AtomicInteger(0);
        startTime = System.currentTimeMillis();
        List<Integer> factAndSum = num.parallelStream()
                .map(ParallelStreams::factorial)
                .sequential()
                .map(sum2::addAndGet)
                .toList();
        endTime = System.currentTimeMillis();
        System.out.println("Sum of factorial: " + factAndSum);
        System.out.println("Time taken with parallel stream: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        factAndSum = num.stream()
                .map(ParallelStreams::factorial)
                .map(sum2::addAndGet)
                .toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken without parallel stream: " + (endTime - startTime) + "ms");

        // in above example parallel streams take more time because data set is too small
        // and there is larger overhead for using threads
    }

    static int factorial(int a) {
        int fact = 1;
        for (int i = 1; i <= a; i++) {
            fact *= i;
        }
        return fact;
    }
}
