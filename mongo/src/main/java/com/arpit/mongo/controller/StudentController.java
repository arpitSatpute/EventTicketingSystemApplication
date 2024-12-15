package com.arpit.mongo.controller;


import com.arpit.mongo.dto.StudentDto;
import com.arpit.mongo.models.Student;
import com.arpit.mongo.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServices services;


    @GetMapping("/all")
    public List<Student> getStudent(){
        return services.getStudent();
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody StudentDto studentDto) {
        return services.addStudent(studentDto);
    }

}
