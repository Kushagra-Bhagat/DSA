package org.basic.generics.example;

public class MyNumber extends Number implements Printable{

    private final int VALUE;

    public MyNumber(int VALUE) {
        this.VALUE = VALUE;
    }

    @Override
    public int intValue() {
        return VALUE;
    }

    @Override
    public long longValue() {
        return VALUE;
    }

    @Override
    public float floatValue() {
        return VALUE;
    }

    @Override
    public double doubleValue() {
        return VALUE;
    }

    @Override
    public void print() {
        System.out.println("Value: " + intValue());
    }
}

