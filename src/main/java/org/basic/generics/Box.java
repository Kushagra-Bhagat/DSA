package org.basic.generics;

import org.basic.generics.example.Printable;

// extends -> bounded generic
public class Box<T extends Number & Printable> {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
