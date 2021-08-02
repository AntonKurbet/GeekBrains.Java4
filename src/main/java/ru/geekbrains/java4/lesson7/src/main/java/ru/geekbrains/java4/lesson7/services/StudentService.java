package ru.geekbrains.java4.lesson7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.java4.lesson7.entities.Student;
import ru.geekbrains.java4.lesson7.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Optional<Student> getById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> getByIds(List<Long> ids) {
        return studentRepository.findByIdIn(ids);
    }

    public Student add(Student student) {
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAll() {
        return (List<Student>) studentRepository.findAll();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
