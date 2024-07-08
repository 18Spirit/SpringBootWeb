package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 返回所有部门信息
     *
     * @return dept对象集合
     */
    @Select("select * from dept")
    List<Dept> listDept();

    /**
     * 根据id删除部门信息
     *
     * @param id
     */
    void deleteDeptById(@Param("id") int id);


    /**
     * 新增部门
     *
     * @param dept
     */
    @Insert("insert into dept(name, create_time, update_time) VALUES (#{name}, #{createTime}, #{updateTime})")
    void insertDept(Dept dept);

    /**
     * 修改部门信息
     *
     * @param dept 部门对象
     */
    void updateDept(Dept dept);

    /**
     * @param id 部门id
     * @return 部门对象
     */
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getDeptById(@Param("id") Integer id);
}
