package ru.geekbrains.java4.lesson7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.java4.lesson7.entities.Student;
import ru.geekbrains.java4.lesson7.exceptions.StudentNotFoundException;
import ru.geekbrains.java4.lesson7.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getById(id).orElseThrow(() -> new StudentNotFoundException(id.toString()));
    }

    @GetMapping("/ids")
    List<Student> findProductsByIds(@RequestParam List<Long> ids) {
        return studentService.getByIds(ids);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student add(@RequestBody Student student) {
        return studentService.add(student);
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

}
