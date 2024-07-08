package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String no;
    private Integer gender;
    private String phone;
    private Integer degree;
    private Integer violationCount;
    private Integer violationScore;
    private Integer classId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
