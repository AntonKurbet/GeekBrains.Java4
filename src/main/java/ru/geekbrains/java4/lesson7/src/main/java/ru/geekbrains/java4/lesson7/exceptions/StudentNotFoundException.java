package ru.geekbrains.java4.lesson7.exceptions;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String msg) {
        super("Student not found:" + msg);
    }
}
