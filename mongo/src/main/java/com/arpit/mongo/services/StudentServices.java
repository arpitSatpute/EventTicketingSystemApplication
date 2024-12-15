package com.arpit.mongo.services;

import com.arpit.mongo.dto.StudentDto;
import com.arpit.mongo.models.Student;
import com.arpit.mongo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {

    @Autowired
    StudentRepo sr;

    public List<Student> getStudent(){
        return sr.findAll();
    }

    public Student addStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        return sr.save(student);
    }
}
