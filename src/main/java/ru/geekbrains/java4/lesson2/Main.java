package ru.geekbrains.java4.lesson2;

public class Main {
    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
    }

    private static void testLinkedList() {
        MyLinkedList l = new MyLinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            l.addLast(i);
            System.out.println(l);
        }
        for (int i = 0; i < 5; i++) {
            l.addFirst(i);
            System.out.println(l);
        }
        System.out.println(l.find(1));
        l.addBefore(5);
        System.out.println(l);
        l.addAfter(6);
        System.out.println(l);
        l.remove();
        System.out.println(l);
        l.remove();
        System.out.println(l);
    }

    private static void testArrayList() {
        MyArrayList l = new MyArrayList<Integer>();

        l.add(0);
        for (int i = 1; i < 13; i++) {
            l.add(0, i);
            System.out.println(l);
        }

        for (int i = 5; i < 9; i++) {
            l.remove(i);
            System.out.println(l);
        }
    }
}
