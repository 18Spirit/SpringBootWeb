package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {

    /**
     * 查询所有部门信息
     *
     * @return 部门对象集合
     */
    List<Dept> list();

    /**
     * 根据id删除部门信息
     *
     * @param id 需要删除的部门id
     */
    void deleteDeptById(int id);

    /**
     * 新增部门
     *
     * @param dept 部门对象
     */
    void insertDept(Dept dept);

    /**
     * 修改部门信息
     *
     * @param dept 部门对象
     */
    void updateDept(Dept dept);

    /**
     * 根据id查询部门信息
     *
     * @param id 部门id
     * @return Result对象
     */
    Dept getDeptById(Integer id);
}
