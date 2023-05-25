package com.abc.springbootjpahibernatecurdapp.controller;

import com.abc.springbootjpahibernatecurdapp.entity.Student;
import com.abc.springbootjpahibernatecurdapp.repo.StudentRepository;
import com.abc.springbootjpahibernatecurdapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/createStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student inputStudent) {
        Student newStudent = studentService.saveStudent(inputStudent);

        return ResponseEntity.status(HttpStatus.OK).body(newStudent);
    }

    @GetMapping("/getAllStudent")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> allStudent = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(allStudent);
    }
}
