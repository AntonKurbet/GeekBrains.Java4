package ru.geekbrains.java4.lesson3;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Counter {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private volatile int value = 0;

    public void increment() {
        try {
            lock.writeLock().lock();
            System.out.println("writeLock().lock()");
            value++;
        } finally {
            lock.writeLock().unlock();
            System.out.println("writeLock().unlock()");
        }
    }

    public void decrement() {
        try {
            lock.writeLock().lock();
            value--;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int getValue() {
        try {
            lock.readLock().lock();
            System.out.println("readLock().lock()");
            return value;
        } finally {
            lock.readLock().unlock();
            System.out.println("readLock().unlock()");
        }
    }
}

class Reader {
    private final Counter counter;

    Reader(Counter counter) {
        this.counter = counter;
    }

    public void work() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(100 + (long) (100 * Math.random()));
            } catch (InterruptedException e) {
                return;
            }
            System.out.println(counter.getValue());
        }
    }
}

class Writer {
    private final Counter counter;

    Writer(Counter counter) {
        this.counter = counter;
    }

    public void work() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(300 + (long) (300 * Math.random()));
            } catch (InterruptedException e) {
                return;
            }
            counter.increment();
        }
    }
}


class Test {
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(() -> new Reader(counter).work()).start();
        new Thread(() -> new Writer(counter).work()).start();
        new Thread(() -> new Reader(counter).work()).start();
        new Thread(() -> new Reader(counter).work()).start();
        new Thread(() -> new Writer(counter).work()).start();
    }
}

