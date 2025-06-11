package org.basic.generics;

public interface Container<T> {

    void add(T value);
    T get();
}
