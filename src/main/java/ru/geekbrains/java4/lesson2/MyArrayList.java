package ru.geekbrains.java4.lesson2;

import java.util.Arrays;

public class MyArrayList<T> {
    private static final int INIT_CAPACITY = 5;
    private int size = 0;
    private int capacity = INIT_CAPACITY;

    private T[] data;

    MyArrayList() {
        data = (T[]) new Object[INIT_CAPACITY];
    }

    private void grow() {
        data = Arrays.copyOf(data, size + INIT_CAPACITY);
    }

    public void add(T e) {
        if (size >= capacity) grow();
        data[size] = e;
        size++;
    }

    public T get(int i) {
        if (i < size) return data[i];
        throw new ArrayIndexOutOfBoundsException();
    }

    public void set(int i, T e) {
        if (i < size) data[i] = e;
        throw new ArrayIndexOutOfBoundsException();
    }

    public void add(int i, T e) {
        if (size >= capacity) grow();
        System.arraycopy(data, i, data, i + 1, size - i);
        data[i] = e;
        size++;
    }

    public void remove(int i) {
        if (i >= size) throw new ArrayIndexOutOfBoundsException();
        System.arraycopy(data, i + 1, data, i, size - i);
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]).append(", ");
        }
        sb.append(data[size - 1]).append("]");
        return sb.toString();
    }
}
