package com.spiritteahouse.springboot.controller._01simpleParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "<h1>Hello Spring</h1>";
    }
}
