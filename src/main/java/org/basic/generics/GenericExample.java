package org.basic.generics;


import org.basic.generics.example.MyNumber;

// generics used for type safety
// avoid duplicate code
public class GenericExample {
    public static void main(String[] args) {

        MyNumber obj = new MyNumber(5);

        Box<MyNumber> box = new Box<>();
        box.setValue(obj);
        MyNumber val = box.getValue();
        System.out.println("Value in integer box is: " + val.intValue());

        Pair<String, Integer> pair = new Pair<>("Age", 30);
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());

        GenericContainer<Integer> genericContainer = new GenericContainer<>();
        genericContainer.add(10);
        System.out.println("Integer container value: " + genericContainer.get());
    }
}
