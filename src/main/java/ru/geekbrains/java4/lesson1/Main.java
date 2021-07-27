package ru.geekbrains.java4.lesson1;

public class Main {
    public static void main(String[] args) {
        Person p = new Person.Builder()
                .setFirstName("Anton")
                .setMiddleName("A")
                .setLastName("Kurbet")
                .setGender("M")
                .setAddress("Belgorod")
                .setCountry("Russia")
                .setAge(42)
                .setPhone("+79998887766")
                .build();
        System.out.println(p.toString());
    }
}
