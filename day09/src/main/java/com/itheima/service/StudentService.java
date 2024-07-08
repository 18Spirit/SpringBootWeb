package com.itheima.service;

import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public void getStudents(Student student) {
        //设置插入时间
        student.setCreateTime(LocalDateTime.now());
        //设置更新时间
        student.setUpdateTime(LocalDateTime.now());
        //调用mapper存入数据到数据库
        studentMapper.saveStudents(student);
    }
}
