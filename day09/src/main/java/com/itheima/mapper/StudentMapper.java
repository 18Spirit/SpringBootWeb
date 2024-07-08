package com.itheima.mapper;

import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    /**
     * 新增学生信息
     *
     * @return
     */
    void saveStudents(Student student);
}
