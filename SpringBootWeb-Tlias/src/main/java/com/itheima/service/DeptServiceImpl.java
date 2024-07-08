package com.itheima.service;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询所有部门信息
     *
     * @return 部门对象集合
     */
    @Override
    public List<Dept> list() {
        //通过持久层获取数据库中的Dept对象
        List<Dept> list = deptMapper.listDept();
        return list;
    }

    /**
     * 根据id删除部门信息
     *
     * @param id 需要删除的部门id
     */
    @Override
    public void deleteDeptById(int id) {
        deptMapper.deleteDeptById(id);
    }

    /**
     * 新增部门
     *
     * @param dept 部门对象
     */
    @Override
    public void insertDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insertDept(dept);
    }

    /**
     * 修改部门信息
     *
     * @param dept 部门对象
     */
    @Override
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dept);
    }

    /**
     * 根据id查询部门信息
     *
     * @param id 部门id
     * @return 部门对象
     */
    @Override
    public Dept getDeptById(Integer id) {
        Dept dept = deptMapper.getDeptById(id);
        return dept;
    }
}
