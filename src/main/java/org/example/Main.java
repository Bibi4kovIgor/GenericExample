package org.example;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("Hello world!");

        MyList<Integer> list = new CustomList<>();
        list.add(132);
        list.add(2);
        list.add(4);
        list.add(44);
        list.add(12);
        System.out.println(list.getElement(0));
        System.out.println(list.getElement(3));
        MyList<Integer> list2 = new CustomList<>(list);
        System.out.println(list2.getAll());
        list.remove(44);
        System.out.println(list.getAll());
        System.out.println(list2.getAll());

    }
}