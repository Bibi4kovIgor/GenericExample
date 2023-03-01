package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomList<T> implements MyList<T> {
    private static class Element<T> {
        private final T element;
        private Element<T> next;
        private Element<T> previous;

        public Element(T element, Element<T> next, Element<T> previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }

        public Element(T element) {
            this.element = element;
            next = null;
            previous = null;
        }
    }

    private Element<T> root;
    private int size;

    public CustomList(Element<T> element) {
        this.root = element;
        this.size = 0;
    }

    public CustomList(MyList<T> otherList) {
        this.size = otherList.getSize();
        addAll(otherList);
    }

    public CustomList() {
        this.root = null;
        this.size = 0;

    }

    @Override
    public void add(T element) {
        Element<T> newElement = new Element<>(element);
        size++;
        if (Objects.isNull(root)) {
            root = newElement;
            return;
        }

        Element<T> temp = root;
        while (Objects.nonNull(temp.next)) {
            temp = temp.next;
        }
        temp.next = newElement;
        newElement.previous = temp;
    }

    @Override
    public final void addAll(MyList<T> myList) {
        List<T> elements = myList.getAll();
        elements.forEach(this::add);
    }

    @Override
    public boolean update(int index, T element) {
        return false;
    }

    @Override
    public void remove(T element) {
        Element<T> temp = root;
        while (Objects.nonNull(temp)) {
            if(temp.element.equals(element)) {
                temp.next.previous = temp.previous;
                temp.previous.next = temp.next;
                return;
            }
            temp = temp.next;
        }
    }

    @Override
    public void removeAll() {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T getNext() {
        return null;
    }

    @Override
    public T getPrevious() {
        return null;
    }

    @Override
    public T getElement(int index) throws IllegalAccessException {
        if (index > size) throw new IllegalAccessException("Element not exists");
        Element<T> temp = root;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.element;
    }

    @Override
    public List<T> getAll() {
        List<T> result = new ArrayList<>();
        Element<T> temp = root;
        while (Objects.nonNull(temp)) {
            result.add(temp.element);
            temp = temp.next;
        }
        return result;
    }


}
