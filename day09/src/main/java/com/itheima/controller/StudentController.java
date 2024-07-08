package com.itheima.controller;


import com.itheima.pojo.Student;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    // http://localhost:8080/saveStudent
    @PostMapping("/saveStudent")
    public String getStudents(Student student) {
        studentService.getStudents(student);
        return "添加成功";
    }
}
