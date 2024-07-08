package com.itheima.service;

import com.itheima.pojo.PageBean;


public interface EmpService {
    /**
     * 通过分页插件实现分页查询
     *
     * @param pageNo   当前页码
     * @param pageSize 当前页面记录数
     * @return PageBean对象
     */
    PageBean list(Integer pageNo, Integer pageSize);

    /**
     * 根据id批量删除员工信息
     *
     * @param ids 员工id数组
     */
    void deleteEmpByIds(Integer[] ids);

    /**
     * 分页查询
     *
     * @return
     */
    PageBean page(Integer page, Integer pageSize);
}
