package com.itheima.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    /**
     * 通过分页插件实现查询
     *
     * @return List集合
     */
    public PageBean list(Integer pageNo, Integer pageSize) {
        //1. 设置分页参数
        PageHelper.startPage(pageNo, pageSize);

        //2. 查询数据
        List<Emp> empList = empMapper.list();

        //3. 将查询结果封装成Page类
        Page<Emp> page = (Page<Emp>) empList;

        //4. 封装PageBean对象
        PageBean pageBean = new PageBean(page.getTotal(), page.getResult());

        return pageBean;
    }


    @Override
    public void deleteEmpByIds(Integer[] ids) {
        empMapper.deleteEmpByIds(ids);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        //1. 查询总记录数
        Long pageNum = empMapper.countEmp();

        //2. 获取分页查询结果
        List<Emp> list = empMapper.pageEmp((page - 1) * pageSize, pageSize);

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(pageNum, list);
        //4. 返回结果
        return pageBean;
    }
}
