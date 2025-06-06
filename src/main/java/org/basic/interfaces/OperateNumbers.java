package org.basic.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

// all functional interfaces and their lambdas
public class OperateNumbers{
    public static void main(String[] args) {
        Operate add = (a, b) -> a + b;
        Operate subtract = (a, b) -> a - b;

        System.out.println(add.operate(1, 2));
        System.out.println(subtract.operate(2, 1));

        // Predicate used to check condition
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(2));

        Predicate<String> isStringStartingWithA = x -> x.toLowerCase().startsWith("a");
        Predicate<String> isStringEndingWithA = x -> x.toLowerCase().startsWith("a");
        Predicate<String> and = isStringStartingWithA.and(isStringEndingWithA);

        System.out.println(and.test("Ana"));

        // Takes input and return something
        Function<Integer, Integer> doubleIt = x -> x * 2;
        Function<Integer, Integer> tripleIt = x -> x * 3;

        System.out.println(doubleIt.andThen(tripleIt).apply(20));

        // Takes one input but doesn't return anything
        Consumer<Integer> print = x -> System.out.println(x);
        print.accept(50);

        List<Integer> list = Arrays.asList(1, 2, 3);
        Consumer<List<Integer>> printList = x -> {
            for (int i : x) {
                System.out.println(i);
            }
        };
        printList.accept(list);

        // Takes no input and gives output
        Supplier<String> printHello = () -> "Hello!";
        System.out.println(printHello.get());


        // Combined examples
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 10;

        if (predicate.test(supplier.get())) {
            consumer.accept(function.apply(supplier.get()));
        }

        // There is also unary and binary operators along with Bifunction and etc for 2 inputs

        // method reference can be used to replace lambda in some cases

        List<String> students = Arrays.asList("Ram", "Shyam", "Ghanshyam");
        students.forEach(x -> System.out.println(x));
        // method reference where we dont have to invoke method, we just refer it
        students.forEach(System.out::println);

        // constructor reference -> same as method reference but for constructor
        List<String> phones = Arrays.asList("A", "B", "C");
        phones.forEach(x -> new Phones(x));

        // constructor reference
        // here we wouldn't know obj names so use stream to collect those names as list
        phones.forEach(Phones::new);

        // object names as list
        List<Phones> phoneObjects = phones.stream().map(Phones::new).collect(Collectors.toList());

        // print mobile names via object
        phoneObjects.forEach(x -> System.out.println(x.name));

    }
}

class Phones {
    String name;

    public Phones(String name) {
        this.name = name;
    }
}
