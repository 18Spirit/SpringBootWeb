package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MybatisTliasApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(MybatisTliasApplicationTests.class);
    @Autowired
    EmpMapper empMapper;

    @Test
    public void deleteByIdTest() {
        int delete = empMapper.deleteEmpById(16);
        System.out.println("执行了" + delete + "条记录");

    }


    @Test
    public void insertEmp() {
        //构造员工对象
        Emp emp = new Emp();
        emp.setUsername("zhangsan3");
        emp.setPassword("123456");
        emp.setName("张三1");
        emp.setGender((short) 1);
        emp.setImage("16.jpg");
        emp.setJob((short) 2);
        emp.setEntrydate(LocalDate.of(2022, 7, 25));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        //执行插入操作
        int insert = empMapper.insertEmp(emp);

        //主键返回
        System.out.println("插入数据的主键值为：" + emp.getId());
        System.out.println("执行了" + insert + "条记录");
    }

    @Test
    public void getEmpByIdTest() {
        Emp emp = empMapper.getEmpById(1);
        System.out.println("查询结果 ==> " + emp);
    }

    @Test
    public void getEmpByConditionTest() {
        List<Emp> list = empMapper.getEmpByCondition("张", (short) 1, LocalDate.of(2002, 1, 1), LocalDate.of(2020, 1, 1));
        System.out.println("查询结果 == V");
        list.forEach(System.out::println);
    }

    @Test
    public void getEmpListTest() {
        List<Emp> list = empMapper.getAllEmp();
        //list.forEach(System.out::println);
    }

    @Test
    public void getEmpByConditionXMLTest() {
        //List<Emp> list = empMapper.getEmpByConditionXml("张", (short) 1, LocalDate.of(2002, 1, 1), LocalDate.of(2020, 1, 1));

        //测试动态SQL
        List<Emp> list = empMapper.getEmpByConditionXml("张", null, null, null);
        System.out.println("查询结果 == V");
        list.forEach(System.out::println);
    }

    @Test
    public void updateEmpXMLTest() {
        Emp emp = new Emp();
        emp.setId(21);
        emp.setUsername("liuyifei");
        emp.setName("刘亦菲");
        emp.setGender((short) 2);
        emp.setUpdateTime(LocalDateTime.now());

        int update = empMapper.updateEmpXML(emp);
        System.out.println("执行了" + update + "条记录");
    }

    /**
     * 批量删除员工
     */
    @Test
    public void deleteByIds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(22);
        int delete = empMapper.deleteEmpByIdsXML(ids);
        System.out.println("执行了" + delete + "条记录");
    }


    @Test
    public void insertEmpXMLTest() {
        Emp emp = new Emp();

        emp.setUsername("zhangsan3");
        emp.setPassword("123456");
        emp.setName("张三");
        emp.setGender((short) 1);
        emp.setImage("16.jpg");
        emp.setJob((short) 2);
        emp.setEntrydate(LocalDate.of(2022, 7, 25));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        //执行插入操作
        int insert = empMapper.insertEmpXML(emp);

        //主键返回
        System.out.println("插入数据的主键值为：" + emp.getId());
        System.out.println("执行了" + insert + "条记录");
    }
}
