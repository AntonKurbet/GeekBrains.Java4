package ru.geekbrains.java4.lesson7.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.java4.lesson7.entities.Student;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByIdIn(List<Long> ids);
}
