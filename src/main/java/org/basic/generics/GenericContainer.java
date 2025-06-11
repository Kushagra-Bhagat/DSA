package org.basic.generics;

public class GenericContainer<T> implements Container<T> {

    private T value;

    @Override
    public void add(T value) {
        this.value = value;
    }

    @Override
    public T get() {
        return value;
    }
}
