package ru.geekbrains.java4.lesson1;

public class Task3 {
    class Shape {

        int x;
        int y;

        void draw() {
            // some code
        }
    }

    class Circle extends Shape {
        int r;
        @Override
        void draw() {
            // circle draw
        }
    }

    class Square extends Shape {
        int side;

        @Override
        void draw() {
            // square draw
        }
    }

    class Triangle extends Shape {
        @Override
        void draw() {
            // triangle draw
        }
    }
}
