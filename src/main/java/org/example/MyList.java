package org.example;

import java.util.Collection;
import java.util.List;

public interface MyList<T> {
    void add(T element);
    void addAll(MyList<T> elements);
    void remove(T element);
    void removeAll();
    int getSize();
    T getElement(int index) throws IllegalAccessException;
    List<T> getAll();
    T getNext();
    T getPrevious();
    boolean update(int index, T element);
}
