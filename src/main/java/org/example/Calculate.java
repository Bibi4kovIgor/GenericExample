package org.example;

public interface Calculate<T> {
    T sum(T...args);
    T sub(T...args);
    T mul(T...args);
    T div(T...args);
    T mod(T...args);
}
