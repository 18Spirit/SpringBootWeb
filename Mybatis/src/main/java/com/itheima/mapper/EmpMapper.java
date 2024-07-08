package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 根据主键删除员工信息
     *
     * @param id 员工的id
     * @return 影响的记录数
     */
    @Delete("delete from emp where id = #{id}")
    int deleteEmpById(@Param("id") int id);


    /**
     * 插入数据，主键返回
     *
     * @param emp 员工信息
     * @return 影响的记录数
     */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into emp(username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time)\n" +
            "VALUES (#{username}, #{password}, #{name}, #{gender}, #{image}, #{job}, #{entrydate},#{deptId}, #{createTime}, #{updateTime})")
    int insertEmp(Emp emp);


    /**
     * 根据id查询员工信息
     *
     * @param id 员工id
     * @return 员工对象
     */
    @Select("select * from emp where id = #{id}")
    Emp getEmpById(Integer id);


    /**
     * @param name   员工名
     * @param gender 员工性别
     * @param start  员工入职时间
     * @param end    员工离职时间
     * @return List集合
     */
    @Select("select *\n" +
            "from emp\n" +
            "where name like concat('%', #{name}, '%')\n" +
            "  and gender = #{gender}\n" +
            "  and entrydate >= #{start}\n" +
            "  and entrydate <= #{end}\n" +
            "order by update_time desc;")
    List<Emp> getEmpByCondition(String name, short gender, LocalDate start, LocalDate end);


    List<Emp> getAllEmp();

    /**
     * 通过xml来配置查询语句
     *
     * @param name   员工姓名
     * @param gender 员工性别
     * @param start  开始时间
     * @param end    结束时间
     * @return 查询员工对象集合
     */
    List<Emp> getEmpByConditionXml(String name, Short gender, LocalDate start, LocalDate end);

    /**
     * 动态更新员工信息
     *
     * @param emp 员工对象
     * @return 影响行数
     */
    int updateEmpXML(Emp emp);

    /**
     * 批量删除员工
     *
     * @param ids 需要删除的员工id
     * @return 影响行数
     */
    int deleteEmpByIdsXML(List<Integer> ids);

    /**
     * 插入数据
     *
     * @param emp 员工对象
     */
    int insertEmpXML(Emp emp);


}
