package ru.geekbrains.java4.lesson5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.geekbrains.java4.lesson5.entity.Student;
import ru.geekbrains.java4.lesson5.repository.StudentRepository;

@SpringBootApplication
public class Lesson5Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson5Application.class, args);

        StudentRepository repo = new StudentRepository();
        repo.setClazz(Student.class);

        for (int i = 1; i <= 10; i++) {
            repo.save(new Student("Name" + i, (int) (100 * Math.random())));
        }

        Student st5 = repo.findById(5);
        System.out.println(st5);
        st5.setName("nameless");
        repo.update(st5);
        Student st6 = repo.findById(6);
        System.out.println(st6);
        repo.remove(st6);
        System.out.println(repo.findAll());

        for (int i = 1; i <= 10000; i++) {
            repo.save(new Student("Name" + i, (int) (100 * Math.random())));
        }
    }

}
