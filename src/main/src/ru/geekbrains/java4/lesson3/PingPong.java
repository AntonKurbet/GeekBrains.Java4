package ru.geekbrains.java4.lesson3;

import java.util.concurrent.atomic.AtomicBoolean;

public class PingPong {
    static class Worker {
        private final boolean state;
        private final String message;
        private final AtomicBoolean flag;

        public Worker(boolean state, AtomicBoolean flag, String message) {
            this.state = state;
            this.message = message;
            this.flag = flag;
        }

        public synchronized void work() {
            while (!Thread.currentThread().isInterrupted()) {
                while (state != flag.get()) {
                    try {
                        Thread.sleep(100 + (long)(100 * Math.random()));
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                System.out.println(message);
                flag.set(!state);
            }
        }
    }

    public static void main(String[] args) {
        AtomicBoolean flag = new AtomicBoolean(true);
        new Thread(() -> new Worker(true, flag, "Ping").work()).start();
        new Thread(() -> new Worker(false, flag, "Pong").work()).start();
    }
}
