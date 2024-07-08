package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    //需要导入依赖
    //private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门所有信息
     *
     * @return Result对象
     */
    @GetMapping
    public Result listDept() {
        log.info("查询所有部门信息");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 根据id删除部门信息
     *
     * @param id 部门id
     * @return Result对象
     */
    @DeleteMapping("/{id}")
    public Result deleteDeptById(@PathVariable("id") Integer id) {
        log.info("删除id为" + id + "的部门信息");
        deptService.deleteDeptById(id);
        return Result.success();
    }

    /**
     * 新增部门信息
     *
     * @param dept 部门对象
     * @return Result对象
     */
    @PostMapping
    public Result insertDept(@RequestBody Dept dept) {
        log.info("新增部门：{}", dept);
        deptService.insertDept(dept);
        return Result.success();
    }

    /**
     * 修改部门信息
     *
     * @param dept 部门对象
     * @return Result对象
     */
    @PutMapping
    public Result updateDept(@RequestBody Dept dept) {
        deptService.updateDept(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门信息
     *
     * @param id 部门id
     * @return Result对象
     */
    @PostMapping("/{id}")
    public Result getDeptById(@PathVariable("id") Integer id) {
        log.info("查询id为{}的部门信息：", id);
        Dept dept = deptService.getDeptById(id);
        return Result.success(dept);
    }
}
