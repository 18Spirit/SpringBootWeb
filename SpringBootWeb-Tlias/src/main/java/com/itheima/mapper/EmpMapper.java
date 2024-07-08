package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface EmpMapper {

    /**
     * 根据id数组删除员工信息
     *
     * @param ids id数组
     */
    void deleteEmpByIds(Integer[] ids);

    /**
     * 查询员工总数
     *
     * @return Long类型的总数
     */
    Long countEmp();

    /**
     * 分页查询
     *
     * @param start    起始索引
     * @param pageSize 当前页面记录数
     * @return List集合
     */
    @Select("select * from emp limit #{start} , #{pageSize}")
    List<Emp> pageEmp(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    /**
     * 通过分页插件实现查询功能
     *
     * @return List集合对象
     */
    @Select("select * from emp")
    List<Emp> list();


    /*List<Emp> listCondition();*/
}
