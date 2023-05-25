package com.abc.springbootjpahibernatecurdapp.service;

import com.abc.springbootjpahibernatecurdapp.entity.Student;
import com.abc.springbootjpahibernatecurdapp.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
