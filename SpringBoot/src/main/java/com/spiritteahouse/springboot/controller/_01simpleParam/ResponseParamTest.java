package com.spiritteahouse.springboot.controller._01simpleParam;

import com.spiritteahouse.springboot.controller._02UnitiveParamResponse.Result;
import com.spiritteahouse.springboot.pojo.Address;
import com.spiritteahouse.springboot.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
//@Controller
//@ResponseBody
public class ResponseParamTest {

    // http://localhost:8080/simpleParam?name=胡歌&age=45
    @RequestMapping("/simpleParam")
    public String simpleParam(String name, Integer age) {
        System.out.println(name + " : " + age);
        return "OK";
    }

    // http://localhost:8080/getUser
    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User("胡歌", 42);
        user.setAddress(new Address("上海", "上海"));
        return user;
    }

    // http://localhost:8080/getUser
    @RequestMapping("/getList")
    public List<User> list() {
        User user = new User();
        user.setName("胡歌");
        user.setAge(42);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        return userList;
    }

    // http://localhost:8080/result1
    @RequestMapping("/result1")
    public Result ResultTest1() {
        User user = new User("胡歌", 42);
        user.setAddress(new Address("上海", "上海"));
        //返回数据
        return Result.success(user);
    }

}
