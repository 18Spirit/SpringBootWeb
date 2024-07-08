package com.spiritteahouse.springboot.controller._01simpleParam;

import com.spiritteahouse.springboot.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController(value = "requestParamTest")
public class RequestParamTest {
    // http://localhost:8080/simpleParam1?name=Tom&age=18
    @RequestMapping("/simpleParam1")
    public String simpleParam1(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name: " + name + ", age: " + age);
        return "字符串类型响应成功";

    }

    // http://localhost:8080/simpleParam2?name=Jack&age=20
    @RequestMapping("/simpleParam2")
    public String SimpleParam2(String name, String age) {
        System.out.println("name: " + name + ", age: " + age);
        return "OK";
    }

    // http://localhost:8080/simpleParam3?username=胡歌&age=45
    @RequestMapping("/simpleParam3")
    public String SimpleParam3(@RequestParam(value = "username") String name, String age) {
        System.out.println("name: " + name + ", age: " + age);
        return "通过SpringBoot测试参数不一致成功运行";
    }

    // http://localhost:8080/simplePojo?name=Clement&age=26
    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        return "实体参数pojo测试成功";
    }

    // http://localhost:8080/complexPojo?name=Clement&age=26&address.province=江西&address.city=南昌
    @RequestMapping("/complexPojo")
    public User complexPojo(@RequestParam User user) {
        System.out.println(user);
        return user;
    }


    // http://localhost:8080/arrayParam?hobby=唱,跳,rap,蓝球
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "数组参数对象测试成功";
    }

    // http://localhost:8080/listParam?hobby=唱,跳,rap,蓝球,music
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "集合参数对象测试成功";
    }

    //TODO http://localhost:8080/date?date=2024-06-10 12:25:30
    @RequestMapping("/date")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
        System.out.println("date:" + date);
        return "date:" + date;
    }

    // http://localhost:8080/jsonParam
    @RequestMapping("/jsonParam")
    public String JSONParam(@RequestBody User user) {
        System.out.println(user);
        return "user";
    }
    /*
    json数据，postman中选择post传输类型
    {
        "name":"张三",
        "age":24,
        "address":{
            "province":"安徽",
            "city":"合肥"
        }
    }
     */

    // http://localhost:8080/path/100
    @RequestMapping("/path/{id}")
    public String pathParam1(@PathVariable(value = "id") Integer id) {
        System.out.println(id);
        return "路径参数1测试成功";
    }

    // http://localhost:8080/path/200/胡歌
    @RequestMapping("/path/{id}/{name}")
    public String pathParam2(@PathVariable("id") Integer id, @PathVariable(value = "name") String name) {
        System.out.println(id + "-" + name);
        return "路径参数2测试成功";
    }

}
