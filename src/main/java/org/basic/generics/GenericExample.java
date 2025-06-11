package org.basic.generics;


// generics used for type safety
// avoid duplicate code
public class GenericExample {
    public static void main(String[] args) {

        Box<Integer> box = new Box<>();
        box.setValue(1);
        int val = box.getValue();
        System.out.println("Value in integer box is: " + val);

        Pair<String, Integer> pair = new Pair<>("Age", 30);
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());

        GenericContainer<Integer> genericContainer = new GenericContainer<>();
        genericContainer.add(5);
        System.out.println("Integer container value: " + genericContainer.get());
    }
}
