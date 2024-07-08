package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 根据id批量删除员工信息
     *
     * @param ids 员工id数组
     * @return
     */
    @DeleteMapping("/{ids}")
    public Result deleteEmpByIds(@PathVariable("ids") Integer[] ids) {
        log.info("通过id批量删除员工信息:{}", ids);
        empService.deleteEmpByIds(ids);
        return Result.success();
    }

    /**
     * 通过分页插件实现分页查询
     *
     * @return Result对象
     */
    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(empService.list(page, pageSize));
    }


    /**
     * 分页查询
     *
     * @param page     当前页码
     * @param pageSize 当前页面的记录数
     * @return Result对象
     */
    /*@GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        //
        PageBean pageBean = empService.page(page, pageSize);
        return Result.success(pageBean);
    }*/

    /**
     * 通过分页插件实现条件分页查询
     *
     * @return Result对象
     */
    @GetMapping
    public Result listCondition(
            String name,
            Integer gender,
            LocalDate begin,
            LocalDate end,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(empService.list(page, pageSize));
    }
}
