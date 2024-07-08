package com.spiritteahouse.springboot.controller;

import com.spiritteahouse.springboot.controller._02UnitiveParamResponse.Result;
import com.spiritteahouse.springboot.pojo.User;
import com.spiritteahouse.springboot.service.UserService;
import com.spiritteahouse.springboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//控制层
@RestController
public class UserController {
    @Autowired
    UserService userService;

    // http://localhost/operatorUser2
    @RequestMapping("/operatorUser2")
    public Result UserOperator() {
        List<User> userList = userService.findAll();

        //通过统一参数响应返回业务层处理后的结果
        return Result.success(userList);
    }
}
